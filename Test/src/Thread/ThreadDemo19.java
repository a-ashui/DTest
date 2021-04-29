package Thread;

public class ThreadDemo19 {
    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            for (int i = 0; i <10 ; i++) {
//                Thread.interrupted();
                //第一次接收到的状态是true 之后就会将状态复位 恢复成false
                System.out.println(Thread.interrupted());
            }
        });
        thread.start();
        //终止线程
        thread.interrupt();

    }
}
