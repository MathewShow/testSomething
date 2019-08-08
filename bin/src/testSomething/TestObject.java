package testSomething;

public class TestObject {
	
	public static void main(String[] args) {
		
		Object[] a = new Object[3];
		a[0] = 1;
		a[1] = 10d;
		a[2] = 15d;
		double d = (double) a[1];
		double e = (double)a[0];
		System.out.println(d);
		System.out.println(e);
		
		
	}
}
