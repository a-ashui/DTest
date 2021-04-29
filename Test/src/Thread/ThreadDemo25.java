package Thread;

/**
 * 多线程 问题：非线程安全
 * 非线程安全；使用多线程执行任务 最终得带的结果与预期不一致
 *    ***造成线程不安全的因素***：
 *        1.cpu是抢占式执行的
 *        2.共同操作了一个变量
 *        3.内存不可见
 *        4.非原子性
 *        5.编译器优化  (在复杂的多线程中会出现混乱，从而导致线程不安全) voletile 总结：
 *                              voletile可以解决内存不可见和指令重排序的问题 但不能解决原子性问题。
 *        线程不安全问题解决方案分析：
 *           1.cup抢占执行问题（不可控）
 *           2.每个线程操作自己的私有变量（有可能可以）
 *           3.只需要在关键步骤上，排队执行【加锁】
 *                   java语言中解决加锁操作：
 *                      1.synchronized（jvm层的解决方案）
 *                      2.手动锁 lock 的方式
 *      
 *
 */
public class ThreadDemo25 {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 =new Thread(()->{
            counter.incrment();

        });
        t1.start();

        Thread t2 = new Thread(()->{
            counter.decrment();
        });
        t2.start();

        t1.join();
        t2.join();

        //最终执行结果
        System.out.println("最终结果:"+ counter.getCount());

    }
}
