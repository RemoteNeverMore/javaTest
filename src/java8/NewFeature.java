package java8;

import com.sun.xml.internal.ws.policy.PolicyMapUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-10 22:16
 **/
public class NewFeature {
    public static void main(String[] args) {
        mapNotNull();
    }

    private static void mapNotNull() {
        Map<String , List<String>> map = new HashMap<>();
        map.getOrDefault("vvv",new ArrayList<>());//避免npe
        map.computeIfAbsent("java框架", o -> new ArrayList<String>()).add("Spring");//为空就list.add("spring")
    }
}
