package Thread;

public class ThreadDemo5 {
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("当前线程："+
                    Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        //先来创建Runnable 子对象
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        //启动线程
        thread.start();
    }
}
