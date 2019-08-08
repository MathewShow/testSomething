package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleepAndWait {

    public static void main(String[] args) {
        TestWait target = new TestWait();
        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);
        Thread t3 = new Thread(target);
        t1.start();
        t2.start();
        t3.start();
    }
}

class TestWait implements Runnable{

    public synchronized void run() {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS a");
            System.out.println(Thread.currentThread().getName()+"◊º±∏–›√ﬂ:"+sdf.format(new Date()));
            this.wait(3000);
            System.out.println(Thread.currentThread().getName()+"–›√ﬂ¡À3√Î÷”"+sdf.format(new Date()));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

class SleepThread implements Runnable{

    @Override
    public synchronized  void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS a");
            System.out.println(Thread.currentThread().getName()+"◊º±∏–›√ﬂ:"+sdf.format(new Date()));
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"–›√ﬂ¡À3√Î÷”"+sdf.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}







