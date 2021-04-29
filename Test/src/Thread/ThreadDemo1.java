package Thread;

import java.util.concurrent.TimeUnit;

public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        String content = " ";
        for(char item : content.toCharArray()){
            System.out.println(item);
            //方式1.线程休眠
            Thread.sleep(60*1000);

            //方式2.线程休眠
            TimeUnit.SECONDS.sleep(1);//休眠1秒
            TimeUnit.HOURS.sleep(1);//休眠1小时

            //方式3.线程休眠
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }
    }
}
