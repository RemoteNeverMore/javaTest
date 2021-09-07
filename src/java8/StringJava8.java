package java8;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-23 15:41
 **/
public class StringJava8 {
    static List<String> list = Arrays.asList("1","b","2");

    public static void main(String[] args) {

        String name = "sssxx__name";
        System.out.println(name.substring(name.lastIndexOf("__")+2));


        List<String> list = new ArrayList<>();
//        list.add("d,cd,2");
//        list.add("aa,ca2");
//        list.add("bbb1");
//        list.add("aaa1");
//        list.add("bbb3");
//        list.add("ccc");
//        list.add("bbb2");
//        list.add("ddd1");
        list.stream().collect(Collectors.toList());

        List<String> addrList = list.stream().flatMap(x->Arrays.stream(x.split(","))).collect(Collectors.toList());
        System.out.println(addrList);
//        System.out.println(tem);
//        int num = 9;
//        list.stream().filter(o-> o.hashCode()/2 ==0).map(o-> o + num);
//        match(list);
//        count(list);
//        sort(list);


    }

    private static String getName() {
        System.out.println("orElse");
        return "--------";
    }

    private static void sort(List<String> list) {
        String s = list.stream().sorted().reduce((o1, o2) -> o1 + "---" + o2).get();
        System.out.println(s);
    }


    public static void match(List<String> list){
        boolean b = list.stream().anyMatch(str -> str.startsWith("d"));
        System.out.println(b);//true

        boolean b1 = list.stream().allMatch(str -> str.startsWith("d"));
        System.out.println(b1);//f

        boolean b2 =
                        list
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        System.out.println(b2);

    }

    public static void count(List<String> list){

        long d = list.stream().filter(s -> s.startsWith("d")).count();
        System.out.println(d);

    }


}
