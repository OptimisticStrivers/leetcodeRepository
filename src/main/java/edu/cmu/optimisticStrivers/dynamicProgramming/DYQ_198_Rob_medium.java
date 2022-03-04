package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_198_Rob_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/15 5:06 下午
 * @Version 1.0
 */
public class DYQ_198_Rob_medium {
    //传统dp
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }


//    1 3 1 1 4
//    1 3 3 4 7

    //滚动数组dp
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
