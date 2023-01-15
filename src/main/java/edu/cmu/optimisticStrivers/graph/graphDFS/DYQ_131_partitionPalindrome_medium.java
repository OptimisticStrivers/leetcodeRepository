package edu.cmu.optimisticStrivers.graph.graphDFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: DYQ_131_partitionPalindrome_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/9 11:49 AM
 * @Version 1.0
 */
public class DYQ_131_partitionPalindrome_medium {


    //记忆化 然后再回溯
    //记忆化dp 用5题的思路
    public static List<List<String>> partition_final(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) { //right
            for (int j = 0; j <= i; j++) { //left
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2 || dp[j + 1][i - 1]) {
                        dp[j][i] = true;
                    }
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        dfs_final(res, 0, dp, stack, s);
        return res;

    }

    private static void dfs_final(List<List<String>> res, int i, boolean[][] dp, Stack<String> stack, String s) {
        if (i == s.length()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int j = i; j < s.length(); j++) { //起始字符一定再里面
            if (dp[i][j]) {
                stack.add(s.substring(i, j + 1));
                dfs_final(res, j + 1, dp, stack, s);
                stack.pop();
            }
        }
    }


    //我的版本 超时了
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<List<String>> res1 = new ArrayList<>();

        Stack<String> stack = new Stack<>();
        dfs(res, s, 0, stack); //left 和 right 均为闭区间index
        for (int i = 0; i < res.size(); i++) {
            int count = 0;
            for (String s1 : res.get(i)) {
                count += s1.length();
            }
            if (count == s.length()) {
                res1.add(res.get(i));
            }
        }
        return res1;
    }

    private static void dfs(List<List<String>> res, String s, int left, Stack<String> stack) {
        if (left == s.length()) {
            res.add(new ArrayList<>(stack));
        }
        for (int l = left; l < s.length(); l++) {
            for (int r = l; r < s.length(); r++) {
                if (!isPalindrome(s.substring(l, r + 1))) {
                    continue;
                }
                stack.push(s.substring(l, r + 1));
                dfs(res, s, r + 1, stack);
                stack.pop();
            }
        }
    }

    public static boolean isPalindrome(String target) {
        StringBuilder sb = new StringBuilder(target);
        return target.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {

        System.out.println(partition("aab"));

    }
}
