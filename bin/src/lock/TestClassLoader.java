package lock;

import sun.applet.AppletClassLoader;
import sun.misc.Launcher;
import sun.misc.Unsafe;

public class TestClassLoader {

    public static void main(String[] args) {
        //System.out.println(SubClass.value);
        //˳�����:
        //SuperClass init!
        //SubClass init!
        //1234

        //���� ����������� BootStrap ClassLoader ���ص��ļ�
        //System.out.println(System.getProperty("sun.boot.class.path"));

        //���� ��չ������� EtxClassLoader �����ļ�
        //System.out.println(System.getProperty("java.ext.dirs"));

        /*
            ����ϵͳ������� AppClassLoader �����ļ�
            �������Ӧ�ó���classpathĿ¼�µ�����jar��class�ļ�
            һ��javaӦ�õ��� ��������ɼ���
            ����ͨ�� ClassLoader.getSystemClassLoader()����ȡ����
            ���ǿ���ͨ��System.getProperty(��java.class.path��) ���鿴 classpath��
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
 *�����ͳ�Ա������˳��ȡ�����ǵı�д˳��  ��������
 *
 */
class SubClass extends SuperClass{
    public  static  int value=123;
    static {
        value=1234;
        System.out.println("SubClass init!");
    }
    {
        System.out.println("SubClass ��ͨ�����");
    }

}
/*
class String {

    public static int a=1;

}*/
