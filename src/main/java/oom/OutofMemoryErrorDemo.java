package oom;

/**
 * Date: 2021/5/22 15:24
 */
public class OutofMemoryErrorDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[30 * 1024 * 1024];  //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
