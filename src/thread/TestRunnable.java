package thread;

public class TestRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable 重写run方法");
    }

    public static void main(String[] args) {
        TestRunnable target = new TestRunnable();
        Thread thread = new Thread(target);
        thread.start();//启动线程
    }
}
