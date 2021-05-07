package Thread;

/**
 * notify()不能制定唤醒某个线程
 */
public class ThreadDemo36 {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //调用wait方法之前必须先加锁
                synchronized (lock){
                    try {
                        System.out.println("t1 wait 之前");
                        lock.wait();
                        System.out.println("t1 wait 之后");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //调用wait方法之前必须先加锁
                synchronized (lock){
                    try {
                        System.out.println("t2 wait 之前");
                        lock.wait();
                        System.out.println("t2 wait 之后");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");
        t2.start();

        Thread.sleep(500);
        System.out.println("唤醒线程t1");

        //在主线程中 唤醒线程t1
        //notify方法之前也要先加锁
        synchronized (lock){
            lock.notify();
        }

    }
}
