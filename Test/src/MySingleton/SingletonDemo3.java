package MySingleton;

public class SingletonDemo3 {
    static class Singleton{
        //1.设置私有的构造函数
        private Singleton(){

        }
        //2.提供一个私有静态变量
        private static Singleton singleton = null;

        //3.返回一个单例对象给外部
        //加锁 可以实现懒汉模式 但是离度太大了，性能不高
        public static synchronized Singleton getInstance(){
            if(singleton == null){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //第一个访问，进行实例化
                singleton = new Singleton();
            }
            return singleton;
        }
    }

    static Singleton s1 = null;
    static Singleton s2 = null;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s1= Singleton.getInstance();
            }
        });
        t1.start();

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                s2= Singleton.getInstance();
            }
        });
        t2.start();

        //等待线程执行结束
        t1.join();
        t2.join();

        System.out.println(s1==s2);
    }
}
