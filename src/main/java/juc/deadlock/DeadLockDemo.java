package juc.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2021/5/19 19:45
 */

class DeadHoldLock implements Runnable{
    private String lockA;
    private String lockB;

    public DeadHoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() +"\t 持有 " + lockA +"想要获取 " + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() +"\t 持有 " + lockB +"想要获取 " + lockA);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
         String lockA = "LockA";
         String lockB = "LockB";

         new Thread(new DeadHoldLock(lockA,lockB),"LockAAAA").start();
         new Thread(new DeadHoldLock(lockB,lockA),"LockBBBB").start();
    }
}
