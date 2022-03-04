package edu.cmu.optimisticStrivers.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: DYQ_128_LongestConsecutive_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/18 7:14 下午
 * @Version 1.0
 */
public class DYQ_128_LongestConsecutive_medium {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!set.contains(cur - 1)) { //是某一序列的第一个
                int count = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                //count直接拿 cur-nums[i]代替 也可。
                max = Math.max(max, count);
            }
        }
        return max;
    }
}