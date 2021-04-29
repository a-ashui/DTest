package Thread;

/**
 * 终止方法2：
 */
public class ThreadDemo17 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            while (!Thread.interrupted()){

                //休眠线程
                try {
                    Thread.sleep(100);
                    System.out.println("正在转账...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

            }
            System.out.println(" 啊?");
        },"张三");
        t1.start();

        //休眠主线程
        Thread.sleep(300);

        //终止线程

        System.out.println("有内鬼，终止交易！");
        t1.interrupt();


    }
}
