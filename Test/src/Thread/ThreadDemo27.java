package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo27 {
    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock(true);

        Runnable runnable = () -> {
            for (char item : "ABCD".toCharArray()) {
                lock.lock();
                try {
                    System.out.print(item);
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread.sleep(10);
        t1.start();
        t2.start();
    }
}
