package nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * Date: 2021/5/28 0:22
 *
 * 通道（Channel）： 用于源节点与目标节点的连接。在Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输
 *
 * 获取通道 Java 针对支持通道的类提供了 getChannel() 方法
 * 本地 IO
 *      FileInputStream/ FileOutputStream
 *      RandomAccessFile
 *
 * 网络 IO
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *
 *  在 JDK 1.7 中的NIO.2 针对各个通道提供了静态方法 open()
 *  在 JDK 1.7 中的NIO.2 的Files 工具类 的newByteChannel
 *
 *
 * 通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 分散（Scatter） 与 聚集（Gather）
 * 分散读取（Scattering Reads） ： 将通道中的数据分散到多个缓冲区中
 * 分散读取（Scattering Reads） ： 将多个缓冲区中数据聚集到通道中
 */
public class ChannelDemo {

    @Test
    public void test6() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");

        // 获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        // 获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("天天向上哦！ ");
        cBuf.flip();

        // 编码
        ByteBuffer bBuf = ce.encode(cBuf);

        for (int i = 0; i < 12; i++) {
            System.out.println(bBuf.get());
        }

        // 解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());

        System.out.println("==================================");
        // 其他字符集 解码会出现乱码
        Charset cs2 = Charset.forName("UTF-8");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }
    @Test
    public void test5() {
        // 字符集
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> sets = map.entrySet();
        
        sets.forEach((set)->{
            System.out.println(set.getKey() + " = " + set.getValue());
        });
    }
    // 分散 和聚集
    @Test
    public void test4() throws IOException {
        // 分散读取
        RandomAccessFile raf1 = new RandomAccessFile("a.txt", "rw");
        // 获取通道
        FileChannel channel = raf1.getChannel();

        // 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(2048);

        // 分散读取
        ByteBuffer[] bufs = {buf1,buf2};
        channel.read(bufs);

        for (ByteBuffer buf : bufs) {
            buf.flip();
        }

        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("==========================");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

        // 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("c.txt", "rw");
        FileChannel channel1 = raf2.getChannel();

        channel1.write(bufs);
    }
    @Test
    public void test3() throws IOException {
        // 通道之间的数据传输（直接缓冲区）
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

//        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }
    @Test
    public void test2() throws IOException {
        // 使用直接缓冲区完成文件的复制（内存映射文件）
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        // 内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();
    }
    @Test
    public void test1() {
//        利用通道完成文件的复制
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream("1.jpg");
            fos = new FileOutputStream("2.jpg");

            // 1 获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            // 2 分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

//            3 将通道中的数据存入缓冲区中
            while (inChannel.read(buf) != -1) {
                buf.flip(); // 切换读取数据的模式

//                4 将缓冲区中的数据写入通道中
                outChannel.write(buf);
                buf.clear();  // 清空缓冲区
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
