package edu.cmu.optimisticStrivers.array;

/**
 * @ClassName: DYQ_581_findUnsortedSubarray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 3:25 下午
 * @Version 1.0
 */
public class DYQ_581_findUnsortedSubarray_medium {

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
