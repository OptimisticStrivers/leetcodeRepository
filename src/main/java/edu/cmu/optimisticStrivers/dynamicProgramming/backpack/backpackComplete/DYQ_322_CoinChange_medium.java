package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpackComplete;

/**
 * @ClassName: DYQ_322_CoinChange_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/12 5:02 下午
 * @Version 1.0
 */
    public class DYQ_322_CoinChange_medium {
//    https://leetcode.cn/problems/coin-change/solution/yi-pian-wen-zhang-chi-tou-bei-bao-wen-ti-sq9n/


//    完全背包最值问题


    //dfs
    int res = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        findWay1(coins, amount, 0);
        // 如果没有任何一种硬币组合能组成总金额，返回 -1
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public void findWay1(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int i = 0; i < coins.length; i++) {
            findWay1(coins, amount - coins[i], count + 1);
        }
    }

    //记忆化搜索
    int[] memo;

    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];
        return findWay2(coins, amount);
    }

    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay2(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay2(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }


    //dp
    public int coinChange_dp(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int curMin = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) { //看看前面有么有
                    if (dp[i - coins[j]] < curMin) { //只有比curMin小，我们才bother去更新
                        curMin = dp[i - coins[j]] + 1;
                    }
                }
            }
            dp[i] = curMin;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    //普通dp，二维
    public static int coinChange_normal_dp(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int curCoin = coins[i - 1];
                for (int k = 0; k * curCoin <= j; k++) { //当前硬币拿几个
                    if (dp[i - 1][j - k * curCoin] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * curCoin] + k);
                    } //有的话才行，因为java不能再用MAX_VALUE再加了
                    //没有的话就不用管了，这种情况不存在
                }
            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }


    //dp1
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int coin : coins) { //其实和416的dp思路一样，行是物品，列是背包容量
            for (int i = 0; i <= amount; i++) { //必须从左往右走，和416题的从右往左不一样
                if (coin <= i) { //可以选
                    if (dp[i - coin] != Integer.MAX_VALUE) { //上一步是可以拿到的
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1); //看原来的结果，和现在，哪个需要的硬币数量少
                    }
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,2,5};
        System.out.println(coinChange_normal_dp(a, 11));
    }
}
