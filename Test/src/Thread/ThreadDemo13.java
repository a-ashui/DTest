package Thread;

/**
 * 守护线程
 */
public class ThreadDemo13 {
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println("i:" +i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //设置为守护线程
        t1.setDaemon(true);
        t1.start();
        System.out.println("线程状态"+ t1.getState());

    }
}
