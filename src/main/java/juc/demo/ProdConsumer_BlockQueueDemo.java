package juc.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Date: 2021/5/19 10:56
 */

class MyResource {
    private volatile boolean FLAG = true; // 默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    //    接口的使用，给别人调用都是接口层次的调用，根据参数，来判断具体的类
    BlockingQueue<String> blockingQueue = null;

    // 构造注入传接口 可实现多中类型的使用 ，使用性 扩展性增强
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName()); // 打印是谁调用接口
    }

    // 生产
    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS); //取数据
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1); // 1秒打印一次
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产， 表示FLAG = false， 生产动作结束");
    }

    // 消费
    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L,TimeUnit.SECONDS); // 消费数据
            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() +"\t 超过2秒没有取到，消费退出");
                System.out.println();
                System.out.println();
                return; // 跳出循环
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }
    }

    public void stop () {
        FLAG = false;
    }
}

public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) throws Exception{
        MyResource myResource = new MyResource( new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动成功");
            try {
                myResource.myProd();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动成功");
            System.out.println();
            System.out.println();
            try {
                myResource.myConsumer();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        // 5秒后活动结束
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + "\t 活动结束");
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
