package hashMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        String s = "1";
        String a = "1";
        System.out.println(s.hashCode());System.out.println(a.hashCode());
        System.out.println(a==s);
    }
}
