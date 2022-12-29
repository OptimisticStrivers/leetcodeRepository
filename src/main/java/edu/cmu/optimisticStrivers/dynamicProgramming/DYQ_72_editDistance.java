package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_72_editDistance
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/29 12:31 PM
 * @Version 1.0
 */
public class DYQ_72_editDistance {

//    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
//    You have the following three operations permitted on a word:
//
//    Insert a character
//    Delete a character
//    Replace a character


//    https://blog.csdn.net/hexu2010/article/details/109919439


    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
//    public static double editDistance(char[] s1, char[] s2) {
//// WRITE YOUR CODE HERE
//        int len1 = s1.length();
//        int len2 = s2.length();
//        double[][] dp = new double[len1 + 1][len2 + 1];
//        for (int i = 1; i <= len1; i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 1; j <= len2; j++) {
//            dp[0][j] = j;
//        }
//
//        for (int i = 1; i <= len1; i++) {
//            for (int j = 1; j <= len2; j++) {
//                if (s1[i - 1] == s2[j - 1)] {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
//                }
//            }
//        }
//        return dp[len1][len2];
//    }

}
