package Thread;

import java.util.concurrent.TimeUnit;

/**
 * 造成死锁的4个条件：
 *     1.互斥条件：当资源被一个线程拥有了之后，就不能被其他线程拥有了。（不可更改）
 *     2.拥有请求条件：当一个线程拥有了一个资源后又试图请求另一个资源。（可以解决）
 *     3.不可剥夺条件：当一个资源被一个线程拥有之后，
 *               如果不是这个线程主动释放此资源的情况下，其它线程不能拥有此资源。（不可更改）
 *     4.环路等待条件：两个或两个以上的线程在拥有了资源之后，试图获取对方资源的时候形成了一个环路。（可以解决）
 *            如何解决死锁问题？
 *            答：解决
 */
public class ThreadDemo33 {
    public static void main(String[] args) throws InterruptedException {

        //声明(加锁的)资源
        Object lockA = new Object();
        Object lockB = new Object();
        //创建线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String Threadname = Thread.currentThread().getName();
                synchronized (lockA){
                    //已获取到lockA
                    System.out.println(Threadname + "get lockA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Threadname + "waiting lockB");
                    synchronized (lockB){
                        System.out.println(Threadname + "get lockB");
                    }
                }
            }
        },"t1");
        //启动线程 t1
        t1.start();

        //创建线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadname = Thread.currentThread().getName();
                //1.获取资源B lockB
                synchronized (lockB){
                    System.out.println(threadname + "get lockB");
                }
                //2.休眠1秒 为了让t1 获取到lockA
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadname + "waiting lockA");
                //3.获取资源A lockA
                synchronized (lockA){
                    System.out.println(threadname + "get lockA");
                }
            }
        },"t2");
        t2.start();

    }
}
