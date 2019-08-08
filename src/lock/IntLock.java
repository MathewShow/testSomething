package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * �����ж���ӦlockInterruptibly
 */
public class IntLock implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;
    /**
     * ���Ƽ���˳�򣬲�������
     */
    public IntLock(int lock) {
        this.lock = lock;
    }
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly(); // �����ǰ�߳�δ�� �жϣ����ȡ����
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"��ִ����ϣ�");
            } else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"��ִ����ϣ�");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // ��ѯ��ǰ�߳��Ƿ񱣳ִ�����
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "���˳���");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        IntLock intLock1 = new IntLock(1);
        IntLock intLock2 = new IntLock(2);
        Thread thread1 = new Thread(intLock1, "�߳�1");
        Thread thread2 = new Thread(intLock2, "�߳�2");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt(); // �ж��߳�2
    }
}
