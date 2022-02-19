package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_53_MaxSubArray_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/2 7:24 下午
 * @Version 1.0
 */
public class DYQ_53_MaxSubArray_easy {

    // dp 必有的 就是 一个dp数组 -》保存临时结果的

//    nums[i];
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] += Math.max(0,dp[i-1]); // i = 2
            res = Math.max(dp[i],res);
        }
        return res;
    }

//    [-2,1,-3,4,-1,2,1,-5,4]



    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i<nums.length; i++){
            nums[i] += Math.max(0,nums[i-1]);
            res = Math.max(nums[i],res);
        }
        return res;
    }


}