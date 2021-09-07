package java8;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-23 15:19
 **/
public class StreamTest {

    public static void main(String[] args) {
//        List<Test> list = Arrays.asList(new Test(1),new Test(2),new Test(3),new Test(4),new Test(5));
//        int sum = list.stream().filter(o -> o.getVar() > 2)
//                .mapToInt(Test::getVar)
////                .sum();
//               .reduce(100,Integer::sum);
//        System.out.println(sum);

//
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
        Map<String, Double> map = pairArrayList.stream().collect(
       // 生成的 map 集合中只有一个键值对：{version=6.28}
       Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
        System.out.println(map);

    }
}
