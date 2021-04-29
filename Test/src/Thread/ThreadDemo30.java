package Thread;

public class ThreadDemo30 {
    // 全局变量
    private static int number = 0;
    // 循环次数
    private static final int maxSize = 100000;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                decrement();
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("最终执行结果：" + number);

    }

    // 相加
    public synchronized static void increment() {
        for (int i = 0; i < maxSize; i++) {
            number++;
        }
    }

    // 相减
    public synchronized static void decrement() {
        for (int i = 0; i < maxSize; i++) {
            number--;
        }
    }
}
