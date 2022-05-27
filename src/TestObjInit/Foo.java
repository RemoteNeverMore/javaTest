package TestObjInit;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Foo {
        int i = 1;

        Foo() {
            System.out.println(i);             //-----------(1)
            int x = getValue();
            System.out.println(x);             //-----------(2)
        }

        {
            i = 2;
        }

        protected int getValue() {
            return i;
        }

    public static void main(String[] args) {
//       Thread thread = new Thread(()->{
//           while(true){
//
//           }
//       },"main-thread");
//        thread.start();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss EEE");
//        System.out.println(sdf.format(new Date()));

        float v = Float.parseFloat("10.70 ");
        BigDecimal bg = new BigDecimal("10.747").setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bg);




    }
}
