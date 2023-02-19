package edu.cmu.optimisticStrivers.array;

/**
 * @ClassName: DYQ_283_moveZeros_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 5:40 PM
 * @Version 1.0
 */
public class DYQ_283_moveZeros_easy {

//    你能尽量减少完成的操作次数吗？

    //思路：设置一个index，表示非0数的个数，循环遍历数组，
    // 如果不是0，将非0值移动到第index位置,然后index + 1
    //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
    public void moveZeroes_final(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }



    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        while(true){
            while(zeroIndex<nums.length && nums[zeroIndex]!=0){ //先找到0
                zeroIndex++;
            }
            nonZeroIndex = zeroIndex + 1;
            while(nonZeroIndex<nums.length && nums[nonZeroIndex] == 0 ){
                nonZeroIndex++;
            }
            if(zeroIndex < nums.length && nonZeroIndex < nums.length){
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[zeroIndex];
                nums[zeroIndex] = temp;
            }
            if(zeroIndex == nums.length || nonZeroIndex == nums.length){
                return;
            }
        }

    }
}
