package edu.cmu.optimisticStrivers.dynamicProgramming;

import java.util.List;

public class DYQ_120_Triangle_medium {


    public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len + 1]; //这里的意思就是多一层 在最后一层下面 作为空层
        //dp[i]代表当前层的i index位置 到底最小路径
        //自底向上
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


}
