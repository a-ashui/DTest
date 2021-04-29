package Thread;

public class ThreadDemo23 {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            //出让cpu执行权 需要反应时间 不一定执行成功 要看cup的选择
            //总体来说 基本符合预期
            Thread.yield();
            for (int i = 0; i <100 ; i++) {
                System.out.println("线程1");
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println("线程2");
            }
        });
        t2.start();

    }

}
