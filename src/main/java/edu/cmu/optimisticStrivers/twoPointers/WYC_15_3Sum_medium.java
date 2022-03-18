package edu.cmu.optimisticStrivers.twoPointers;
import java.util.*;

public class WYC_15_3Sum_medium {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            get3Sum(nums, i, res);
        }
        return res;
    }

    public void get3Sum(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }
//                while (left < right && nums[right] == nums[right + 1]) {
//                    right--;
//                }
            }
        }
    }
}
