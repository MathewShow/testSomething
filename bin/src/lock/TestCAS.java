package lock;

import sun.misc.Unsafe;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * CAS���� �ֳ�Ϊ�������� ��һ���ֹ�������
 */
public class TestCAS {

    public static void main(String[] args) {
        Class map = HashMap.class;
        System.out.println(map.getClassLoader());
        AtomicReference<Object> objectAtomicReference = new AtomicReference<>();
        new AtomicStampedReference<Date>(new Date(),1);
        new AtomicInteger();
        Unsafe.getUnsafe();
    }

}
