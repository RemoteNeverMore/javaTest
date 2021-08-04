package leecode;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-06 11:07
 **/
public class Day5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome_v2("dsasd"));
    }

    //返回最长回文子串
    public static String longestPalindrome_v1(String source){

        if (source.length() == 1) {
          return source;
        }
        //中心扩散法
        int left = 0 , right = 0;
        int indexStart = 0 , indexEnd = 0;
        int length = source.length();
        int len = 0;
        int maxLen =0;
        String str = null;
        // i 为中心
        for (int i = 0; i < length; i++) {
            left = i -1;
            right = i + 1;
            while(left >= 0 && source.charAt(left) == source.charAt(i)){
                left--;
                len++;
            }
            while(right < length && source.charAt(right) == source.charAt(i)){
                right++;
                len++;
            }
            while(left < right && left >= 0 && right<length && source.charAt(right) == source.charAt(left)){
                left--;
                right++;
                len+=2;
            }
            if(len > maxLen){
                str = source.substring(left+1,right);
            }
            maxLen=Math.max(len,maxLen);
            len  = 1;

        }
        return str;
    }

    //只要s[i-1,j+1] 是一个回文，s[i]==s[j] 则 s[i][j]是个回文
    public static String longestPalindrome_v2(String s){

        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
