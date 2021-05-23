package ThreadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建可以设置定时任务的线程池
 */
public class ThreadPoolDemo4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(2);
        System.out.print("设置定时任务：");
        //执行定时任务
        //以上一次任务开始时间作为下一次任务开始时间的
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("执行任务：" + new Date());
//
//            }
//        },1,3, TimeUnit.SECONDS);
        //参数1：线程执行的任务 Rannable
        //参数2：延迟一段时间执行
        //参数3：执行频率
        //参数4：前面参数的类型（时，分，秒）

        //只会执行一次
//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("执行任务：" + new Date());
//            }
//        },1,TimeUnit.SECONDS);


        //以上一次任务的结束时间作为下一次任务的开始时间的
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务：" + new Date());
            }
        },1,3,TimeUnit.SECONDS);

    }
}
