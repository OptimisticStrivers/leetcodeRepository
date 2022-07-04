package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpack01;

public class DYQ_normal_01_backpack {


    public static int backpack(int m, int[] A) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            for (int j = m; j >= 1; j--) {
                if (cur <= j) {
                    if (dp[j] < dp[j - cur] + cur) {
                        dp[j] = dp[j-cur] + cur;
                    }
                }
            }
        }
        return dp[m];
    }

    //存布尔值
    public static int backpack1(int m, int[] A) {
        int len = A.length;
        boolean[][] dp = new boolean[len+1][m+1];
        for (int i = 0; i <= m ; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= len; i++) {
            int cur = A[i-1];
            for (int j = 0; j <= m; j++) {
                if (cur <= j) {
                    dp[i][j] = dp[i-1][j-cur] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int i = m; i >= 0 ; i--) {
            if(dp[len][i]){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] A = new int[]{2,3,4,8,5};
        System.out.println(backpack1(9,A));
    }

}
