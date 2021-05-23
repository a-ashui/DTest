package ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolDemo11 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5,5,60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(10));
        for (int i = 0; i < 20; i++) {
            int finalI = 1;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format("编号：%d,线程名：%s",
                            finalI,Thread.currentThread().getName()));
                }
            });
            Thread.sleep(100);
        }
        //结束线程池
        threadPoolExecutor.shutdown();

        //立即终止线程池（线程池的任务不会执行完）
//        threadPoolExecutor.shutdownNow();

    }
}
