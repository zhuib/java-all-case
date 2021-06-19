package nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Date: 2021/5/27 16:45
 *
 *
 * mark : 标记，表示记录当前position 的位置。可以通过reset() 恢复到mark 的位置
 *     private int mark = -1;
 *     private int position = 0;
 *     private int limit;
 *     private int capacity;
 *
 * 0 <= mark <= position <= limit <= capacity
 */
public class BufferDemo {

    @Test
    public void test3() {
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());

    }
    @Test
    public void test2() {
        String str = "abcde";

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());

        buffer.flip();

        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buffer.position());

        // mark() : 标记
        buffer.mark();

        buffer.get(dst,2,2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buffer.position());

        // reset() : 恢复到 mark 的位置
        buffer.reset();
        System.out.println(buffer.position());

        // 判断是否还有数据
        if (buffer.hasRemaining()) {
            // 可读数据是多少
            System.out.println(buffer.remaining());
        }

    }
    @Test
    public void test1() {
        String str = "abcde";
        // 分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("-----------------allocate()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 存入数据到缓冲区中
        buffer.put(str.getBytes());
        System.out.println("-----------------put()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 切换读取数据模式
        buffer.flip();
        System.out.println("-----------------flip()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit()); // 限制读取数据
        System.out.println(buffer.capacity());

        // 读取缓冲区中的数据
        byte[] std = new byte[buffer.limit()];
        buffer.get(std);
        System.out.println("-----------------get()-------------------");
        System.out.println(new String(std,0,std.length));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 可重复读
        buffer.rewind();
        buffer.get(std);
        System.out.println("-----------------rewind()-------------------");
        System.out.println(new String(std,0,std.length));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // 清空缓冲区，但是缓冲区中的数据依然存在，但是处于“被遗忘”状态
        buffer.clear();
        System.out.println("-----------------clear()-------------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
    }
}
