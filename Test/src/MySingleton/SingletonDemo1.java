package MySingleton;

/**
 * 饿汉方式:
 *   优点：实现简单，不存在线程安全问题，因为饿汉的方式是随着程序启动而初始化的，因为类加载时线程安全的，
 *        所以他是线程安全的
 *   缺点：随着程序的启动而启动，有可能在整个运行周期都没有用到，会带来不必要的开销。
 *
 * 懒汉方式：不会随着程序的启动而初始化，而是等到有人调用他时，他才会初始化。
 */
public class SingletonDemo1 {
    //单例类
    static class Singleton {
        //1.构造函数设置成私有 不能让外部创建
        private Singleton () {

        }
        //2.创建一个静态的类变量 来让第三步的方法返回
        private static Singleton singleton = new Singleton();

        //3.给外部提供的获取单例的静态方法
        public static Singleton getInstance(){
            return singleton;
        }

    }

    static Singleton s1 = null;
    static Singleton s2 = null;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s1=Singleton.getInstance();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                s2=Singleton.getInstance();
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(s1==s2);
    }

}
