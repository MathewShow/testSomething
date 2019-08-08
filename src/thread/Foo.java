package thread;

public class Foo {

    private int x = 100;

    public int getX() {
        return x;
    }

    public   int fix(int y) {
        System.out.println("fix():"+Thread.currentThread().getName() + " :当前foo对象的x值= " + x);
        x = x - y;
        return x;
    }
}
