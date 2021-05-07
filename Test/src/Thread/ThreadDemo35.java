package Thread;


/**
 * 1.wait方法和notify方法使用之前都需要先加锁（配合synchronized一起使用）。
 * 2.wait和notify在配合synchronized时 一定要用同一个锁。
 * 3.wait和notify一起使用时，一定要用同一个锁。
 */
public class ThreadDemo35 {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //调用wait方法之前必须先加锁
                synchronized (lock){
                    try {
                        System.out.println("wait 之前");
                        lock.wait();
                        System.out.println("wait 之后");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");
        t1.start();

        Thread.sleep(500);
        System.out.println("唤醒线程t1");

        //在主线程中 唤醒线程t1
        //notify方法之前也要先加锁
        synchronized (lock){
            lock.notifyAll();
        }


    }
}
