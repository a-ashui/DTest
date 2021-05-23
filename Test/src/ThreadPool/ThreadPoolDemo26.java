package ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal缺点：
 *   1.脏读问题
 *  产生的原因：1.线程池复用，和这个线程相关的静态属性也复用了，所以导致脏读。
 *   2.不可继承性（子线程
 *   3.内存溢出（因为：1.线程池是长生命周期的
 *                  2.Thread——>ThreadLocalMap ->Entry key.value(1mb资源）垃圾回收器不会回收value资源（value为强引用
 *
 *
 *   垃圾回收器可回收的资源相关的四种类型：
 *    1.强引用  即使发生oom也不会进行垃圾回收
 *    2.软引用  他的引用关系仅次于强引用 如果内存够用，垃圾回收器不会考虑此引用，
 *             将要发生oom的时候才会回收此引用
 *    3.弱引用  不管内存够不够用，下一次回收都会将此引用对象回收掉
 *    4.虚引用  创建即回收，它可以触发一个垃圾回收的回调
 *
 */
public class ThreadPoolDemo26 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1,
                0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));

        for (int i = 0; i < 2; i++) {
            executor.submit(new MyThreadLocal());
        }

    }

    static class MyThreadLocal extends Thread {
        private static boolean flag = false;

        @Override
        public void run() {
            String tname = this.getName();
            if (!flag) {
                // 第一次执行
                threadLocal.set(tname);
                System.out.println(tname + " 设置了：" + tname);
                flag = true;
            }
            System.out.println(tname + "得到了：" + threadLocal.get());
        }
    }

}
