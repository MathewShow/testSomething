package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("�̳�Callable�ӿ� ʵ��call������Ϊ�߳�ִ���� �з���ֵ");
        return 100;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> testCallable = new TestCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(testCallable);
        Thread thread = new Thread(futureTask);//FutureTaskʵ����Runnable ������ΪThread�����target�������̡߳�
        thread.start();//�����߳�
        Integer result = futureTask.get();//����FutureTask�����get()������������߳�ִ�н�����ķ���ֵ
    }
}
