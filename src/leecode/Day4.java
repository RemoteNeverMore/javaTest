package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-05 10:48
 **/
public class Day4 {

    public static void main(String[] args) {
        int[] a1 = {1,1}; int[] a2 = {2};
        System.out.println(findMedianSortedArrays_v1(a1, a2));
    }

    private static void findMedianSortedArrays(int[] a1, int[] a2) {
        boolean max_a1 =  a1.length >= a2.length ;
        int[] maxArr = max_a1 ? a1 : a2;
        int[] minArr = !max_a1 ? a1 : a2;
        List<Integer> lastList = new ArrayList<>();
        int jIndex = 0;
        for (int i = 0; i < maxArr.length; ) {
            int avMax = maxArr[i];
            for (int j = jIndex; j < minArr.length;) {
                int avMin = minArr[j];
                if(avMax > avMin){
                    lastList.add(avMin);
                    jIndex++;
                    break;
                }
                if(avMax <= avMin){
                    lastList.add(avMax);
                    i++;
                    break;
                }
            }
            if(jIndex == minArr.length){
                lastList.add(avMax);
                i++;
            }
        }
    }


    public static double findMedianSortedArrays_v1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }


}
