package oom;

/**
 * Date: 2021/5/22 15:24
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();  // Exception in thread "main" java.lang.StackOverflowError
    }
}
