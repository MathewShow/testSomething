package thread;

import java.util.concurrent.ConcurrentHashMap;

public class TestThread extends Thread{

    @Override
    public void run() {
        System.out.println("重写run()方法");
    }

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();//启动线程
    }
}
