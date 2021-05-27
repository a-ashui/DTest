package MySingleton;

import java.util.Random;

public class MyBlockingQu {
    static class MyBlockingQueue {

        private int[] values;//存放数据的数组
        private int first;//队首下标
        private int last;//队尾下标
        private int size;//实际队列大小

        public MyBlockingQueue (int maxSize){
            //初始化
            values = new int[maxSize];
            first = 0;
            last = 0;
            size = 0;
        }

        //添加元素到队尾
        public void offer(int val) throws InterruptedException {
            synchronized (this){
                //判断容量是否达到最大值
                if(size == values.length){
                    //阻塞等待
                    this.wait();
                }
                values[last++] = val;
                size++;
                //判断是否是最后一个元素
                if(last == values.length){
                    last = 0;
                }
                //唤醒消费者取队列中的信息
                this.notify();
            }

        }

        //取队首元素
        public int poll() throws InterruptedException {
            int result = 0;
            synchronized (this){
                //队列中有无元素
                if(size == 0){
                    this.wait();
                }
                result = values[first++];
                size--;
                //判断取到了最后一个元素
                if(first == values.length){
                    first = 0;
                }
                this.notify();
            }

            return result;
        }

    }

    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(10);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int num = new Random().nextInt(10);
                    System.out.println("生产数据：" + num);
                    try {
                        myBlockingQueue.offer(num);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        int result = myBlockingQueue.poll();
                        System.out.println("消费数据：" + result);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();

    }
}
