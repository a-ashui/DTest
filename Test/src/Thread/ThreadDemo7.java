package Thread;

/**
 *
 */
public class ThreadDemo7 {
    //lambda + Runnable jdk1.8之后支持
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("当前线程："+
                    Thread.currentThread().getName());
        });
        thread.start();
    }

}
