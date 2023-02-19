package edu.cmu.optimisticStrivers.brainTwister;

/**
 * @ClassName: DYQ_908_smallestRange1_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/22 5:49 下午
 * @Version 1.0
 */
public class DYQ_908_smallestRange1_easy {



//解题思路 先求出数组中的最大值 max 和最小值 min, 判断 max-k 和min+k 之间的距离，如果为负数代表分数为0，如果距离为正数，代表最小分数就是这段距离。


    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for(int n : nums ){
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        int ans = max-k-min-k;
        return ans < 0 ? 0 : ans;
    }

}
