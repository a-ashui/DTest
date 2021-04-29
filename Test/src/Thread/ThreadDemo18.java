package Thread;

public class ThreadDemo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (!Thread.interrupted()){
                System.out.println("正在转账...");
            }
            System.out.println("终止转账");
        });
        t1.start();

        Thread.sleep(1000);

        System.out.println("有内鬼，终止交易！");
        t1.interrupt();//将t1中的interred状态改为true

    }
}
