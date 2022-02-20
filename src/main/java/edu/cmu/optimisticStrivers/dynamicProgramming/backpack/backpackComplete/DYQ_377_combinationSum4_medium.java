package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpackComplete;

/**
 * @ClassName: DYQ_377_combinationSum4_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/20 4:18 下午
 * @Version 1.0
 */
public class DYQ_377_combinationSum4_medium {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for(int num: nums){
                if(num<=i){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
