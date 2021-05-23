package ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadPoolDemo16 {
    // 创建和初始化 ThreadLocal
    private static ThreadLocal<SimpleDateFormat> threadLocal =
            new ThreadLocal() {
                @Override
                protected SimpleDateFormat initialValue() {
                    System.out.println("执行 InitialValue 方法");
                    return new SimpleDateFormat("mm:ss");
                }
            };

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(1000);
                // 从 ThreadLocal 获取 DateFormat 对象，并格式化时间
                String result = threadLocal.get().format(date);
                System.out.println("线程1 时间格式化：" + result);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(2000);
                // 从 ThreadLocal 获取 DateFormat 对象，并格式化时间
                String result = threadLocal.get().format(date);
                System.out.println("线程2 时间格式化：" + result);
            }
        });
        t2.start();
    }
}
