package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("继承Callable接口 实现call方法作为线程执行体 有返回值");
        return 100;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> testCallable = new TestCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(testCallable);
        Thread thread = new Thread(futureTask);//FutureTask实现了Runnable 可以作为Thread对象的target来创建线程。
        thread.start();//启动线程
        Integer result = futureTask.get();//调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
    }
}
