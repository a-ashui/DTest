package ThreadPool;



/**
 * ThreadLocal使用场景 ：
 *   1.解决线程安全问题
 *   2.实现线程级别的数据传递
 */
public class ThreadPoolDemo21 {


    private static ThreadLocal<User> userThreadLocal
            = new ThreadLocal();

    /**
     * 实体类
     */
    static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        Storage2 storage2 = new Storage2();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 用户登录
                User user = new User();
                user.setName("比特");
                userThreadLocal.set(user);

                // 打印用户的信息
                storage.printUserName3();
                storage2.printUserName3();
            }
        });
        t1.start();

    }


    class UserStrorage {

        public User getUser() {
            // 登录
            User user = new User();
            user.setName("比特");
            return user;
        }

    }

    /**
     * 仓储类
     */
    static class Storage {
//        public void printUserName(User user) {
//            System.out.println(user.getName());
//        }
//
//        public void printUserName2() {
//            System.out.println(new UserStrorage()
//                    .getUser().getName());
//        }

        public void printUserName3() {
            User user = userThreadLocal.get();
            System.out.println("用户名" + user.getName());
        }
    }

    /**
     * 类 2
     */
    static class Storage2 {
        public void printUserName3() {
            User user = userThreadLocal.get();
            System.out.println("用户名" + user.getName());
        }
    }


}
