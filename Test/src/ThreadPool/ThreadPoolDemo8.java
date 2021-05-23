package ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * *原始的线程池的创建方式 *
 */
public class ThreadPoolDemo8 {

    public static int count = 0;

    public static void main(String[] args) {

        /**
         * 参数1：核心线程的数量 线程池正常情况下的数量 （正式员工数量）
         * 参数2：最大线程数量 当有大量任务的时候可以创建的最多的线程数（正式员工数量+临时工的数量）
         * 参数3：最大线程存活时间（临时工的存活时间）
         * 参数4：配合参数3一起使用 表示存活时间的时间单位
         * 参数5：任务队列（一定要设置初始化大小）
         * 参数6：线程工厂
         * 参数7：拒绝策略
         *       1.ThreadPoolExecutor.AbortPolicy() 默认拒绝策略，不执行任务抛出异常
         *       2.ThreadPoolExecutor.CallerRunsPolicy()  把当前的任务交给主线程执行
         *       3.ThreadPoolExecutor.DiscardOldestPolicy()  丢弃最老的任务
         *       4.ThreadPoolExecutor.DiscardPolicy()  丢弃最新任务
         */

        //注意事项：最大的线程数必须大于等于核心线程数


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
                new ThreadPoolExecutor(1,1,
                        60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1),
                        threadFactory,new ThreadPoolExecutor.DiscardPolicy());

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名：" + Thread.currentThread().getName());
            }
        });

    }
}
