package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpackComplete;

/**
 * @ClassName: DYQ_279_numSquares_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/20 3:41 下午
 * @Version 1.0
 */
public class DYQ_279_numSquares_medium {

    //完全背包最值问题，和322差不多
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i*i <= n ; i++) {
            for (int j = 1; j <= n  ; j++) {
                if(i*i<=j && dp[j-i*i]!=Integer.MAX_VALUE){ //可以拿
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
