package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用其他6种创建线程方式可能会导致的问题：
 *   1.线程数量不可控 （比如创建带缓存的线程池时）-->oom
 *   2.工作任务队列不可控 -->oom
 * 线程池中两个重要对象：1.线程 2.工作队列
 */
public class ThreadPoolDemo0 {
    static class MyOOMClass {
        //1M 空间 （M KB B）
        private byte[] bytes = new byte[1*1024*1024];
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(15*1000);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            final int finalI = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    new MyOOMClass();
                    System.out.println("任务：" + finalI);
                }
            });
        }
    }
}
