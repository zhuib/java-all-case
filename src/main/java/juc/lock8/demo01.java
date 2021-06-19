package juc.lock8;

import java.util.concurrent.TimeUnit;

public class demo01 {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone1.call();
        },"B").start();
    }
}

// Phone 只有唯一一个class对象
class Phone{

    // synchronized 锁的对象是方法的调用者
    //  static 静态方法 ，类一加载就有了。锁的是Class
    // 静态的同步方法 锁的是 Class 类模板
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");

    }
    // 普通的同步方法 锁的调用者
    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("Hello");
    }

}