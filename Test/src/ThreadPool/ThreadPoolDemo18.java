package ThreadPool;

import java.util.function.Supplier;

public class ThreadPoolDemo18 {
    // 创建并初始化 ThreadLocal
    private static ThreadLocal<String> threadLocal =
            ThreadLocal.withInitial(new Supplier<String>() {
                @Override
                public String get() {
                    System.out.println("执行了 withInitial 方法");
                    return Thread.currentThread().getName() + "Java";
                }
            });

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 获取 ThreadLoal
                String result = threadLocal.get();
                System.out.println(Thread.currentThread().getName() +
                        " 获取到的内容：" + result);
            }
        };
        Thread t1 = new Thread(runnable, "线程1");
        t1.start();

        Thread t2 = new Thread(runnable, "线程2");
        t2.start();

    }

}
