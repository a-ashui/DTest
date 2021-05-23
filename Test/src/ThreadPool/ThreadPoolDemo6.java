package ThreadPool;

/**
 * 问：创建单个线程池有什么用？
 * 答：
 *    1.可以避免频发创建和消耗线程带来的性能开销
 *    2.有任务队列可以存储多余的任务
 *    3.当有大量的任务不能处理的时候，可以友好的执行拒绝策略
 *    4.线程池可以更好地管理任务
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo6 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" +
                            Thread.currentThread().getName());
                }
            });
        }
    }
}
