package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_45_CanJump2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/4 5:54 下午
 * @Version 1.0
 */
public class DYQ_45_CanJump2_medium {

    public static int jump(int[] nums) {
        int start = 0;
        int end = 1; // 这个end 是开区间
        int count = 0;

        while (end < nums.length) {
            System.out.println(1);
            int curMax = 0;
            for (int i = start; i < end; i++) {
                curMax = Math.max(curMax, i + nums[i]);
            }
            start = end;
            end = curMax + 1;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] test = new int[]{2,0,0,1,3};
        jump(test);
    }
}
