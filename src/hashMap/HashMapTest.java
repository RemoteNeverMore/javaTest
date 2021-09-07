package hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class HashMapTest {
    public static void main(String[] args) {
//        Map<String,String> map = new ConcurrentHashMap<>(11);
//        Object o = null;
//        map.put("String1","String");
//        for (int i = 0; i < 10; i++) {
//            map.put("String"+String.valueOf(i+2),"String");
//        }
//        map.put("String12","String");
//        map.put("String13","String");

                Map<String,String> map = new HashMap<>(11);
        Object o = null;
        map.put("String1","String");
        for (int i = 0; i < 10; i++) {
            map.put("String"+ (i + 2),"String");
        }
        map.put("String12","String");
        map.put("String13","String");
//
//

    }
}
