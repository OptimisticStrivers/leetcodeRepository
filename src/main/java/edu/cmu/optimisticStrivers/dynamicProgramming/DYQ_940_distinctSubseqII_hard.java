package edu.cmu.optimisticStrivers.dynamicProgramming;

import java.util.Arrays;

/**
 * @ClassName: DYQ_940_distinctSubseqII_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/15 7:47 上午
 * @Version 1.0
 */
public class DYQ_940_distinctSubseqII_hard {

    public  int distinctSubseqII(String S) {
        int divisor = 1_000_000_007;
        int len = S.length();
        int[] dp = new int[len];
        int[] last = new int[26]; //记录每个字母上次出现啥时候，也可以用map
        Arrays.fill(last, -1); //一开始斗门访问过
        dp[0] = 2; //'' 和 'x'
        last[S.charAt(0) - 'a'] = 0;
        for (int i = 1; i < len; i++) {
            int indexOfLast = S.charAt(i) - 'a';
            int lastIndex = last[indexOfLast];
            dp[i] = (2 * dp[i - 1]) % divisor;
            if (lastIndex != -1) { //说明之前遇到过
                if(lastIndex==0){ //上次见是在第一个的话，防止越界，这样写
                    dp[i]--; //减去1意思是 减掉''
                }else{
                    dp[i] -= dp[lastIndex - 1];
                }
            }
            dp[i] %= divisor;
            last[indexOfLast] = i;
        }
        dp[len - 1]--;//减掉' '
        if (dp[len - 1] < 0) dp[len - 1] += divisor; //不让他为负数
        return dp[len - 1];
    }

//    https://leetcode-cn.com/problems/distinct-subsequences-ii/solution/bu-tong-de-zi-xu-lie-ii-by-leetcode/
//
//    public static void main(String[] args) {
//        int a = 1_000_000_007;
//        System.out.println(distinctSubseqII("abc"));
//    }
}
