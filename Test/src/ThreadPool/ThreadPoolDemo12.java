package ThreadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 线程池的执行的2种方式
 */
public class ThreadPoolDemo12 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10,10,60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(100));

        //执行方式
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行executor 方法");
            }
        });
        Future<Integer> future = threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int num = new Random().nextInt(10);
                //生成随机数
                System.out.println("执行submit方法 ，随机数" + num);
                return num;
            }
        });
        System.out.println("得到线程池执行结果：" + future.get());

        //使用submit 执行Runnable 任务
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行submit方法，使用的是Runnable对象");
            }
        });

        threadPoolExecutor.shutdown();

    }
}
