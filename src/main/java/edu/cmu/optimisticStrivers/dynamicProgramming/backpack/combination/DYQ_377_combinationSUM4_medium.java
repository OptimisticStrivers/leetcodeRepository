package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.combination;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DYQ_377_combinationSUM4_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/11/28 9:42 AM
 * @Version 1.0
 */
public class DYQ_377_combinationSUM4_medium {

//    https://leetcode.cn/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    //记忆化
    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum41(int[] nums, int target) {
        return backtrack(nums, target);
    }

    private int backtrack(int[] nums, int remains) {
        if (remains == 0)
            return 1;

        if (map.containsKey(remains))
            return map.get(remains);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (remains >= nums[i])
                res += backtrack(nums, remains - nums[i]);
        }

        map.put(remains, res);
        return res;
    }

}
