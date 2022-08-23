package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_189_rotateArray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/4 5:09 PM
 * @Version 1.0
 */
public class DYQ_189_rotateArray_medium {


    //    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
    //暴力方法
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        int[] temp = new int[length];

        k = k % nums.length;
        int j = 0;
        for (int i = length - k; i < length; i++) {
            temp[j++] = nums[i];
        }
        int o = k;
        for (int i = 0; i < length - k; i++) {
            temp[o++] = nums[i];
        }
//        nums = temp;  这样检查过不了的，人家是in-place 查的是原地址
        //这样写只是 变量 变了而已

        for (int i = 0; i < length; i++) {
            nums[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        DYQ_189_rotateArray_medium dyq_189_rotateArray_medium = new DYQ_189_rotateArray_medium();
        dyq_189_rotateArray_medium.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }


//    o(1) 空间 思路如下：
//    首先对整个数组实行翻转，这样子原数组中需要翻转的子数组，就会跑到数组最前面。
//    这时候 k处分隔数组，左右两数组，各自进行翻转即可


    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


}