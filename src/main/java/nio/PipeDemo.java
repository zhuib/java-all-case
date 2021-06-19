package nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Date: 2021/5/28 15:22
 */
public class PipeDemo {

    @Test
    public void test() throws Exception {
        // 1 获取管道
        Pipe pipe = Pipe.open();

        // 分配指定大小的缓冲区大小
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // 2 将缓冲区中的数据写入管道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        // 3 读取缓冲区的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(),0,len));

        sourceChannel.close();
        sinkChannel.close();
    }
}
