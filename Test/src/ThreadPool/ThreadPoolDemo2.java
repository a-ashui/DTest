package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 短期有大量任务的时候，使用 newCachedThread
 */
public class ThreadPoolDemo2 {

    public static void main(String[] args) {
        //创建带缓存的线程池
        ExecutorService executorService =
                Executors.newCachedThreadPool();

        for (int i = 0; i <100 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名"+ Thread.currentThread().getName());
                }
            });
        }

    }
}
