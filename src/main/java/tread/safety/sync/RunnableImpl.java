package tread.safety.sync;

public class RunnableImpl implements Runnable{

    private  int ticket = 100;

    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"=====》"+ticket+"票数");
                    ticket--;
                }
            }
        }
    }
}
