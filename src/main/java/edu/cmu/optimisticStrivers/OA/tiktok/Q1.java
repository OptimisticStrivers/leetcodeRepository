package edu.cmu.optimisticStrivers.OA.tiktok;

import java.util.Arrays;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/11/14 9:59 PM
 * @Version 1.0
 */
public class Q1 {


    //这题因为 约束了 一共要使用多少个coin
    //所以518这个完全背包组合问题还不能直接用，因为518只是在记录combination的个数
    //外层是coin 内层是value
    public static int coinChange518(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;//因为是 组合问题 所以初始状态为1，322是最值问题，所以初始状态为0
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) { //必须从左往右，因为是完全背包，可以重复取
                if (coin <= i) { //当前硬币可以拿
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
//
//    public static int coinChange(int n, int m) {
//        if (m % 10 != 0) {
//            return 0;
//        }
//        m /= 10;
//    }


    public static int dp(int n, int m) {
        if (m % 10 != 0) {
            return 0;
        }
        m /= 10;
        int[][] ints = new int[m + 1][3];
        ints[0][0] = 1;
        for (int i = 1; i <= n; i++) { //需要n张card
            for (int j = m; j >= 0; j--) { //必须自底向上
                //j==0也必须清除 比如当我们第二张card的时候  amount == 1已经不能从第二张card得到了
                ints[j][0] = 0; //必须清除 因为每个新的card 就要基于前面一张card再来重新算了
                ints[j][1] = 0;
                ints[j][2] = 0;
                //保证combination 不重复的关键就是 顺序，或者说排序。 111 333 555 大的coin只能出现在小的后面
                if (j - 1 >= 0) {
                    ints[j][0] = ints[j - 1][0];
                }
                if (j - 3 >= 0) {
                    ints[j][1] = ints[j - 3][0] + ints[j - 3][1];
                }
                if (j - 5 >= 0) {
                    ints[j][2] = ints[j - 5][0] + ints[j - 5][1] + ints[j - 5][2];
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
        return ints[m][0] + ints[m][1] + ints[m][2]; //最后一张是1 最后一张是3 最后一张是5
    }

    public static void main(String[] args) {
        System.out.println( dp(3,50));
//        System.out.println(dp(, 80));

    }

}
