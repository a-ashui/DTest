package Thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadDemo40 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("park 之前 Interrupt 状态:" +
                        Thread.currentThread().isInterrupted());
                // 线程进入休眠
                LockSupport.park();
                System.out.println("park 之后 Interrupt 状态:" +
                        Thread.currentThread().isInterrupted());
            }
        }, "t1");
        // 启动线程
        t1.start();

        Thread.sleep(100);
        // 中止线程
        t1.interrupt();
        // 唤醒线程 t1
        LockSupport.unpark(t1);
    }
}
