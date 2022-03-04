package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpackDifferent;

/**
 * @ClassName: DYQ_1155_numRollsToTarget_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/20 4:43 下午
 * @Version 1.0
 */
public class DYQ_1155_numRollsToTarget_medium {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int) 1e9 + 7;  // 题目要求：答案可能很大，你需要对 109 + 7 取模 。
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k && l <= j; l++) {  //当前骰子（背包），有potential k种值，但是也要小于j才行，所以只有l个面值
                    dp[i][j] = (dp[i - 1][j - l] + dp[i][j]) % mod;
                }
            }
        }
        return dp[n][target];
    }

    public int numRollsToTarget_bset(int n, int k, int target) {
        int mod = (int) 1e9 + 7;  // 题目要求：答案可能很大，你需要对 109 + 7 取模 。
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = target; j >= 1; j--) { //这里j必须取到0，因为除了虚无那一行的第一个是1，其他都是0，必须给一个置0的操作，否则优化一维，第一个树将一直是1，这是不对的。
                dp[j] = 0; //必须置0，因为现在是新的背包
                for(int l = 1; l<= k && l<=j ; l++){ //这个骰子必须是正序，因为需要累积结果
                    dp[j] = (dp[j] + dp[j - l]) % mod;
                }
//                for (int l = k; l >= 1 && l<=j ; l--) { //倒叙不对
//                    dp[j] = (dp[j] + dp[j - l]) % mod;
//                }
            }
        }
        return dp[target];
    }



    public static void main(String[] args) {
        int[] a = new int[]{1,6,3};
//        System.out.println(numRollsToTarget1(1,6,3));
    }


}
