package leecode;

import java.util.List;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-01 14:28
 **/
public class Day2 {


    public static void main(String[] args) {
        ListNode l1 =new ListNode();
        l1.val = 9;
        l1.next = new ListNode(9,new ListNode(9));
        ListNode l2 =new ListNode();
        l2.val = 9;
        addTwoNumbers(l1,l2);
    }

    private static ListNode addTwoNumbers(ListNode l1 , ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        ListNode currNode1 = l1;
        while(currNode1 != null){
            ListNode temp = currNode1.next;
            sb1.append(currNode1.val);
            currNode1 = temp;
        }
        String var1 = sb1.toString();
        StringBuilder sb2 = new StringBuilder();
        ListNode currNode2 = l2;
        while(currNode2 != null){
            ListNode temp = currNode2.next;
            sb2.append(currNode2.val);
            currNode2 = temp;
        }
        String var2 = sb2.toString();
        int len = Math.max(var1.length(), var2.length());
        int nexPlus = 0;
        ListNode pre = new ListNode() ;
        ListNode cur = pre;
        for (int i = 0; i < len; i++) {
            int var1_n = i < var1.length() ? var1.charAt(i) - '0' : 0;
            int  var2_n = i < var2.length() ? var2.charAt(i) - '0': 0;
            int sum = var1_n  + var2_n+ nexPlus;
            nexPlus = 0;
            int s = sum;
            if(sum>9){
                nexPlus = 1;
                s = sum -10;
            }
            cur.next = new ListNode(s);
            cur = cur.next;
            //处理最后一位进位问题
            if(nexPlus == 1 && i == len -1){
                cur.next = new ListNode(1);
            }
        }
        return pre.next;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
