package Thread;

public class ThreadDemo9 {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("当前线程:"+
                    Thread.currentThread().getName());
            try {
                Thread.sleep(9999999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
