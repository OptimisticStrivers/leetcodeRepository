package edu.cmu.optimisticStrivers.bootcamp.HW3;

/**
 * @ClassName: MergeSort
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/17 7:24 PM
 * @Version 1.0
 */
public class MergeSort {
    public static int[] merge_sort(int[] values) {
        mergeSort(values,0,values.length-1, new int[values.length]);
        return values;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 1, 6, 5, 3, 2};
        int[] ints1 = merge_sort(ints);
        for (int i = 0; i < ints1.length; i++) {
            System.out.print(ints1[i]);
        }
    }

    public static void mergeSort(int[] nums, int begin, int end, int[] swapArray) {
//        while(begin<end){
//            int mid = (begin+end)/2;
//            mergeSort(nums, begin, mid, swapArray);
//            mergeSort(nums, mid+1, end, swapArray);
//            merge(nums, begin, mid+1, end, swapArray);
//        }
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(nums, begin, mid, swapArray);
        mergeSort(nums, mid + 1, end, swapArray);
        System.out.println("begin " + begin + " mid " + (mid + 1) + " end " + end);
        merge(nums, begin, mid + 1, end, swapArray);
    }
    public static void merge(int[] nums, int begin, int mid, int end, int[] swapArray) {
        int i = begin;
        int j = mid;
        int s = begin;
        while (i < mid && j <= end) {
            if (nums[i] >= nums[j]) {
                swapArray[s++] = nums[i++];
            } else {
                swapArray[s++] = nums[j++];
            }
        }
        while (i < mid) {
            swapArray[s++] = nums[i++];
        }
        while (j <= end) {
            swapArray[s++] = nums[j++];
        }
        // for(int k = 0; k < end-begin+1; k++){
        //     nums[k+begin] = swapArray[k];
        // }
        // s = 0;
        // while(begin<=end){
        //     nums[begin++] = swapArray[s++];
        // }

        while (begin <= end) {
//            nums[begin++] = swapArray[begin];
            nums[begin] = swapArray[begin]; //不会有问题
            begin++;
        }

    }


//    // for Code Visualizer
//    public static void main(String[] args) {
//        int[] values = { 2, 1, 3, 5, 4 };
//        int[] result = merge_sort(values);
//        if (result != null) {
//            for (int i = 0; i < result.length; i++) {
//                System.out.println(result[i]);
//            }
//        }
//    }
}
