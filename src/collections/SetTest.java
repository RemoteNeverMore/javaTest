package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-08-27 16:00
 **/
public class SetTest {
    private static  Set<String> set = new HashSet<>();
    private static List<String> set1 = new ArrayList<>();

    public static void main(String[] args) {
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set1.add("5");
        set1.add("6");


        set.removeAll(set1);
        System.out.println(set);
    }
}
