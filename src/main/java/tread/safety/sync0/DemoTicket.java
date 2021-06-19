package tread.safety.sync0;

public class DemoTicket {
    public static void main(String[] args) {
        RunnableImpl run = new RunnableImpl();
        Thread t = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);

        t.start();
        t1.start();
        t2.start();

    }
}
