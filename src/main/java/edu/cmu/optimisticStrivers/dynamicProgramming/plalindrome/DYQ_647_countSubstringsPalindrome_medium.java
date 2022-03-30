package edu.cmu.optimisticStrivers.dynamicProgramming.plalindrome;

/**
 * @ClassName: DYQ_647_countSubstringsPalindrome_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/2 6:27 下午
 * @Version 1.0
 */
public class DYQ_647_countSubstringsPalindrome_medium {


//    https://leetcode-cn.com/problems/palindromic-substrings/solution/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
    //dp
    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {//右侧
            for (int j = 0; j <= i; j++) { //左侧
                if(s.charAt(i)==s.charAt(j)){
                    if(i-j<2 || dp[j+1][i-1]){ //一个数或者一共两个数就是 i-j<2
                        dp[j][i] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }


    //空间是o1 空间还是on2
    //中心点放啊
    //关键就是找中心点
    //一共有 2*len-1 个中心点
    public int countSubstrings1(String s) {
        int res = 0;
        int numOfCenter = 2*s.length()-1;
        for (int center = 0; center < numOfCenter ; center++) {
            int left = center/2;
            int right = left + center%2;
            while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;
    }

}
