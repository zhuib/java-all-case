package juc.callable;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        new Thread(new Runnable()).start();
//        new Thread(new FutureTask<>()).start();
//        new Thread(new MyRunnable()).start();
//        new Thread().start();
        // callable 不像runnable直接当成thread的参数使用，需要借助Runnable的实现类FutureTask

//        Executors.newFixedThreadPool(10);
//        new ThreadPoolExecutor();
        // 适配器模式
        MyCallable myTread = new MyCallable(); // 被适配
        FutureTask futureTask = new FutureTask<>(myTread); // 适配者
//        FutureTask futureTask1 = new FutureTask<>(myTread); // 适配者
//        new Thread(futureTask1,"A").start();  // 如果是多个线程去启动同一个线程任务，只会返回一次结果，想要返回多次结果，在次 new FutureTask
//        new Thread(futureTask,"A").start();
        new Thread(futureTask,"BB").start();

        String str = (String) futureTask.get();  // 可能会阻塞
        System.out.println(str);
    }
}


class MyCallable implements Callable<String>{

    @Override
    public String call() {
        System.out.println("call()");
        return "hello";
    }
}


/*class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable");
    }*/
//}