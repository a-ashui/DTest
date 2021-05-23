package ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo13 {
    //    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    public static void main(String[] args) {
        // 定义线程池
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000));
        for (int i = 1; i < 1001; i++) {
            final int finalI = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finalI * 1000);
                    myFormatTime(date);
                }
            });
        }
    }

    private static void myFormatTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        String result = simpleDateFormat.format(date);
        System.out.println("时间：" + result);
    }
    
}
