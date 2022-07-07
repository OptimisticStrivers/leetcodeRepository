package edu.cmu.optimisticStrivers.dynamicProgramming;

public class DYQ_343_integerBreak_medium {


//    Input: n = 10
//    Output: 36
//    Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.


    //正方形面积最大  所以要让分开的数尽可能接近


    //贪心
    public int integerBreak(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        int a = 1;
        while(n > 4){ //先尽量多的分3 但是如果能剩下4的话 肯定比剩一个1和3好
            n = n - 3;
            a = a * 3;
        }
        return a * n;
    }

    public int integerBreak1(int n) {
        // 因数如果>=4则可以分解出1，2，3代替
        // 因数1无用
        // 2最多用两次，因为：2*2*2 < 3*3
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        // n%3 取余3 会有 0 1 2 三种情况 对应下面3个return
        // 余0 全分3
        // 余1 那么就分出一个3 和1 组成4
        // 余2 那么就最后来个2
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }


    //暴力搜索 1
    //记忆化搜索 备忘录 memo 2


    //动态规划 3

    //两个注意点
    // 1 为什么 curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));   j不用拆
    // 2 j的前后是对称的 所以不需要从1走到i  那么就只走一般就行
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];  // 用来记录每个数能分解出的最好结果
        dp[0] = 0;  // base case：0无法分解
        dp[1] = 0;  // base case：1无法分解
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            // 一个数最少能分解出两个数，
            //
            //
            // 其中一个数当作不可拆分数j， **************  理解这一个 非常重要
            //
            // 余下的数可以进行若干次拆分
            // 状态转换方程：dp[i] = Max(dp[i], Max(j * (i-j), j * dp[i - j])) (1<=j<=i)
            for (int j = 1; j < i / 2 + 1; j++) {  // 范围可以进一步优化，因为拆分两个数是对称的，所以只用遍历一半  i/2 + 1
//                for (int j = 1; j <= i/2 + 1 ; j++) {   这里其实边界没事，只要j遍历了比一半多就行
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }


//    https://leetcode.cn/problems/integer-break/solution/dai-ma-sui-xiang-lu-dong-tai-gui-hua-wu-r1ao3/
//    这个帖子 写 动态规划 非常棒 非常清楚
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;  // base case：0无法分解
        dp[1] = 0;  // base case：1无法分解
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {  // 范围可以进一步优化，因为拆分两个数是对称的，所以只用遍历一半
                // 这里 j<i-1 是因为 楼主 因为是定义了dp[1]没有意义  我们也可以 j<i 因为我们之前有dp[1]的值
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }




}
