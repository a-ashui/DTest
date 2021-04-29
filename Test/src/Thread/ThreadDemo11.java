package Thread;

/**
 * 演示线程的常见属性
 */
public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
                System.out.println("线程ID" + t.getId());
                System.out.println("线程名称" + t.getName());
                System.out.println("线程状态" + t.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "张三");
        //启动线程
        thread.start();
        Thread.sleep(100);
        System.out.println("thread 线程状态"+ thread.getState());
        System.out.println("thread 优先级"+ thread.getPriority());
        System.out.println("是否为守护线程"+ thread.isDaemon());
        System.out.println("是否存活"+ thread.isAlive());
        System.out.println("是否被中断" +thread.isInterrupted());
    }


}
