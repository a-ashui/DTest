package Thread;

public class ThreadDemo22 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("执行之前:"+ t1.getState());

        t1.start();
        System.out.println("start 之后:"+ t1.getState());
        Thread.sleep(100);
        System.out.println("休眠了100毫秒之后线程状态:"+ t1.getState());

        t1.join();//实现方法1

        //实现方法2
//        while (t1.isAlive()){
//
//        }

        System.out.println("现成最终状态:"+ t1.getState());


    }

}
