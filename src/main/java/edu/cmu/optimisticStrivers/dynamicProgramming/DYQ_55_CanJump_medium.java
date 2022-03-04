package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_55_CanJump_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/4 5:47 下午
 * @Version 1.0
 */
public class DYQ_55_CanJump_medium {

    public boolean canJump(int[] nums) {
        int k = 0; // 从index=0 最大可以跳几步 （步数之合）
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false; // 根本到不了
            k = Math.max(k, i + nums[i]);
        }
        return true;


    }
}
