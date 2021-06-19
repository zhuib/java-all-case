package juc.spinLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Date: 2021/4/30 16:07
 * 自旋锁： CAS 理论 ，采用循环的方式进行，先比较 相等就赋值
 * 通过原子引用类实现，原子包中有CAS 的特性
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t 锁上");
        while (!atomicReference.compareAndSet(null, thread)) {
//            System.out.println(Thread.currentThread().getName() + "等待上一个线程释放锁");
        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t 解锁");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        }, "t1").start();

        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnLock();
        }, "t2").start();
    }
}
