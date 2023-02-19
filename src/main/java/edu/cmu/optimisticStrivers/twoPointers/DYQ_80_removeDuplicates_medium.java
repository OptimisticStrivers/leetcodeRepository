package edu.cmu.optimisticStrivers.twoPointers;

/**
 * @ClassName: DYQ_80_removeDuplicates_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/16 5:59 PM
 * @Version 1.0
 */
public class DYQ_80_removeDuplicates_medium {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }

        int moveTarget = 2;
        for(int i = 2; i<nums.length; i++){
            if(nums[i] != nums[moveTarget-2]){ //moveTarget之前的才是真正确定下来的数字们
                nums[moveTarget++] = nums[i];
            }
        }
        return moveTarget;
    }
}
