package collections;

import com.sun.javafx.binding.StringFormatter;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

import static java.util.stream.Collectors.toList;

public class ListTest {


    public static void main(String[] args) {





        List<String> list =  new ArrayList<String>();
        List<String> list1 =  new ArrayList<String>();
        for (int  i = 0;  i < 30;  i++) {
            list.add(String.valueOf(i));
        }

        for (int  i = 0;  i < 23;  i++) {
            list1.add(String.valueOf(i));
        }

        List<String> list2 = list.subList(0, 10);
        System.out.println(list2.size());


//        List<String> reduce1 = list1.stream().filter(item -> !list.contains(item)).collect(toList());

//        System.out.println(Json.string);
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



//
//        List<String> list = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
//        list.add("guan");
//        list.add("bao");
//        list.addAll(list2);
//        System.out.println(list);
//
//        list.forEach(item->{
//            System.out.println(item);
//            if(item.equals("guan")){
//                return;
//            }
//        });
//
//        List<String> list1 = new ArrayList<>(10);
//        list1.add("guan1");
//        list1.add("bao1");
//        Collections.shuffle(list1);
////        list1.retainAll(list1);
////        System.out.println(list1);
//        String[] array = list.toArray(new String[0]);



    }




}
