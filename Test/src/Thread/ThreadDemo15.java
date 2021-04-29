package Thread;

public class ThreadDemo15 {
    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            System.out.println("线程名称" +
                    Thread.currentThread().getName());

            Thread t1 = new Thread(()->{
//                System.out.println(" "+
//                        Thread.currentThread().getName());
            });
            //在守护线程里创建的线程为守护线程
            System.out.println("1 " + t1.isDaemon());
        });
        System.out.println("守护线程：" + thread.isDaemon());
        thread.setDaemon(true);//设置守护线程不能放在启动线程之后
        thread.start();


    }
}
