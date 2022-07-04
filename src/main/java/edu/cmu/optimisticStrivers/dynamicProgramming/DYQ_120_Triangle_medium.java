package edu.cmu.optimisticStrivers.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DYQ_120_Triangle_medium {


    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        ArrayList arr0 = new ArrayList();
        arr0.add(2);
        ArrayList arr1 = new ArrayList();
        arr1.add(3);
        arr1.add(4);
        ArrayList arr2 = new ArrayList();
        arr2.add(6);
        arr2.add(5);
        arr2.add(7);
//        ArrayList arr3 = new ArrayList();
//        arr3.add(4);
//        arr3.add(1);
//        arr3.add(8);
//        arr3.add(3);

        arr.add(arr0);
        arr.add(arr1);
        arr.add(arr2);
//        arr.add(arr3);

        minimumTotal(arr);
    }
//    public static int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0) return 0;
//        if (triangle.size() == 1) {
//            return triangle.get(0).get(0);
//        }
//        int layers = triangle.size();
//        int[] dp = new int[layers];
//        dp[0] = triangle.get(0).get(0);
//        int[] dp1 = new int[layers];
//
//        for (int i = 1; i < layers; i++) {
//            System.out.println(i);
//            for (int j = 0; j <= i; j++) {
//                if (j == 0) {
//                    dp1[j] = dp[j] + triangle.get(i).get(j);
//                } else if (j == i) {
//                    dp1[j] = dp[j - 1] + triangle.get(i).get(j);
//                } else {
////                    System.out.println("前 "+ dp[j - 1]);
////                    System.out.println("后 "+ dp[j]);
////                    System.out.println( Math.min(dp[j - 1], dp[j])  );
//                    dp1[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
//                }
//            }
////            dp = dp[1] //这样改的话，一个地址，一边动，两边都动
//            for (int j = 0; j < layers; j++) {
//                dp[j] = dp1[j];
//            }
//        }
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < layers; i++) {
//            System.out.print(dp[i] + " ");
//            result = Math.min(dp1[i], result);
//        }
//        return result;
//    }



    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(dp[n-1][i] + " ");
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (dp[n-1][j] < ans) {
                ans = dp[n-1][j];
            }
        }
        return ans;
    }


}
