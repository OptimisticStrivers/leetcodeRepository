package edu.cmu.optimisticStrivers.twoPointers;

/**
 * @ClassName: DYQ_287_FindDuplicate_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/12 4:24 下午
 * @Version 1.0
 */
public class DYQ_287_FindDuplicate_medium {
    //寻找重复数

    //使用的还是142的方法，快慢双指针找环的入口

    //这道题
    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0; //[1,2,1]
        do { //一定有环 [2,1,3,1,4]
            fast = nums[nums[fast]];
            slow = nums[slow];
            System.out.println(fast+""+slow);
        } while (fast != slow);

        System.out.println(slow);
        int newPointer = 0;
        while(newPointer!=slow){
            slow = nums[slow];
            newPointer = nums[newPointer];
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
}
