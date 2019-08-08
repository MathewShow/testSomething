package testSomething;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.*;

public class BlockQueue {

    Object lock = new Object();
    int head ;
    int tail ;
    int count;
    ArrayList list = new ArrayList();

    public synchronized void read(int i) throws InterruptedException {
        tail = list.size();
        System.out.println(head);
        System.out.println(tail);
        if (head == tail || i>tail) {
            wait(3000);
            System.out.println("等待了3秒");
        }
        list.get(i);
    }

    public synchronized void write(int x) throws InterruptedException {
        list.add(tail, x);//add(int index, E element) 将index位置及后面元素后移,需要保证index不大于size
        notifyAll();
        wait();
    }

    public static void main(String[] args) {
        BlockQueue blockQueue = new BlockQueue();
        try {
            //blockQueue.write(1);
            blockQueue.read(0);

            blockQueue.read(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        //BlockingQueue是接口  ArrayBlockingQueue为实现类 数组阻塞队列
        BlockingQueue arrQueue;
        arrQueue = new ArrayBlockingQueue(1);

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        try {
            queue.poll(2,TimeUnit.SECONDS);
            queue.poll();
            queue.offer("12");
            queue.peek();

            PriorityBlockingQueue<Object> priorityBlockingQueue
                    = new PriorityBlockingQueue<>();
            priorityBlockingQueue.comparator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
