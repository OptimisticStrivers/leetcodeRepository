package edu.cmu.optimisticStrivers.array;

import java.util.Arrays;

/**
 * @ClassName: DYQ_16_3SumClosest_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/27 5:30 PM
 * @Version 1.0
 */
public class DYQ_16_3SumClosest_medium {

    public static int threeSumClosest(int[] nums, int target) {
//        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                } else {
                    if (Math.abs(sum - target) < diff) {
                        res = sum;
                        diff = Math.abs(sum - target);
                    }
                    if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 2};
        System.out.println(threeSumClosest(ints, 3));
    }

}
