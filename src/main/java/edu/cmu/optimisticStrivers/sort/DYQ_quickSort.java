package edu.cmu.optimisticStrivers.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: DYQ_quickSort
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/19 10:24 上午
 * @Version 1.0
 */
public class DYQ_quickSort {

    public static void main(String[] args) {
        quickSort(new  int[]{5,1,1,2,0,0},0,5);

    }

        public void quickSort1(int[] nums, int begin, int end) {
        if (begin >= end) { //递归终止条件，非常重要
            return;
        }
        int pivot = nums[begin]; //存下来基准
        int l = begin; //必须是begin 不能begin+1
        int r = end;
        while (l < r) {
            //升序排列
            while (l < r && nums[r] >= pivot) {
                r--; //找到第一个比pivot小的数
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            //换一下这两个数字
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
        }
        //把基准换掉
        nums[begin] = nums[l];
        nums[l] = pivot;
        quickSort(nums, l + 1, end);
        quickSort(nums, begin, l - 1);
    }

    public static void quickSort(int[] nums, int begin, int end) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        System.out.println("begin " + begin + " end " +end );

        if (begin >= end) { //递归终止条件，非常重要
            return;
        }
        int pivot = nums[begin]; //存下来基准
        int l = begin + 1;
        int r = end;
        while (l < r) {
            //升序排列
            while (l < r && nums[r] >= pivot) {
                r--; //找到第一个比pivot小的数
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            //换一下这两个数字
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
        }
        //把基准换掉
        int index = begin;

        if (nums[l] <= pivot) {
            index = l;
            nums[begin] = nums[l];
            nums[l] = pivot;
        }

        quickSort(nums, begin,  index-1);
        quickSort(nums, index+1, end);
    }
}
