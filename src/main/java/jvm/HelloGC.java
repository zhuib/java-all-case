package jvm;

/**
 * Date: 2021/5/20 23:39
 */
public class HelloGC {
    public static void main(String[] args) throws Exception{
//        System.out.println("****** GC");
//        Thread.sleep(Integer.MAX_VALUE);
//        byte[] bytes = new byte[50*1024*1024];
        long totalMemory = Runtime.getRuntime().totalMemory(); // 返回 java 虚拟机中内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();  // 返回java 虚拟机试图使用的最大内存大小
        System.out.println("totalMemory(-Xms) = " + totalMemory +"(字节)、" +(totalMemory /(double) 1024/1024) +"MB");
        System.out.println("maxMemory(-Xmx) = " + maxMemory +"(字节)、" +(maxMemory /(double) 1024/1024) +"MB");
    }
}
