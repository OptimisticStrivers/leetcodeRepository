package edu.cmu.optimisticStrivers.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DYQ_34_FindFirstandLastPositionofElementinSortedArray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/23 7:09 下午
 * @Version 1.0
 */
public class DYQ_34_FindFirstandLastPositionofElementinSortedArray_medium {

    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        range[0] = searchRes(nums, target, true);
        range[1] = searchRes(nums, target, false);
        return range;
    }
//     3 4 4

    public int searchRes(int[] nums, int target, boolean isleft) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                res = mid;
                //这种找边界和严格二分查找的区别就是，找到也不要停下来，要往两边扩，直到扩不下去
                if (isleft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        Integer[] a = {1, 3};
        list.add(Arrays.asList(a));

    }

    //一种投机的方法
    public int[] searchRange1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index != -1) {
            left = index;
            right = index;
            while (left - 1 >= 0 && nums[left] == nums[left - 1]) {
                left--;
            }
            while (right + 1 < nums.length && nums[right] == nums[right + 1]) {
                right++;
            }
            return new int[]{left, right};

        } else {
            return new int[]{-1, -1};
        }
    }
}
