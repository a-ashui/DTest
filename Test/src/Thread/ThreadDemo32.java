package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo32 {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock(true);
        lock.lock();
        try {
            int num = 1 / 0;
        } finally {
            lock.unlock();
        }

    }
}
