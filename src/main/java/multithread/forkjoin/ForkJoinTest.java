package multithread.forkjoin;

import java.util.concurrent.*;

public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(2);
        ForkJoinTask submit = pool.submit(new TaskTest(1, 10));
//        pool.execute(new TaskTest2(1,100));
        System.out.printf(submit.get().toString());
    }
}

class TaskTest extends RecursiveTask {

    private Integer start ;

    private Integer end;

    public TaskTest(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {

        int sum = 0;

        if(end - start <= 2) {
            for (int i = start;i <= end;i++) {
                sum+=i;
            }
        } else {
            TaskTest leftTask = new TaskTest(start, (start + end) / 2);
            TaskTest rightTask = new TaskTest((start + end) / 2 + 1, end);
            leftTask.fork();
            rightTask.fork();

            Object a = leftTask.join();
            Object b = rightTask.join();
            sum = Integer.valueOf(a.toString()) + Integer.valueOf(b.toString());
        }
        return sum;
    }
}

class TaskTest2 extends RecursiveAction {

    private Integer start ;

    private Integer end;

    public TaskTest2(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        int sum = 0;

        if(end - start <= 2) {
            for (int i = start;i <= end;i++) {
                sum+=i;
            }
        } else {
            TaskTest leftTask = new TaskTest(start, (start + end) / 2);
            TaskTest rightTask = new TaskTest((start + end) / 2 + 1, end);
            leftTask.fork();
            rightTask.fork();

            Object a = leftTask.join();
            Object b = rightTask.join();
            sum = Integer.valueOf(a.toString()) + Integer.valueOf(b.toString());
        }
    }
}
