package tread.safety.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable{

    private static int ticket = 100;

    Lock l = new ReentrantLock();

    @Override
    public void run() {
        System.out.println("this"+this);
        while (true){
            l.lock();
            if (ticket > 0){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+"=====》"+ticket+"票数");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    l.unlock();
                }
            }
        }
    }

}
