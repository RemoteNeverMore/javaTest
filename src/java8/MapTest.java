package java8;

import java.util.*;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-21 09:57
 **/
public class MapTest {

    public static void main(String[] args) {
        //一对多的默认值设置
//        Map<String, List<String>> map = new HashMap<>();
//        map.computeIfAbsent("aaa",key-> new ArrayList<>()).add("aaa");
//        map.computeIfAbsent("aaa",key-> new ArrayList<>()).add("333");
//        System.out.println(map); //aaa = ["aaa","333"]
//        //获取默认的List
//        Map<String, List<String>> mapDefault = new HashMap<>();
//        List<String> bbb = mapDefault.getOrDefault("bbb", new ArrayList<>());
//        bbb.add("ssss");
//        System.out.println(bbb);
        Map<String, String> map1 = new HashMap<>();
        map1.put("1","1-v");
        map1.put("2","2-v");
        map1.forEach((v1,v2)->{
            System.out.println(v1 + "---" + v2);
        });
//        String var = "ssss";
//        map1.merge(9, var, (value, newValue) -> value+","+newValue);
//        map1.merge(9, var, (value, newValue) -> value+","+newValue);
        System.out.println(map1);

//        List<String> orderl = null;
//        orderl.addAll(Arrays.asList("ss"));
//        System.out.println(map1);
//        map1.computeIfPresent(9, (num, val) -> null);//会删除键
//        System.out.println(map1.containsKey(9));
//        System.out.println(map1);
//        map1.merge(9, "val9", (value, newValue) -> value.concat(newValue));
//        map1.merge(9, "val9", (value, newValue) -> value.concat(newValue));
//        map1.get(9);             // val9
//        System.out.println(map1);
//        map1.merge(9, "concat", (value, newValue) -> value.concat(newValue));
//        map1.get(9);
//        System.out.println(map1);


//        Map<String,List<Integer>> map = new HashMap<>();
//        map.put("1", Arrays.asList(1,2,3,4,5));
//        map.put("2", Arrays.asList(1,2,3));
//        Map<String,Integer> map1 = new HashMap<>();
//        System.out.println(map);


    }
}
