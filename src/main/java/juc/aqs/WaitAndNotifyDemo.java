package juc.aqs;

/**
 * Date: 2021/5/24 17:21
 * wait和notify 方法必须要在同步代码块或者方法里面并且成对出现使用
 * 先wait后notify 才不会报错
 * 要求：t1 线程等待3秒钟，3秒钟后t2线程唤醒t1线程继续工作
 * wait方法和notify方法，两个都去掉同步代码块后看运行效果
 *报错
 * Exception in thread "t1" Exception in thread "t2" java.lang.IllegalMonitorStateException
 * java.lang.IllegalMonitorStateException
 *
 * 结论：
 * Object类中的wait 、notify notifyAll用于线程等待和唤醒方法，都必须在synchronized 内部执行（必须用到关键字synchronized）
 */
public class WaitAndNotifyDemo {
    static Object objectLock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t -----------come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +"\t --------------被唤醒");
        },"t1").start();
        new Thread(()->{
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() +"\t --------------通知");
            }
        },"t2").start();
    }
}
