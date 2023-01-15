package edu.cmu.optimisticStrivers.dynamicProgramming.plalindrome;

/**
 * @ClassName: DYQ_5_longestSubStringPalindrome_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/2 6:50 下午
 * @Version 1.0
 */
public class DYQ_5_longestSubStringPalindrome_medium {

    //和647不能说没有区别，只能说一摸一样

    //dp
    public String longestPalindrome(String s) {
        int len = 0;
        String res = null;
//        "babad" j=1 i=3 aba dp[j][i]
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {//右侧
            for (int left = 0; left <= right; left++) { //左侧
                if (s.charAt(right) == s.charAt(left)) {
                    if (right - left < 2 || dp[left + 1][right - 1]) { //一个数或者一共两个数就是 i-j<2
                        dp[left][right] = true;
                        if (right - left + 1 > len) { //sorry sorry sorry
                            res = s.substring(left, right + 1);
                            len = right - left + 1;
                        }
                    }
                }
            }
        }
        return res;
    }

    //    //空间是o1 空间还是on2
    //    //中心点放啊
    //    //关键就是找中心点
    //    //一共有 2*len-1 个中心点
    public String longestPalindrome1(String s) {
        String res = null;
        int len = 0;
        int numOfCenter = 2 * s.length() - 1;
        for (int center = 0; center < numOfCenter; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > len) {
                    len = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
