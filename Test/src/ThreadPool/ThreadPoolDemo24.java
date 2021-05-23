package ThreadPool;

public class ThreadPoolDemo24 {
    // 创建 InheritableThreadLocal
    private static ThreadLocal threadLocal =
            new InheritableThreadLocal();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 在主线程里面设置值
                threadLocal.set("Java");
                System.out.println("线程1 执行值");
            }
        });
        t1.start();
        // 线程 1 执行完
        t1.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2得到取：" + threadLocal.get());
            }
        });
        t2.start();

    }
}
