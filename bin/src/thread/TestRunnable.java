package thread;

public class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("ʵ��Runnable ��дrun����");
    }

    public static void main(String[] args) {
        TestRunnable target = new TestRunnable();
        Thread thread = new Thread(target);
        thread.start();//�����߳�
    }
}
