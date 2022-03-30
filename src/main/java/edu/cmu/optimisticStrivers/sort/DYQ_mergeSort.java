package edu.cmu.optimisticStrivers.sort;

/**
 * @ClassName: DYQ_mergeSort
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/19 10:24 上午
 * @Version 1.0
 */
public class DYQ_mergeSort {
//    https://www.cnblogs.com/chengxiao/p/6194356.html


//
//    public static int[] sortArray(int[] nums) {
//        int[] temp = new int[nums.length];
//        mergeSort(nums, 0, nums.length - 1, temp);
//        return nums;
//    }
//
//    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
//        if (left < right) { //只有一个数就无所谓了
//            int mid = (left + right) / 2;
//            mergeSort(nums, left, mid, temp);
//            mergeSort(nums, mid + 1, right, temp);
//            merge(nums, left, mid, right, temp);
//        }
//    }
//
//
//    public static void merge(int[] nums, int begin, int mid, int end, int[] temp) {
//        int i = begin;
//        int j = mid + 1;
//        int t = 0;
//        while (i <= mid && j <= end) {
//            if (nums[i] <= nums[j]) { // 升序
//                temp[t++] = nums[i++];
//            } else {
//                temp[t++] = nums[j++];
//            }
//        }
//
//        while (j <= end) {
//            temp[t++] = nums[j++];
//        }
//        while (i <= mid) {
//            temp[t++] = nums[i++];
//        }
//
//        t = 0;
//        while(begin<=end){
//            nums[begin++] = temp[t++];
//        }
//
//    }

    public static int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int[] swapArray = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, swapArray);
        return nums;
    }

    public static void mergeSort(int[] nums, int begin, int end , int[] swapArray){
        while(begin<end){
            int mid = (begin+end)/2;
            mergeSort(nums, begin, mid, swapArray);
            mergeSort(nums, mid+1, end, swapArray);
            merge(nums, begin, mid+1, end, swapArray);
        }
    }


    public static void merge(int[] nums, int begin, int mid, int end, int[] swapArray){
        int i = begin;
        int j = mid;
        int s = begin;
        while(i<mid && j<=end){
            if(nums[i]<=nums[j]){
                swapArray[s++] = nums[i++];
            }else{
                swapArray[s++] = nums[j++];
            }
        }
        while(i<mid){
            swapArray[s++] = nums[i++];
        }
        while(j<=end){
            swapArray[s++] = nums[j++];
        }
        // for(int k = 0; k < end-begin+1; k++){
        //     nums[k+begin] = swapArray[k];
        // }
        // s = 0;
        // while(begin<=end){
        //     nums[begin++] = swapArray[s++];
        // }

        while(begin<=end){
            nums[begin++] = swapArray[begin];
        }

    }

    public static void main(String[] args) {
        int[] a = sortArray(new int[]{5,2,3,1});
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
