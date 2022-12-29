package edu.cmu.optimisticStrivers.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DYQ_18_4sum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/26 7:38 PM
 * @Version 1.0
 */
public class DYQ_18_4sum_medium {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        // 0 1 2 3
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
//                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long)nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++; //去重
                        while (l < r && nums[r] == nums[r - 1]) r--; //去重
                        l++; //不等了以后 要 ++ 到 l+1
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
