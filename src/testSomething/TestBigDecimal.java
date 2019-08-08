package testSomething;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TestBigDecimal {
    public static void main(String[] args) {
        /*double a = 10;
        double b = 10;
        long c = 3;
        double d = (a + b) / c;
        BigDecimal bigDecimal = new BigDecimal(d);
        double f = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);
        System.out.println(f);
        DecimalFormat df = new DecimalFormat("#.0");
        String format = df.format(d);
        double v = Double.parseDouble(format);
        System.out.println(format);*/

        Long a = 100l;
        Long b = 100l;
        System.out.println(a==b);

        Long aLong = new Long(100);
        Long aLong1 = new Long(100);
        System.out.println(aLong.hashCode());
        System.out.println(aLong1.hashCode());
        System.out.println(aLong==aLong1);
        System.out.println(aLong.longValue()==aLong1.longValue());
        System.out.println(aLong.equals(aLong1));


    }
}
