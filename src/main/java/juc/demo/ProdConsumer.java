package juc.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 2021/4/30 23:23
 * 操作线程一般操作
 * 1        线程        操作（方法）      资源类
 * 2        判断        干活             通知
 * 3        防止虚假唤醒机制（操作线程的判断使用while不使用if（在只有两个线程时不会出现错误，多个线程就会出现错误））
 */

class ShareData{
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private int num = 0;

    public void increment() {
        lock.lock();
        try {
            // 判断
            while (num != 0) {
                // 等待，不能生产
                condition.await();
            }
            // 干活
            num++;
            System.out.println(Thread.currentThread().getName()+" \t" + num);
            // 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+" \t" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ProdConsumer {

    // 高内聚： 面向对象编程中，对象的特有属性在类中。如空调 空调本身应该具备 升高温度和减低温度功能，而这样的功能就必须在类中
    // 包含着
    // 低耦合： 尽量减低不同类之间的关系

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, "BBB").start();
    }



}
