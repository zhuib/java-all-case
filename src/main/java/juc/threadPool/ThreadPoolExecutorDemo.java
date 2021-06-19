package juc.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        // 有七个参数
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                1,
                1,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),  // 阻塞队列
                Executors.defaultThreadFactory(), //
//                new ThreadPoolExecutor.AbortPolicy() // 会报错
//                new ThreadPoolExecutor.CallerRunsPolicy()
//                new ThreadPoolExecutor.DiscardPolicy()
                 new ThreadPoolExecutor.DiscardOldestPolicy() //
        );

        for (int i = 1; i < 10; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + " ");
            });
        }

        // 关闭池
        threadPool.shutdown();
    }
}
