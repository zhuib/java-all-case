package tread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyTread mt = new MyTread();
        mt.setName("zhangsan");
        String name = mt.currentThread().getName();
        mt.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(name+" ---->"+i);
            mt.sleep(1000);
        }

        new MyTread("haha").start();
    }
}
