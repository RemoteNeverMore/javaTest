package java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

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
        List<Test> list = Arrays.asList(new Test("1", BigDecimal.ONE,1+""),new Test("2", BigDecimal.ONE,1+""),
                new Test("1", BigDecimal.ONE,2+""));
//        Date max = list.stream().map(Test::getDate).max(Date::compareTo).get();
//        Date min = list.stream().map(Test::getDate).min(Date::compareTo).get();
//        LongAdder longAdder = new LongAdder();
//        longAdder.add(1);
//        System.out.println(longAdder.intValue());



        Map<String, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(Test::getName,
                        Collectors.mapping(Test::getVar, Collectors.toList())));
       String collect = map.get("1").stream().sorted().collect(Collectors.joining(","));
        System.out.println(collect);

    }


}
