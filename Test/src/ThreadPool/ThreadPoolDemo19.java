package ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo19 {
    // 创建并初始化 ThreadLocal
    private static ThreadLocal<String> threadLocal =
            ThreadLocal.withInitial(() -> "Java");

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        executor.submit(new Runnable() {
            @Override
            public void run() {
                String result = threadLocal.get();
                System.out.println("得到结果：" + result);
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                String result = threadLocal.get();
                System.out.println("得到结果：" + result);
            }
        });
    }
}
