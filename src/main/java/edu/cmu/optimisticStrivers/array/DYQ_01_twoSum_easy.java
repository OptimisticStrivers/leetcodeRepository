package edu.cmu.optimisticStrivers.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: DYQ_01_twoSum_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/26 6:34 PM
 * @Version 1.0
 */
public class DYQ_01_twoSum_easy {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> objectObjectHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (objectObjectHashMap.containsKey(target - nums[i])) {
                return new int[]{i, objectObjectHashMap.get(target - nums[i])};
            }
            objectObjectHashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    //排序就会丢掉 原来的 索引位置
    //所以不好做
    public int[] twoSum1(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i != j) {
            int temp = nums[i] + nums[j];
            if (temp == target) {
                return new int[]{i, j};
            } else if (temp < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
