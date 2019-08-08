package testSomething;

public class TestRegex {
	
	
	public static void main(String[] args) {
		
		String str = ", 'AAAQ1eAAFAAACdGAB+'";
		
		System.out.println(str.matches("(, ){1}('){1}[a-zA-Z0-9]{17}(\\+|\\/){1}('){1}"));
		
	}
}
