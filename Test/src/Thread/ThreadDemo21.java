package Thread;

/**
 * 线程状态
 */
public class ThreadDemo21 {

    public static void main(String[] args) {
        for (Thread.State  state : Thread.State.values() ){
            System.out.println(state);
        }
    }

}
