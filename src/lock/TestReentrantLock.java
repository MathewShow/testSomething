package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ¿ÉÖØÈëËø
 */
public class TestReentrantLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int count = 0;

    public static void main(String[] args) {
        TestReentrantLock lock = new TestReentrantLock();

        Thread t = new Thread(lock);
        t.start();
        System.out.println(lock);

        try {
            Thread.sleep(5000);
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int count = 1;
    }

    @Override
    public void run() {
        try {
            for(int i=0 ; i<100 ; i++){
                lock.lock();
                lock.lock();
                count++;
            }
        }finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
                lock.unlock();
            }

        }




    }












}
