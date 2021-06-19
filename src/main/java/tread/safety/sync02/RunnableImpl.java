package tread.safety.sync02;

public class RunnableImpl implements Runnable{

    private static int ticket = 100;

    @Override
    public void run() {
        System.out.println("this"+this);
        while (true){
//            payTicket();
            payTicketStatic();
        }
    }


    public static /*synchronized*/ void payTicketStatic(){
        synchronized (RunnableImpl.class){
        if (ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"=====》"+ticket+"票数");
            ticket--;
        }}
    }

/*    public synchronized void payTicket(){
        if (ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"=====》"+ticket+"票数");
            ticket--;
        }
    }*/
}
