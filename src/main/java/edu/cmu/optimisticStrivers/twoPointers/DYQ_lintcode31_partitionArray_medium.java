package edu.cmu.optimisticStrivers.twoPointers;

public class DYQ_lintcode31_partitionArray_medium {

//    https://www.lintcode.com/problem/31/
    //对比 75 sort color
    //对比 快排


    //这道题  要求就是 小于k的都在 左边
    //大于等于k的都在右边

    //返回partition position
    public int partitionArray(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (nums[r] >= k && l < r) {
                r--;
            }
            while (nums[l] < k && l < r) {
                l++;
            }
            int swap = nums[r];
            nums[r] = nums[l];
            nums[l] = swap;
        }
        return nums[l]<k? l+1 : l;
    }


    public static void main(String[] args) {
        DYQ_lintcode31_partitionArray_medium dyq_lintcode31_partitionArray_medium = new DYQ_lintcode31_partitionArray_medium();

        System.out.println(dyq_lintcode31_partitionArray_medium.partitionArray(new int[]{3, 2, 2, 1}, 2));
    }
}
