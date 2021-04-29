package Thread;

/**
 * 终止方法1:
 */
public class ThreadDemo16 {

    private static boolean flog = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            while (!flog){
                System.out.println("正在转账...");
                //休眠线程
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(" 啊?");
        },"张三");
        t1.start();

        //休眠主线程
        Thread.sleep(300);

        //终止线程
        flog=true;
        System.out.println("有内鬼，终止交易！");
    }
}
