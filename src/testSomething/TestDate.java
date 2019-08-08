package testSomething;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDate {

    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.CHINA);//显示星期几
        System.out.println(sdf.format(date));
        
        String $qw1 = "123";
        System.out.println($qw1);
        String _$qw1 = "123";
        System.out.println(_$qw1);

        byte a = (byte)128;
        System.out.println(a);//-128  byte -128 ~ 127

        int b = 0b11;//2进制表示
        System.out.println(b);//3

        int c = 011;//8进制表示
        System.out.println(c);//9

        int d = 0x11;//16进制表示
        System.out.println(d);//17

        double a1 = 3.13445E1;
        System.out.println(a1);
        BigDecimal a2 = new BigDecimal(a1);
        System.out.println(a2.toPlainString());

        double f = 3.123456678987657899;
        System.out.println(f);

        short s1 = 12;
    }
}
