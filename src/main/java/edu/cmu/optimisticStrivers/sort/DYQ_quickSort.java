package edu.cmu.optimisticStrivers.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: DYQ_quickSort
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/19 10:24 上午
 * @Version 1.0
 */
public class DYQ_quickSort {



    public static void main(String[] args) {
//        int[] a = new int[]{1, 5, 1, 1, 2, 0, 0};
//        int[] a = new int[]{0,1,0};
        int[] a = new int[]{0,1,0,1};

        quickSort1(a, 0, a.length - 1);
//        quickSort1(a,0,a.length-1);
//        quickSort3(a,0,5);
        System.out.println(Arrays.toString(a));


    }

    public static void quickSort1(int[] nums, int begin, int end) {
        System.out.println("enter begin " + begin + " end " + end );
        if (begin >= end) { //递归终止条件，> 号很重要 因为在下一次递归调用的入口
            // [0,1] 这种 begin会一直增大 知道 nums[begin]越界
            return;
        }
        int pivot = nums[begin]; //存下来基准
        int l = begin;
        //必须是begin 不能begin+1, 就比如[0,1]这个例子 直接就会l和r重合，然后交换l和pivot就会得到 [1,0]
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
        quickSort1(nums, l + 1, end); //这个对应了 21 行 必须有> 号，比如如果两个元素 1，2进quicksort
        //这时候 l就是1了    1+1 =2 > end ==1
//        System.out.println("wocao");
//        System.out.println("k " + (l-1));
        quickSort1(nums, begin, l - 1);
    }

//    public static void quickSort(int[] nums, int begin, int end) {
////        for (int i = 0; i < nums.length; i++) {
////            System.out.print(nums[i]+" ");
////        }
////        System.out.println();
////        System.out.println("begin " + begin + " end " +end );
//
//        if (begin >= end) { //递归终止条件，非常重要
//            return;
//        }
//        int pivot = nums[begin]; //存下来基准
//        int l = begin + 1;
//        int r = end;
//        while (l < r) {
//            //升序排列
//            while (l < r && nums[r] >= pivot) {
//                r--; //找到第一个比pivot小的数
//            }
//            while (l < r && nums[l] <= pivot) {
//                l++;
//            }
//            //换一下这两个数字
//            int temp = nums[r];
//            nums[r] = nums[l];
//            nums[l] = temp;
//        }
//        //把基准换掉
////        int index = begin;
////
////        if (nums[l] <= pivot) {
////            index = l;
////            nums[begin] = nums[l];
////            nums[l] = pivot;
////        }
//
//        //把基准换掉
//        nums[begin] = nums[l];
//        nums[l] = pivot;
//
//        quickSort(nums, begin, l - 1);
//        quickSort(nums, l + 1, end);
//    }
}
