package edu.cmu.optimisticStrivers.array;

/**
 * @ClassName: DYQ_581_findUnsortedSubarray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 3:25 下午
 * @Version 1.0
 */
public class DYQ_581_findUnsortedSubarray_medium {

//    很简单，如果最右端的一部分已经排好序，这部分的每个数都比它左边的最大值要大，
//    同理，如果最左端的一部分排好序，这每个数都比它右边的最小值小。所以我们从左往右遍历，
//    如果i位置上的数比它左边部分最大值小，则这个数肯定要排序， 就这样找到右端不用排序的部分，
//    同理找到左端不用排序的部分，它们之间就是需要排序的部分

    public int findUnsortedSubarray_final(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int R = 0;
        int L = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max > arr[i]) {
                R = i;
            }
            max = Math.max(max, arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if(min < arr[i]) {
                L = i;
            }
            min = Math.min(min, arr[i]);
        }
        return R == L ? 0 : R - L + 1;
    }

    public static int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int rightBound = -1;
        int maxV = nums[0];
        for (int j = 1; j < nums.length ; j++) {
            if(nums[j]<maxV){
                rightBound = j;
            }else{
                maxV =  nums[j];
            }
        }
        if(rightBound==-1) return 0;
        int leftBound = -1;
        int minV = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0 ; i--) {
            if(nums[i]>minV){
                leftBound = i;
            }else{
                minV = nums[i];

            }
        }
        return rightBound-leftBound+1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,2,2,2};
        findUnsortedSubarray(a);
    }
}
