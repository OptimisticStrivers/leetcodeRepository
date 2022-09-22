package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_jianzhi2_006_twoSum_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/8 5:27 PM
 * @Version 1.0
 */
public class DYQ_jianzhi2_006_twoSum_easy {
//    剑指 Offer II 006. 排序数组中两个数字之和


    public int[] twoSum(int[] numbers, int target) {
        int[] ints = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                ints = new int[]{left,right};
                return ints;
            }
        }
        return ints;
    }
}
