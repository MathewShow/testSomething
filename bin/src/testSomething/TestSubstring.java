package testSomething;

public class TestSubstring {

    public static void main(String[] args) {
        String str = "CWDM-OP16-A";
        int end = str.lastIndexOf("-");
        int num = Integer.parseInt(str.substring(7,end));
        System.out.println(num);
    }
}
