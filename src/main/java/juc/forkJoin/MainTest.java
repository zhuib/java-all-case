package juc.forkJoin;

import java.util.stream.LongStream;

public class MainTest {
    public static void main(String[] args) {
//        test01(); // Sum = 500000000500000000Time = 3229
//        test02(); // Sum = 500000000500000000Time = 2767
          test03(); // Sum = 500000000500000000Time = 185
    }

    public static void test01(){
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (long i = 1L; i<=10_0000_0000; i++){
            sum +=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("Sum = " + sum + "Time = " +(end - start));
    }
    public static void test02(){
        long start = System.currentTimeMillis();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1, 10_0000_0000);
        Long sum = forkJoinDemo.compute();
        long end = System.currentTimeMillis();
        System.out.println("Sum = " + sum + "Time = " +(end - start));
    }
    public static void test03(){
        long start = System.currentTimeMillis(); // parallel 并行
        long sum = LongStream.rangeClosed(1L, 10_0000_0000).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("Sum = " + sum + "Time = " +(end - start));
    }
}
