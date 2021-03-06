package ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo20 {

    // 创建并初始化 ThreadLocal
    private static ThreadLocal<SimpleDateFormat> threadLocal =
            new ThreadLocal() {
                @Override
                protected SimpleDateFormat initialValue() {
                    System.out.println("----------执行了初始化方法----------");
                    return new SimpleDateFormat("mm:ss");
                }
            };

    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        // 执行格式化方法
        for (int i = 1; i < 1001; i++) {
            int finalI = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finalI * 1000);
                    myFormatTime(date);
                }
            });
        }
    }

    private static void myFormatTime(Date date) {
        String result = threadLocal.get().format(date);
        System.out.println("时间：" + result);
    }
}
