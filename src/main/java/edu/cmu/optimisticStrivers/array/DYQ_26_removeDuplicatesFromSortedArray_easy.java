package edu.cmu.optimisticStrivers.array;

/**
 * @ClassName: DYQ_26_removeDuplicatesFromSortedArray_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 5:56 PM
 * @Version 1.0
 */
public class DYQ_26_removeDuplicatesFromSortedArray_easy {

    public int removeDuplicates(int[] nums) {
        int properIndex = 0;
        int i = 0;
        while (true) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            nums[properIndex++] = nums[i++];
            if (i == nums.length) {
                break;
            }
        }
        return properIndex;
    }
}
