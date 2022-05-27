package Regex;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: wangchao
 * @create: 2022-02-17 16:45
 **/
public class RegexTest {

    public static void main(String[] args) {
        String regex = "^([0-9]|[1-9][0-9]{0,4})(\\.[0-9]|\\.[0-9][0-9]|\\.[0-9][0-9][0-9])?$"; //0至99999.999
        Pattern pattern = Pattern.compile(regex);

//        System.out.println("100000.000" +"-------->" + pattern.matcher("100000.000").matches());
//        System.out.println("100000" +"-------->" + pattern.matcher("100000").matches());
//        System.out.println("101.001" +"-------->" + pattern.matcher("101.00").matches());
//        System.out.println("100.00.00" +"-------->" + pattern.matcher("100.00.00").matches());
//        System.out.println("-1.00" +"-------->" + pattern.matcher("-1.00").matches());
//        System.out.println("0.00" +"-------->" + pattern.matcher("0.00").matches());
//        System.out.println("0" +"-------->" + pattern.matcher("0").matches());
//        System.out.println("1.12" +"-------->" + pattern.matcher("1.12").matches());
//        System.out.println("1.00" +"-------->" + pattern.matcher("1.00").matches());
//        System.out.println("01.00" +"-------->" + pattern.matcher("01.00").matches());


        Pattern pattern1 = Pattern.compile("^([0-9]|[1-9][0-9]{0,2})(\\.[0-9]|\\.[0-9][0-9])?$");
        Matcher m = pattern1.matcher("0.01");
        System.out.println(m.matches());
    }
}
