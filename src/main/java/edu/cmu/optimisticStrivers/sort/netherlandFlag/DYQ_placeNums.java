package edu.cmu.optimisticStrivers.sort.netherlandFlag;

import java.util.Arrays;

/**
 * @ClassName: DYQ_placeNums
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/7 7:44 PM
 * @Version 1.0
 */
public class DYQ_placeNums {

//    给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。要求额外空间复杂度O(1),时间复杂度 O(N)
//    one pass

    public static void sortColors(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i <= r; i++) {  //i<=r 很重要 否则 2就会换到前面去了
            if (nums[i] < target) {
                swap(nums, i, l);
                l++;
            } else if (nums[i] > target) {
                swap(nums, i, r);
                r--;
                i--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] ints = {1, 3, 2, 4, 5, 6, 5, 32, 1};
        sortColors(ints,5);
        System.out.println(Arrays.toString(ints));
    }


}


