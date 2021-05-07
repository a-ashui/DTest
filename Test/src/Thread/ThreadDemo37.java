package Thread;

import java.util.Date;

public class ThreadDemo37 {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //调用wait方法之前必须先加锁
                synchronized (lock){
                    System.out.println("t1进入waiting状态" + new Date());
                    try {
                        lock.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1代码执行完成" + new Date());
                }
            }
        },"t1");
        t1.start();
    }
}
