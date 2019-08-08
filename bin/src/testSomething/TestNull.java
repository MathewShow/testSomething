package testSomething;

public class TestNull {

	public static void main(String[] args) {
		/*Long id = null;
		System.out.println(id + "123");//null123

		String sql = null;
		String.format(sql, "12");//报空指针异常*/

		/*String formate = "%s用户来自%s";
		String input = String.format(formate, "许诚", "湖南");
		System.out.println(input);*/

		String formate = "应收款%f";
		String input = String.format(formate,100d);
		System.out.println(input);

	}
	
}
