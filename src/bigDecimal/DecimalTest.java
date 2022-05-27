package javaTest.src.bigDecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalTest {
    public static void main(String[] args) {
//        BigDecimal b1 = new BigDecimal("4.6");
//        BigDecimal b2 = new BigDecimal("4.6");
//        BigDecimal b3 = new BigDecimal("4.6");

//        DecimalFormat df = new DecimalFormat("#");
//        double a = 99.00;
//        System.out.println(df.format(a));
//        double b = 94.00;
//        System.out.println(df.format(b));
//        double c = 95.00;
//        System.out.println(df.format(c));
//        System.out.println(df.format(a));
//        System.out.println(df.format(a));



        BigDecimal b4 = new BigDecimal("4.6");

        BigDecimal b5 = new BigDecimal(0.1F);
        BigDecimal b5_1 =  BigDecimal.valueOf(0.1F);
        BigDecimal b6 = new BigDecimal("0.1");

        BigDecimal b1 = new BigDecimal("4.6");
//        System.out.println(b1.divide(new BigDecimal(3)));

//        BigDecimal b2 = new BigDecimal("4.6");
//        System.out.println(b1.divide(new BigDecimal(3).setScale(2, BigDecimal.ROUND_HALF_UP)));

        BigDecimal b3 = new BigDecimal("3");
        System.out.println(b3.divide(new BigDecimal(8),2,BigDecimal.ROUND_FLOOR));
        System.out.println("Nex".equalsIgnoreCase("NEX"));


//        BigDecimal sum = b1.add(b3).add(b2).add(b4);
//
//        BigDecimal muptiply = b1.multiply(new BigDecimal(4));
//        System.out.println(sum);
//        System.out.println(muptiply);


        String format = String.format("平台税率【%1$s】应在区间0%%至999.99%%之间，%%并且保留两位小数。", "13");
        System.out.println(format);


    }
}
