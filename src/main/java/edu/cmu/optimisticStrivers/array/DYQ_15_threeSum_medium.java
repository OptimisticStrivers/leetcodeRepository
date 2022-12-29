package edu.cmu.optimisticStrivers.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DYQ_15_threeSum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/26 6:44 PM
 * @Version 1.0
 */
public class DYQ_15_threeSum_medium {


    //三数之和 最主要的是 知道 两处 去重复的逻辑
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
//        0 1 2
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break; //不可能
            }
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; //去重
                    while (l < r && nums[r] == nums[r - 1]) r--; //去重
                    l++; //不等了以后 要 ++ 到 l+1
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
