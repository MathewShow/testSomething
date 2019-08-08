package thread;

public class Test {
    public static void main(String[] args) {
       /* Thread t1 = new MyCommon();
        Thread t2 = new Thread(new MyDaemon());
        t2.setDaemon(true);        //设置为守护线程

        t2.start();
        t1.start();*/

        //死锁
        DeadlockRisk dead = new DeadlockRisk();
        MyThread t1 = new MyThread(dead, 1, 2);
        MyThread t2 = new MyThread(dead, 3, 4);
        MyThread t3 = new MyThread(dead, 5, 6);
        MyThread t4 = new MyThread(dead, 7, 8);

        t1.start();
        t2.start();
        t3.start();
        t4.start();



    }
}

class MyThread extends Thread {
    private DeadlockRisk dead;
    private int a, b;


    MyThread(DeadlockRisk dead, int a,int b) {
        this.dead = dead;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        dead.read();
        dead.write(a, b);
    }
}

