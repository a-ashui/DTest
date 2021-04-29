package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo31{
    // 全局变量
    private static int number = 0;
    // 循环次数
    private static final int maxSize = 100000;


    public static void main(String[] args) throws InterruptedException {

        ThreadDemo31 threadDemo33 = new ThreadDemo31();

        // 1.创建lock实例
        Lock lock = new ReentrantLock(true);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    // 2.加锁
                    lock.lock();
                    try {
                        // 业务操作
                        number++;
                    } finally {
                        // 3.释放锁
                        lock.unlock();
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    lock.lock();
                    try {
                        number--;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("最终执行结果：" + number);
    }
}
