package java8;

import java.util.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-11 10:16
 **/
public class DateTest {


    public static void main(String[] args) {
        minAndMaxDate();
    }

    static void minAndMaxDate(){
        List<Test> list = Arrays.asList(new Test("2020-03-21"),new Test("2020-04-21"),new Test("2020-04-20"));
        Date max = list.stream().map(Test::getDate).max(Date::compareTo).get();
        Date min = list.stream().map(Test::getDate).min(Date::compareTo).get();
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        System.out.println(longAdder.intValue());

    }


}
