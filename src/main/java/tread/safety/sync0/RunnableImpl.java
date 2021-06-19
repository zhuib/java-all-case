package tread.safety.sync0;

public class RunnableImpl implements Runnable{

    private  int ticket = 100;

    @Override
    public void run() {
        while (true){
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
