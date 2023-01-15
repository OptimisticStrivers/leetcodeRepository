package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpackComplete.completeCombination;

/**
 * @ClassName: DYQ_518_CoinChange_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/19 5:54 下午
 * @Version 1.0
 */
public class DYQ_518_CoinChange_medium {

//    一文搞懂
//    https://leetcode.cn/problems/coin-change/solution/yi-pian-wen-zhang-chi-tou-bei-bao-wen-ti-sq9n//**/
//    https://leetcode.cn/problems/coin-change-ii/solution/by-flix-e1vv/
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){ //这样可以保证顺序 有点像 回溯的 排序 combination那道题
            for (int i = 0; i <= amount; i++) { //必须从左往右，因为是完全背包，可以重复取
                if(coin<=i){ //当前硬币可以拿
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
     }
}
