package collections;

import com.sun.javafx.binding.StringFormatter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

public class ListTest {


    public static void main(String[] args) {



//        List<String> list =  new ArrayList<String>();
//        for (int  i = 0;  i < 30;  i++) {
//            list.add(String.valueOf(i));
//        }
//
//        list.forEach(o->{
//            if(o.equals("20")){
//                return;
//            }
//            System.out.println(o);
//        });
//        RuntimeException e =  new RuntimeException("xxxxException");
//        System.out.println(String.format("xxxx:[%s]", e));


//
//        for (int i = 0; i < 5; i++) {
//           if(list.get(i).equals("3")){
//               list.remove("1");
//           }
//        }

//        for (String o: list) {
//            if(o.equals("2")){
//               list.remove("2");
//           }
//        }
//        list.removeIf(o->o.equals("2"));
//        for (int i = 4; i >= 0; i--) {
//            if(list.get(i).equals("1")){
//                list.remove("1");
//            }
//        }
//        System.out.println(list.size());



//        spiltList(list);

        List<String> list = new ArrayList<>(10);
        list.add("guan");
        list.add("bao");

        List<String> list1 = new ArrayList<>(10);
        list1.add("guan1");
        list1.add("bao1");
        list1.retainAll(list1);
        System.out.println(list1);
        String[] array = list.toArray(new String[0]);



    }

    public static List<List<String>> spiltList(List<String> orderList) {
        List<List<String>> groupList = new ArrayList<>();
        int count = 22;
        int sumSize = orderList.size();
        for (int i = 0; i < sumSize; i += count) {
            int lastIndex = i + count;
            if ((i + count) > sumSize) {
                lastIndex = sumSize;
            }
            List<String> subList = orderList.subList(i, lastIndex);
            groupList.add(subList);
        }
        return groupList;
    }







}
