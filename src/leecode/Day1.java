package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-30 10:17
 **/
public class Day1 {


    public static void main(String[] args) {
        int[] arr = {0,3,2,3,5,6}; int target = 5;
        System.out.println(twoSum(arr, target));
    }

     //找到即回
    private static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; ++i) {
            if (hashtable.containsKey(target - arr[i])) {
                return new int[]{hashtable.get(target - arr[i]), i};
            }
            hashtable.put(arr[i], i);
        }
        return new int[0];




    }


}
