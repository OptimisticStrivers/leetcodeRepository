package edu.cmu.optimisticStrivers.search;

/**
 * @ClassName: DYQ_33_searchRotatingSortedArray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/27 7:44 PM
 * @Version 1.0
 */
public class DYQ_33_searchRotatingSortedArray_medium {

//    java 击败100% 二分搜索法
//    思路：如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，
//    我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了

    //关键就是 确定 这个 target 在哪一个半边
    //如何肯定的知道 target 在一个半边呢
    //就要找到有序的那一半 在就在 不在就在另一半
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[right]) { //说明右半边是有序的，我们可以先看target在不在右半边
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else { //如果不在有序的那一半 那就一定在无序的那一半
                    right = mid -1;
                }
            } else {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1; //没有找到
    }

}
