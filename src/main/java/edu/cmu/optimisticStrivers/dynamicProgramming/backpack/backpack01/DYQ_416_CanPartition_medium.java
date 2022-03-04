package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpack01;

import java.util.HashMap;

/**
 * @ClassName: DYQ_416_CanPartition_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/18 9:16 下午
 * @Version 1.0
 */
public class DYQ_416_CanPartition_medium {
    //0-1背包存在性问题
    //https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/

    //传统dfs，不要for循环，因为这种不太好return
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        return dfs(0, 0, nums, sum / 2);
    }
    private boolean dfs(int curSum, int index, int[] nums, int mid) {
        if (curSum == mid) {
            return true;
        }
        if (curSum > mid || index >= nums.length) {
            return false;
        }
//        for (int i = 0; i < nums.length; i++) {
//            return dfs(curSum+nums[i], i, nums, mid); //这样不对，会提前return
//        }
        return dfs(curSum + nums[index], index + 1, nums, mid) || dfs(curSum, index + 1, nums, mid); //index+1还没选呢
    }

    //全局变量也可以解决不太好return的问题
    static boolean res = false;

    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        dfs1(0, 0, nums, sum / 2);
        System.out.println(sum / 2);
        return res;
    }

    private static void dfs1(int curSum, int index, int[] nums, int mid) {
        System.out.println("curSum " + curSum + " index " + index);
        if (curSum == mid) {
            res = true;
            return;
        }
        if (curSum > mid || index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            dfs1(curSum + nums[i], i + 1, nums, mid); //i+1还没有选呢
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 5};
        System.out.println(canPartition1(test));

    }


//    memo
    public static boolean canPartition1_memo(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        HashMap<String, Boolean> map = new HashMap<>();
        dfs1_memo(0, 0, nums, sum / 2, map);
        return res;
    }

    private static void dfs1_memo(int curSum, int index, int[] nums, int mid, HashMap<String, Boolean> map) {
        String curKey = curSum + " " + index;
        if(map.containsKey(curKey)){
            return;
        }
        if (curSum == mid) {
            res = true;
//            map.put(curKey,true);
            return;
        }
        if (curSum > mid || index >= nums.length) {
            map.put(curKey,false);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            dfs1_memo(curSum + nums[i], i + 1, nums, mid, map); //i+1还没有选呢
        }
    }


    //2维dp
    public boolean canPartition_dp1(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];
                // if (nums[i] == j) { //这一一个状态转移其实可有可无，因为dp[i - 1][j - nums[i]]必为true
                //     dp[i][j] = true;
                //     continue;
                // }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    //dp优化 从二维到一维
    public boolean canPartition_dp2(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = target; j >= 0; j--) {
                // if (nums[i] == j) { //这一一个状态转移其实可有可无，因为dp[i - 1][j - nums[i]]必为true
                //     dp[i][j] = true;
                //     continue;
                // }
                if (nums[i] < j) {
                    dp[j] |=  dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
