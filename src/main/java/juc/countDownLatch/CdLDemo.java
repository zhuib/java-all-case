package juc.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Date: 2021/4/30 21:29
 * 闭锁 ： 完成一系列事务，再去处理其他事务
 */
public class CdLDemo {

    private static final int count = 6;
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"最后一个离开教室");
    }
}
