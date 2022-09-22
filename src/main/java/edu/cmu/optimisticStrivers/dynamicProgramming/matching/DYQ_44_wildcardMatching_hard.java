package edu.cmu.optimisticStrivers.dynamicProgramming.matching;

/**
 * @ClassName: DYQ_44_wildcardMatching_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/31 6:38 PM
 * @Version 1.0
 */
public class DYQ_44_wildcardMatching_hard {

    public boolean isMatch(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        // 技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始，而且可以使得 f[0][0] = true，可以将 true 这个结果滚动下去
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        // f(i,j) 代表考虑 s 中的 1~i 字符和 p 中的 1~j 字符 是否匹配
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p[j] == '*') {
                    f[i][j] = f[i][j - 1] || (i - 1 >= 0 && f[i - 1][j]);
                } else {
                    f[i][j] = i - 1 >= 0 && f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '?');
                }
            }
        }
        return f[n][m];
    }


    //self edition
    //https://leetcode.cn/problems/wildcard-matching/solution/gong-shui-san-xie-xiang-jie-dong-tai-gui-ifyx/
    //dp表格 更加  https://leetcode.cn/problems/wildcard-matching/solution/yi-ge-qi-pan-kan-dong-dong-tai-gui-hua-dpsi-lu-by-/
    public boolean isMatch1(String ss, String pp) {
        String s1 = " " + ss;
        String p1 = " " + pp; //这个只是能让index从1开始
        boolean[][] dp = new boolean[s1.length()][p1.length()];
        dp[0][0] = true; //为了让右斜下角 延续
        for (int i = 0; i < s1.length(); i++) { //先遍历的是 ss
            for (int j = 1; j < p1.length(); j++) {
                char cur = p1.charAt(j);
                if (cur == '*') {
                    dp[i][j] = dp[i][j - 1] || (i - 1 >= 0 && dp[i - 1][j]); //dp[i][j-1]是 * 什么都不匹配
                    // dp[i-1][j]是一种避免迭代前序所有情况的写法
                } else { //'?'和'zifu' 两种情况可以合并
                    dp[i][j] = (i - 1 >= 0 && dp[i - 1][j - 1]) && (s1.charAt(i) == cur || cur == '?');
                }
            }
        }
        return dp[s1.length() - 1][p1.length() - 1];
    }


}
