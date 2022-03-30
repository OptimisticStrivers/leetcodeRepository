package edu.cmu.optimisticStrivers.dynamicProgramming.geometry;

/**
 * @ClassName: DYQ_221_maximalSquare_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/2 6:00 下午
 * @Version 1.0
 */
public class DYQ_221_maximalSquare_medium {

    public static int maximalSquare(char[][] matrix) {


        int maxLength = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    dp[0][j] = matrix[0][j] - '0';
                } else if (j == 0) {
                    dp[i][0] = matrix[i][0] - '0';
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }

        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println();
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(" " + dp[i][j]);
//            }
//        }
        return maxLength * maxLength;

    }

    public static void main(String[] args) {
        char[][] test = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(test));
    }


}
