package thread;

import java.util.concurrent.ConcurrentHashMap;

public class TestThread extends Thread{

    @Override
    public void run() {
        System.out.println("��дrun()����");
    }

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();//�����߳�
    }
}
