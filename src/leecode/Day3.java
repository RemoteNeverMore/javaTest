package leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-02 09:44
 **/
public class Day3 {




    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_v2());
    }
    /**
     * @description: 最长子串
     *
     * @author: wangchao
     * @date    2021/7/2 9:46
     * @param
     * @return  int
    */
    private static int lengthOfLongestSubstring_v1() {
        String target = "aafa";
        int left = 0;
        int maxLen = 0;
        while (left < target.length()) {
            char left_char = target.charAt(left);
            Set<Character> set = new HashSet<>();
            set.add(left_char);
            int right = left + 1;
            while (right < target.length()) {
                char right_char = target.charAt(right);
                if(set.contains(right_char)){
                    break;
                }
                set.add(right_char);
                right++;
            }
            maxLen = Math.max(set.size(), maxLen);
            set.clear();
            left++;
        }
        return maxLen;
    }
    //一次遍历
    private static int lengthOfLongestSubstring_v2() {
        String target = "abba";
        int left = 0;
        int temp_left = 0;
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (left < target.length()) {
            char temChar = target.charAt(left);
            if(map.containsKey(temChar)){
                //即为重要，要取最左边的int  map.get(c) || left;
                temp_left = Math.max(map.get(temChar)+1,left);
            }
            map.put(temChar,left);
            maxLen = Math.max(maxLen,left - temp_left+1);
            left++;
        }
        return maxLen;
    }

}
