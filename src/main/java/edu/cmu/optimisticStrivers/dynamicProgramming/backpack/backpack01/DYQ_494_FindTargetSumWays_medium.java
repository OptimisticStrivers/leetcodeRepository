package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpack01;

/**
 * @ClassName: DYQ_494_FindTargetSumWays_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/2 6:45 下午
 * @Version 1.0
 */
public class DYQ_494_FindTargetSumWays_medium {

    //0/1背包组合问题

    //普通dp
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target) ) {
            return 0;
        }
        int n = nums.length;
        int s = 2 * sum + 1;
        int[][] dp = new int[n + 1][s];
        dp[0][sum] = 1;
        for (int row = 0; row < nums.length; row++) { //第一行只有一个数字有所谓
            for (int column = 0; column < dp[row].length; column++) {
                if (dp[row][column] != 0) {
                    //从j向j+1推进
                    dp[row + 1][column - nums[row]] += dp[row][column]; //当前的数 nums[j] 加负号
                    dp[row + 1][column + nums[row]] += dp[row][column];
                }
            }
        }
        return dp[dp.length - 1][sum + target];
    }


    // 递归，枚举
    int count;
    public int findTargetSumWays1(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    private void calculate(int[] nums, int i, int sum, int s) {
        if (i == nums.length) {
            if (sum == s) {
                count++;
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], s);
            calculate(nums, i + 1, sum - nums[i], s);
        }
    }


    // 优化dp
    public int findTargetSumWays_best(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum+= num;
        }
        if((sum+target)%2 ==1 || (sum+target)/2 < 0) { //奇数或者小于0直接完蛋
            //注意等于0是可以的，说明一个正数也没有比如 [1000] -1000 这个用例
            return 0;
        }
        int target1 = (sum+target)/2;
        int[] dp = new int[target1+1];
        dp[0] = 1;
        // dp[nums[0]] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target1; j >= 0; j--) { //必须从右向左
                if(nums[i]<=j){
                    dp[j] = dp[j] + dp[j-nums[i]]; //不要他 + 要他
                }
            }
        }
        return dp[target1];
    }

}
