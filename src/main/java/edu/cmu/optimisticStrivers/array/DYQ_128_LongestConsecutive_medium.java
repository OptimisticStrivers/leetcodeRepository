package edu.cmu.optimisticStrivers.array;

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

    //首先肯定不能排序，人家要O(n)的时间复杂度，那么我们就要用空间去换时间，set

    // public int longestConsecutive(int[] nums) {

    //     Set<Integer> set = new HashSet<>();
    //     for(int n : nums) set.add(n);
    //     int max = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         int cur = nums[i];
    //         if (!set.contains(cur - 1)) { //是某一序列的第一个
    //             int count = 1;
    //             while (set.contains(cur + 1)) {
    //                 cur++;
    //                 count++;
    //             }
    //             max = Math.max(max, count);
    //         }
    //     }
    //     return max;
    // }

    //上面的方法，严格来说不是O(n)，用过以后删掉比较好
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.remove(nums[i])) {
                int count = 1;
                int cur = nums[i];
                //向后
                while (set.remove(cur+1)) {
                    cur++;
                    count++;
                }
                cur = nums[i]; //reset
                //向前
                while (set.remove(cur-1)){
                    cur--;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}