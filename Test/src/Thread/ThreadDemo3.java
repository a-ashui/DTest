package Thread;

public class ThreadDemo3 {
    static class MyThread extends Thread{

        @Override
        public void run() {
            //写你的任务代码
            //打印当前线程名称

        }
    }
    public static void main(String[] args) {

        //1. 继承 Thread 类
        MyThread myThread = new MyThread();
        //启动线程
        myThread.start();

        System.out.println("当前线程："+
                Thread.currentThread().getName());

    }
}
