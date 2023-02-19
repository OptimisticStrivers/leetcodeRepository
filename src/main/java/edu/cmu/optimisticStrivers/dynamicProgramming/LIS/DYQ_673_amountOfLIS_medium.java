package edu.cmu.optimisticStrivers.dynamicProgramming.LIS;

import java.util.Arrays;

/**
 * @ClassName: DYQ_673_amountOfLIS_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/15 11:35 AM
 * @Version 1.0
 */
public class DYQ_673_amountOfLIS_medium {

    //在300的基础上加一个数组

    public static int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //表示以nums[i]结尾的最长子序列 长度是多少
        Arrays.fill(dp, 1);
        int[] amount = new int[nums.length];//表示以nums[i]结尾的最长子序列 有几个
        Arrays.fill(amount, 1);

        for (int i = 1; i < nums.length; i++) {
            int maxLen = 1;
            int maxLenAmount = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { //严格递增
                    if (dp[j] + 1 == maxLen) {
                        maxLenAmount += amount[j];
                        continue;
                    }
                    if (dp[j] + 1 > maxLen) {
                        maxLen = dp[j] + 1;
                        maxLenAmount = amount[j];
                        continue;
                    }
                }
            }
            dp[i] = maxLen;
            amount[i] = maxLenAmount;
        }

        System.out.println(Arrays.toString(amount));
        System.out.println(Arrays.toString(dp));

        int maxLen = Arrays.stream(dp).max().getAsInt();
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLen) {
                res += amount[i];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }
}
