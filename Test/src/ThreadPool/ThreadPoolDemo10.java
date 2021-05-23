package ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor 执行策略：核心线程数。最大线程数。任务队列。
 *      1.当任务量小于核心线程数的时候，他会创建一个线程来执行此任务，当任务量大于线程数的时候，
 *        并且没空闲线程的时候，且当前线程池的线程数小于最大线程数，此时：：：会将任务存到任务队列里
 *        因为把多出来的任务存储到任务队列的成本最小，所以此时线程池会将任务存在任务队列里，而并非新创建线程来执行任务
 *      2.当前任务量比较大的时候，此时没有空闲线程，比企鹅任务队列已经满了，此时会判断当前线程池的任务数量是否大于等于最大线程数
 *        如果当前线程池的数量小于最大线程数，创建线程来执行任务。当前线程池的线程数量等于最大线程数，并且任务队列已经满了
 *          就：：：执行拒绝策略
 */
public class ThreadPoolDemo10 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,5,60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(10));
        for (int i = 0; i < 3; i++) {
            int finalI = 1;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format("编号：%d,线程名：%s",
                            finalI,Thread.currentThread().getName()));
                }
            });
        }
    }
}
