package Thread;

public class Counter {
    //私有变量
    private int count = 0;

    //执行循环次数
    private final int maxSize = 10000000;

    //执行加法
    public void incrment(){
        for (int i = 0; i <maxSize ; i++) {
            count++;
        }
    }

    //执行
    public void decrment(){
        for (int i = 0; i <maxSize ; i++) {
            count--;
        }
    }

    //提供变量  count 的查询
    public int getCount(){

        return  count;

    }


}
