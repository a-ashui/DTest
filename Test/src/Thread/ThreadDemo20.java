package Thread;

public class ThreadDemo20 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName+"上班");
                System.out.println(threadName+"下班");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable,"张三");
        t1.start();
        t1.join();
        Thread t2 = new Thread(runnable,"李四");
        t2.start();
    }
}
