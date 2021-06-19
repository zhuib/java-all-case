package juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Date: 2021/5/24 23:27
 *
 * LockSupport是用来创建锁和其他同步类的基本线程阻塞原语
 * LockSupport 类使用了一种名为Permit（许可） 的概念来做到阻塞和唤醒线程的功能，每个线程都有一个许可（Permit）
 * permit只有两个值 1和 0，默认是零
 * 可以把许可看成是一种（0，1）信号量（Semaphore），但与Semaphore 不同的是，许可的累加上限是1
 *
 * pack()/park(Object object) : 阻塞当前线程/ 阻塞传入的具体线程
 * unpack(Thread thread) : 唤醒处于阻塞状态的指定线程
 *
 *
 * LockSupport 是一个线程阻塞工具类，所有的方法都是静态方法，可以让线程在任意位置阻塞，阻塞之后也有对应的唤醒方法。归根结底，LockSupport调用的Unsafe中的native代码
 *
 * LockSupport 提供park和unpark方法实现阻塞线程和解除线程阻塞的过程
 * LockSupport 和每个使用它的线程都有一个许可（permit）关联，permit相当于1，0的开关，默认是 0
 * 调用一次unpark就加 1 变成1
 * 调用一次park会消费permit，也就是将1变成0，同时park立即返回
 * 如果再次调用park会变成阻塞（因为permit为零了会阻塞在这里，一直到permit变为1）这时调用unpack会把permit置为1
 * 每个线程都有一个相关的permit，permit最多只有一个，重复调用unpark也不会积累凭证
 *
 * 形象的理解
 * 线程阻塞需要消耗凭证（permit） 这个凭证最多只有一个
 * 当调用pack方法时
 * 如果有凭证，则会直接消耗掉这个凭证然后正常退出
 * 如果无凭证，就必须阻塞等待凭证可用
 *
 * 而unpack则相反，他会增加一个凭证，但凭证最多只能有1 个，累加无效
 *
 * 面试题
 * 为什么可以先唤醒线程后阻塞线程
 * 因为unpack获得了一个凭证，之后再调用pack方法，就可以名正言顺的凭证消费，故不会阻塞
 *
 * 为什么唤醒两次后阻塞两次，但最终结果还会阻塞线程？
 * 因为凭证的数量最多为 1，连续调用两次unpack和 调用一次unpack效果一样，只会增加一个凭证
 * 而调用两次park却需要消费两个凭证，证不够，不能放行
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
//            try {TimeUnit.SECONDS.sleep(1); } catch (Exception e) { e.printStackTrace(); }

            System.out.println(Thread.currentThread().getName() + "\t --------come in"+System.currentTimeMillis());
            LockSupport.park();  // 如果提前 unpark 那么park就跟没有用一样（相当于被注释）
            LockSupport.park();  // 如果提前 unpark 那么park就跟没有用一样（相当于被注释）
            System.out.println(Thread.currentThread().getName() + "\t --------被唤醒"+System.currentTimeMillis());

        }, "a");
        a.start();

        try {TimeUnit.SECONDS.sleep(3); } catch (Exception e) { e.printStackTrace(); }

        Thread b = new Thread(() -> {
            LockSupport.unpark(a);  // 许可证是需被唤醒的线程
            LockSupport.unpark(a);  // 许可证是需被唤醒的线程
            System.out.println(Thread.currentThread().getName() + "\t --------通知");
        }, "b");
        b.start();
    }
}
