package Thread;

public class ThreadDemo38 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                        System.out.println("唤醒 t1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                        System.out.println("唤醒 t2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t2");


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                        System.out.println("唤醒 t3");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10);
        synchronized (lock) {
            lock.notify();
        }

        Thread.sleep(10);
        synchronized (lock) {
            lock.notify();
        }

        Thread.sleep(10);
        synchronized (lock) {
            lock.notify();
        }
    }
}
