package edu.cmu.optimisticStrivers.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_17_LetterCombinations_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/28 8:53 下午
 * @Version 1.0
 */
public class DYQ_17_LetterCombinations_medium {

    public static List<String> letterCombinations(String digits) {
        String[] list = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        StringBuilder stringBuilder = new StringBuilder();
        int init = digits.charAt(0);
        int n = digits.length();
        dfs(list, res, stringBuilder, n, 0, digits);
        return res;
    }

    private static void dfs(String[] list, List<String> res, StringBuilder stringBuilder, int n, int i, String digits) {
        if (i == n) {
            res.add(stringBuilder.toString());
            return;
        }
        int curNumber = digits.charAt(i) - 48;
        for (int j = 0; j < list[curNumber].length(); j++) {
            stringBuilder.append(list[curNumber].charAt(j));
            dfs(list, res, stringBuilder, n, i + 1, digits);
            stringBuilder.deleteCharAt(i);
        }
    }

    public static void main(String[] args) {
        letterCombinations("2");
    }

}
