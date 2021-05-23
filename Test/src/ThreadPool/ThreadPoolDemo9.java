package ThreadPool;

import java.util.concurrent.*;

/**
 * 自定义拒绝策略
 */
public class ThreadPoolDemo9 {

    public static int count = 0;

    public static void main(String[] args) {


        //
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThreadPool-" + count++);
                return thread;
            }
        };

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1, 1,
                        60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1),
                        threadFactory, new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("执行了自定义拒绝策略");
                    }
                });

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }


    }
}