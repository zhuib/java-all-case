package tread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
/*        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new RunnableImpl());
        pool.submit(new RunnableImpl());
        pool.submit(new RunnableImpl());
        pool.submit(new RunnableImpl());
        pool.submit(new RunnableImpl());*/
    RunnableImpl rb = new RunnableImpl();
    new Thread(rb).start();

    new Thread(()->{
        System.out.println(Thread.currentThread().getName()+"匿名内部类");
    }).start();
    }
}
