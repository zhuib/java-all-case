package juc.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 2021/4/30 15:14
 * 可重入锁，即可以从外层锁进入到内层锁，如下的案例：
 * sendSms() sendEmail() 都是 synchronized 锁上的，但是可以sendSms() 进入 sendEmail()，并且还是使用同一把锁（这里指的是一个线程）
 */

class Phone implements Runnable {
    public synchronized void sendSms() {
        System.out.println(Thread.currentThread().getName() + "\t sendSms()");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t sendEmail()");
    }

    // ==========================================================
    @Override
    public void run() {
        get();
    }

    Lock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t sendSms()");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t sendEmail()");
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendSms();
        }, "t1").start();

        new Thread(() -> {
            phone.sendSms();
        }, "t2").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("===============================");

        Thread thread1 = new Thread(phone, "t3");
        Thread thread2 = new Thread(phone, "t4");
        thread1.start();
        thread2.start();

    }
}
