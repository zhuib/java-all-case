package juc.blockqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

// 同步队列 ： 类似于生产者与消费者 同一时间只能有一个线程去执行 生产，然后必须是消费后 才能再继续生产
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " = >T1 put");
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName() + " = >T1 put");
                synchronousQueue.put("b");
                System.out.println(Thread.currentThread().getName() + " = >T1 put");
                synchronousQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"T1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "=>" + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "=>" + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + "=>" + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
