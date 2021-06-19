package juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2021/4/30 22:17
 * 信号量：可以增加和减少
 * 多个线程共享多个资源
 * */
public class SPDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) { // 模拟6辆车
            new Thread(()->{
                try {
                    semaphore.acquire();  // 减一
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release(); // 加一
                }
            },String.valueOf(i)).start();
        }
    }
}
