package juc.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 精确唤醒，
 * 通过 Condition 条件去唤醒相应的线程
 */
public class demo01 {
    public static void main(String[] args) {
//        查看有多少个线程，本机上的
        System.out.println(Runtime.getRuntime().availableProcessors());
        A a = new A();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                    a.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                a.printB();
            }
        },"B").start();;
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                a.printC();
            }
        },"C").start();;
    }
}

class A{

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (number!=1){ //等待
                condition1.await();
            }
            number =2;
            System.out.println(Thread.currentThread().getName()+ "=> number= " + number + "=> AAAAAA");
            condition2.signal();// 唤醒
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            // 业务 判断 -> 执行 -> 通知
            while (number!=2){ //等待
                condition2.await();
            }
            number =3;
            System.out.println(Thread.currentThread().getName()+ "=> number= " + number + "=> BBBBBB");
            condition3.signal();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } finally { // 唤醒

            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (number!=3){ //等待
                condition3.await();
            }
            number =1;
            System.out.println(Thread.currentThread().getName()+ "=> number= " + number + "=> CCCCCC");
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally { // 唤醒

            lock.unlock();
        }
    }

}

