package java8.localDate;

import java.time.LocalDate;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-22 15:08
 **/
public class LocalDateTest {

    public static void main(String[] args) {
        int days = LocalDate.of(2011, 1, 1).lengthOfYear();
        int daysOfThisYear = java.time.LocalDate.now().lengthOfYear();
        System.out.println(daysOfThisYear);
    }

}
