package testSomething;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStr {
	
	
	public static void main(String[] args) {
		
		String[] a = {"w","xc","win"};
		System.out.println(Arrays.toString(a));
		
		
		List<String> l = new ArrayList<String>();
		l.add("12");
		l.add("89");
		l.add("56");
		System.out.println(l.toString());
	}
}
