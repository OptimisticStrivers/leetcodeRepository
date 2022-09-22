package edu.cmu.optimisticStrivers.dynamicProgramming.matching;

/**
 * @ClassName: DYQ_10_RegularExpressingMatching_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/6 12:29 PM
 * @Version 1.0
 */
public class DYQ_10_RegularExpressingMatching_hard {


//    Input: s = "ab", p = ".*"
//    Output: true
//    Explanation: ".*" means "zero or more (*) of any character (.)". 注意这个*的意思就是 能匹配0个或者更多的preceding element

//    输入：s = "aab" p = "c*a*b"
//    输出：true
//    解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"

//    保证每次出现字符 * 时，前面都匹配到有效的字符  这个是题目保证的


    //    https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247484130&idx=1&sn=af3517194634dde1652ec72eb5ea9ff2&chksm=fd9ca9fdcaeb20eb1fd7509e3adf8fee6f75d77b8afbd30067ac11a56bd77b5066b0f164eb49&token=840813710&lang=zh_CN#rd
    public boolean isMatch(String s, String p) {
        String s1 = " " + s;
        String p1 = " " + p;
        boolean[][] dp = new boolean[s1.length() + 1][p1.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 1; j < p1.length(); j++) {

                // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
                if (j + 1 < p1.length() && p1.charAt(j + 1) == '*') continue;

                // 对应了 p[j] 为普通字符和 '.' 的两种情况
                // 普通字符的话 必须匹配  .的话 随便
                if (i - 1 >= 0 && p1.charAt(j) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s1.charAt(i) == p1.charAt(j) || p1.charAt(j) == '.');
                } else if (p1.charAt(j) == '*') { //递推公式要掌握
                    //因为* 要配合 p前面的字符一块用
                    //dp[i][j-2] 匹配 0 个   其实就是j是当前*字符  j-1是前一个字符  匹配0个相当于都不要
                    dp[i][j] = (j - 2 >= 0 && dp[i][j - 2]) || (i - 1 >= 0 && dp[i - 1][j] && (s1.charAt(i) == p1.charAt(j - 1) || p1.charAt(j-1) == '.'));
                }
            }
        }
        return dp[s1.length()][p1.length()];
    }


    public boolean isMatch1(String ss, String pp) {
        // 技巧：往原字符头部插入空格，这样得到 char 数组是从 1 开始，而且可以使得 f[0][0] = true，可以将 true 这个结果滚动下去
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        // f(i,j) 代表考虑 s 中的 1~i 字符和 p 中的 1~j 字符 是否匹配
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
                if (j + 1 <= m && p[j + 1] == '*') continue;

                // 对应了 p[j] 为普通字符和 '.' 的两种情况
                if (i - 1 >= 0 && p[j] != '*') {
                    f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
                }

                // 对应了 p[j] 为 '*' 的情况
                else if (p[j] == '*') {
                    f[i][j] = (j - 2 >= 0 && f[i][j - 2]) || (i - 1 >= 0 && f[i - 1][j] && (s[i] == p[j - 1] || p[j - 1] == '.'));
                }
            }
        }
        return f[n][m];
    }

//    static boolean isReverse(String str1, String str2) {
//        StringBuilder str1ReverseBuilder = new StringBuilder();
//         for (int i = str1.length() - 1; i >= 0; i--) {
//             System.out.println(str1.charAt(i));
////        for(int i = 0; i<str1.length(); i++)
//             str1ReverseBuilder.append(str1.charAt(i));
//         }
//        System.out.println(str1ReverseBuilder.toString());
//        String str1Reverse = str1ReverseBuilder.toString();
//        return str1Reverse == str2;
//    }
}
