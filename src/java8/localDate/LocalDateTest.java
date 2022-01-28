package java8.localDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-22 15:08
 **/
public class LocalDateTest {

    public static void main(String[] args) {
        String dateTime = "2021-9-9";
        dateTime = dateTime.length() > 10 ? dateTime.substring(0, 10).trim() : dateTime;
        String[] dateArr = dateTime.split("-");
        if (Objects.nonNull(dateArr) && dateArr.length == 3) {
            for (int i = dateArr.length-1; i >= 1 ; i--) {
               int varLength = dateArr[i].length();
               if(varLength == 1){
                   dateArr[i] = '0'+dateArr[i];
               }
                System.out.println(dateArr[i]);
            }
        }

        dateTime = String.join("-",dateArr);
        System.out.println(dateTime);
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-M-d");
//        //  这里只处理 yyyy-MM-dd
//        dateTime = dateTime.length() > 10 ? dateTime.substring(0, 10).trim() : dateTime;
//        LocalDate startDate = LocalDate.parse(dateTime, fmt);
//        LocalDate endDate = LocalDate.now();
//        long differMonths = startDate.until(endDate, ChronoUnit.MONTHS);
//        System.out.println(differMonths);
    }

}
