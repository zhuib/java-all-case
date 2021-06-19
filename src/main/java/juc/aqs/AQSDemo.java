package juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 2021/5/25 0:45
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        // 使用银行办理业务的案例来模拟 AQS如何进行线程管理和通知唤醒机制
        // 三个线程模拟3个银行网点，受理窗口办理业务的顾客
        // A 顾客就是第一个顾客，此时受理窗口没有任何人，A可以直接去办理
        new Thread(()->{
             lock.lock();
              try {
                  System.out.println("--------------A thread come in");
                  // 暂停几秒钟线程
                  try{ TimeUnit.MINUTES.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
              }finally {
                  lock.unlock();
              }
        },"A").start();

        // 第2个顾客，第二个线程 -------> ,由于受理业务的窗口只有一个（只能一个线程次有锁），此时B只能等待
        // 进入候客区
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("-------------B thread come in");
            }finally {
                lock.unlock();
            }
        },"B").start();

        // 第2个顾客，第二个线程 -------> ,由于受理业务的窗口只有一个（只能一个线程次有锁），此时B只能等待
        // 进入候客区
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("--------------C thread come in");
            }finally {
                lock.unlock();
            }
        },"C").start();
    }
}
