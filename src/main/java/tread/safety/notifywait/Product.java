package tread.safety.notifywait;

public class Product {
    public static void main(String[] args) {
        Object obj = new Object();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        System.out.println("告知老板要的包子的种类和数量");
//                    调用wait方法，放弃cpu执行，进入到WAITING状态（无限等待）
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("开吃！！");
                        System.out.println("=====================================");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
             while (true){

                   try {
                       Thread.sleep(5000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                 synchronized (obj){
                   System.out.println("老板包子做好，告知顾客，可以吃包子了");
                   obj.notify();
               }
           }
            }
        }.start();
    }
}
