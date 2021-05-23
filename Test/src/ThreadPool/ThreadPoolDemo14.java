package ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadPoolDemo14 {
    // 创建了一个 ThreadLocal
    private static ThreadLocal<SimpleDateFormat> threadLocal =
            new ThreadLocal<>();

    public static void main(String[] args) {
        // 设置私有变量
        threadLocal.set(new SimpleDateFormat("mm:ss"));
        // 得到 ThreadLocal
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        Date date = new Date(1000);
        String result = simpleDateFormat.format(date);
        System.out.println("时间：" + result);
    }
}
