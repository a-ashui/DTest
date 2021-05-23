package ThreadPool;

public class ThreadPoolDemo23 {

    // 创建 ThreadLocal
    private static ThreadLocal threadLocal =
            new InheritableThreadLocal();

    public static void main(String[] args) {
        // 在主线程里面设置值
        threadLocal.set("Java");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("获取值：" +
                        threadLocal.get());
            }
        });
        t1.start();

    }

}
