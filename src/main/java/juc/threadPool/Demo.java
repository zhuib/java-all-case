package juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors()); //查看几核
//        ExecutorService executor = Executors.newSingleThreadExecutor();  // 只创建一个线程，即池子中只有一个线程
        ExecutorService executor = Executors.newFixedThreadPool(6);  // 固定创建多少个线程
//        ExecutorService executor = Executors.newCachedThreadPool();  // 弹性，不够可以扩容

        for (int i = 1; i <=20 ; i++) {
            // 从池中获取线程
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName() + " ");
            });
        }
        // 关闭线程池
        executor.shutdown();
    }

}
