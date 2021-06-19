package tread;

import java.security.PublicKey;

public class MyTread extends Thread {

    public MyTread(){}
    public MyTread(String name){
        super(name);
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {

            System.out.println(name+" ---->"+i);
        }
    }
}
