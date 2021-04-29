package Thread;

/**
 *  使用两个线程打印出来 AABBCCDD 这样一组数据，每个线程智能打印ABCD。
 */
public class test {
    private static final String str = "ABCD";

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (char item : str.toCharArray()) {
                System.out.print(item);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();

        Thread t2 = new Thread(myRunnable);
        t2.start();

        t1.join();
        t2.join();

    }
}


