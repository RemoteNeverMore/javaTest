package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-08 15:35
 **/
public class Day6 {


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        System.out.println(convert("ABC", 2));

    }

    public static String convert(String s, int numRows) {
        List<StringBuilder> sumList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sumList.add(new StringBuilder());
        }
        if(numRows < 2) return s;
        StringBuilder sb = new StringBuilder();
        int mid = 0;
        int target = numRows;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.charAt(i));
            if (numRows == 2) {
                if(i%2==0){
                    sumList.get(0).append(c);
                }else{
                    sumList.get(1).append(c);
                }
                continue;
            }
            //组成竖列
            if (target > 0) {
                sumList.get(Math.abs(target - numRows)).append(c);
                if (target != 1 && target != numRows) {
                    mid++;
                }
                target--;
            } else if (target <= 0 && mid > 0) {

                sumList.get(Math.abs(mid)).append(c);
                mid--;
                if (mid == 0) {
                    target = numRows;
                }
            }
        }
        for (int i = 0; i < sumList.size(); i++) {
            StringBuilder sub = sumList.get(i);
            sb.append(sub);
        }
        return sb.toString();
    }

    public static  String convert1(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
