package ThreadPool;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo17 {
    private static ThreadLocal<Integer> threadLocal =
            new ThreadLocal() {
                @Override
                protected Integer initialValue() {
                    int num = new Random().nextInt(10);
                    System.out.println("执行了 initialValue 生成了：" + num);
                    return num;
                }
            };

    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 1,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));

        executor.submit(new Runnable() {
            @Override
            public void run() {
                // get ThreadLocal
                int result = threadLocal.get();
                System.out.println(Thread.currentThread().getName() +
                        " 得到结果1：" + result);
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                // get ThreadLocal
                int result = threadLocal.get();
                System.out.println(Thread.currentThread().getName() +
                        " 得到结果2：" + result);
            }
        });

    }
}
