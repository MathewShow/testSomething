package lock;

import sun.applet.AppletClassLoader;
import sun.misc.Launcher;
import sun.misc.Unsafe;

public class TestClassLoader {

    public static void main(String[] args) {
        //System.out.println(SubClass.value);
        //顺序输出:
        //SuperClass init!
        //SubClass init!
        //1234

        //测试 启动类加载器 BootStrap ClassLoader 加载的文件
        //System.out.println(System.getProperty("sun.boot.class.path"));

        //测试 扩展类加载器 EtxClassLoader 加载文件
        //System.out.println(System.getProperty("java.ext.dirs"));

        /*
            测试系统类加载器 AppClassLoader 加载文件
            负责加载应用程序classpath目录下的所有jar和class文件
            一般java应用的类 都有他完成加载
            可以通过 ClassLoader.getSystemClassLoader()来获取它。
            我们可以通过System.getProperty(“java.class.path”) 来查看 classpath。
         */
        //System.out.println(System.getProperty("java.class.path"));




    }

}

class  SuperClass{

    static {
        System.out.println("SuperClass init!");
    }
    public  static  int value=123;

}

/**
 *
 *代码块和成员变量的顺序取决他们的编写顺序  从上至下
 *
 */
class SubClass extends SuperClass{
    public  static  int value=123;
    static {
        value=1234;
        System.out.println("SubClass init!");
    }
    {
        System.out.println("SubClass 普通代码块");
    }

}
/*
class String {

    public static int a=1;

}*/
