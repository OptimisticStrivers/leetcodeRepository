package edu.cmu.optimisticStrivers.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: DYQ_niuke_binaryTree
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/20 10:25 上午
 * @Version 1.0
 */
public class DYQ_niuke_binaryTree {

//    https://www.nowcoder.com/questionTerminal/aaefe5896cce4204b276e213e725f3ea


    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[][] dp = new long[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = (dp[i][j] + dp[k][j - 1] * dp[i - k - 1][j - 1]) % mod;
                }
            }
        }

        System.out.println(dp[n][m]);


    }

}



