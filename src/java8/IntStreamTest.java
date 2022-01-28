package java8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: wangchao
 * @create: 2022-01-17 23:22
 **/
public class IntStreamTest {


    public static void main(String[] args) {
        // 0~999999.99
        Pattern pattern = Pattern.compile("^([0-9]|[1-9][0-9]{0,6})(\\.[1-9]|\\.[0-9][1-9])?$");
        String platformRate = "0";
        Matcher m = pattern.matcher(platformRate);

        int a = 200/ 150;
        System.out.println(a);
//        IntStream.range(0, 5).forEach(System.out::println);
    }
}
