package testSomething;

public class TestObjects {

	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj);
		update(obj);
	}

	public static void update(Object obj){
		obj = fillObject(obj);
		System.out.println(obj);
	}
	public static Object fillObject(Object obj){
		Object obj2 = new Object();
		//DO ����obj2������
		//����ĵط�
		System.out.println("obj2>>>>>>>>"+obj2);
		return obj2;
	}
}
