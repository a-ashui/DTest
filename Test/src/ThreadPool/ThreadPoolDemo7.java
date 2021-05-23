package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * jdk1.8+ 根据当前的硬件cpu生成对应个数的线程池，并且是异步。
 * 异步方式：1.发请求 2.执行完成 3.另一个程序异步处理 4.处理完之后回调返回结果
 */
public class ThreadPoolDemo7 {
    public static void main(String[] args){
        //创建一个异步根据当前cpu生成的线程池
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i <10 ; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
        while(!service.isTerminated()){

        }
    }
}
