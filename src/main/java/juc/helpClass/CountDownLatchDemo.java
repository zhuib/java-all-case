package juc.helpClass;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " -> GO Out");
                downLatch.countDown();  // 执行减一操作
            },String.valueOf(i)).start();
        }

        downLatch.await(); // 等待所有线程都结束

        System.out.println("Close Door");
    }
}
