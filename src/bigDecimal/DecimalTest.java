package bigDecimal;

import java.math.BigDecimal;

public class DecimalTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("4.6");
        BigDecimal b2 = new BigDecimal("4.6");
        BigDecimal b3 = new BigDecimal("4.6");
        BigDecimal b4 = new BigDecimal("4.6");
        BigDecimal sum = b1.add(b3).add(b2).add(b4);

        BigDecimal muptiply = b1.multiply(new BigDecimal(4));
        System.out.println(sum);
        System.out.println(muptiply);

    }
}
