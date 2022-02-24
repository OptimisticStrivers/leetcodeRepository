package Array;

/**
 * @ClassName: Lc26RemoveDuplicatesfromSortedArray
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/18/22 10:22 am
 * @Version 1.0
 */
public class Lc26RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int A = 0;
        for(int B = 0; B < nums.length; B++){
            if(A == 0 || nums[A-1] != nums[B]){
                A++;
                nums[A-1] = nums[B];
            }
        }
        return A;
    }

}

