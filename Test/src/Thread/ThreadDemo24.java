package Thread;

/**
 *计数方法
 */
public class ThreadDemo24 {



    public static void main(String[] args) {

        Counter counter = new Counter();

        //先执行加法
        counter.incrment();

        //在执行减法
        counter.decrment();

        //在发音结果
        System.out.println("最终执行结果:"+ counter.getCount());

    }

}
