package testSomething;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class TestBeanUtils {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Dog dog = new Dog();
        dog.setName("����");
        dog.setAge(12);
        dog.setDesc("�����ǹ���");
        Dog dog1 = new Dog();
        BeanUtils.copyProperties(dog,dog1);
        System.out.println(dog.toString());
        System.out.println(dog1.toString());
    }
}
