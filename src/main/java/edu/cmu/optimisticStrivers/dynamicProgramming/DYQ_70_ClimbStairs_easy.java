package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_70_ClimbStairs_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/7 6:29 下午
 * @Version 1.0
 */
public class DYQ_70_ClimbStairs_easy {

    //爬楼梯
    //又叫青蛙跳台阶


    //传统dp
    public int climbStairs(int n) {
        if(n == 1){return 1;}
        if(n == 2){return 2;}
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }


    //把dp数组去掉
    public int climbStairs1(int n) {
        if(n == 1){return 1;}
        if(n == 2){return 2;}
        int a = 1, b = 2, temp;
        for(int i = 3; i <= n; i++){
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

}
