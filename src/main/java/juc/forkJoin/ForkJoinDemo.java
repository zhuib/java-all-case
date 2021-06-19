package juc.forkJoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {


    private long start;
    private long end;

    //
    private long temp = 10000L;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) < temp){
            long sum = 0L;
            for (Long i = start; i <= end; i++){
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle+ 1, end);
            task2.fork();
            return task1.join() + task2.join();

        }

    }
}
