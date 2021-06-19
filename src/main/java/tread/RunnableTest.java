package tread;

public class RunnableTest {
    public static void main(String[] args) {
        MyRunnable rb = new MyRunnable();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"======"+i);
                }
            }
        }.start();




        new Thread( new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"======"+i);
                }
            }
        }).start();


        new Thread(rb).start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"======"+i);
        }
    }
}
