package Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo8 {
    // 创建线程
    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            // 产生随机数
            int num = new Random().nextInt(10);
            System.out.println(String.format("线程：%s,生产了随机数：%d",
                    Thread.currentThread().getName(), num));
            return num;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建并调用
        MyCallable callable = new MyCallable();
        //2.使用futureTask 接收 Callable
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //创建线程并设置任务
        Thread thread = new Thread(futureTask);
        thread.start();
        //得到线程的返回结果
        int num = futureTask.get();
        System.out.println("线程的返回结果"+num);
    }
}
