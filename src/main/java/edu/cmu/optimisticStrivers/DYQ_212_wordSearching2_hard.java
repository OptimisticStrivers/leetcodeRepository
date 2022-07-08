package edu.cmu.optimisticStrivers;

import java.util.*;

public class DYQ_212_wordSearching2_hard {


    // 因为 word 都不会超过 10 长度
    // 直接暴搜 超过10剪枝 (想方设法  剪枝)
    // 超时
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        String curString = "";
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                backtrack(board, words, res, set, i, j, visited, "");
            }
        }
        return new ArrayList<>(res);

    }

    public void backtrack(char[][] board, String[] words, Set<String> res, Set<String> set, int i, int j, boolean[][] visited, String curString) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || curString.length() > 10) {
            return;
        }
        curString = curString + board[i][j];
        if (set.contains(curString)) {
            res.add(curString); //res先使用set 防止重复加入结果
        }
        visited[i][j] = true;
        backtrack(board, words, res, set, i + 1, j, visited, curString);
        backtrack(board, words, res, set, i - 1, j, visited, curString);
        backtrack(board, words, res, set, i, j + 1, visited, curString);
        backtrack(board, words, res, set, i, j - 1, visited, curString);
        visited[i][j] = false;
    }


    //Trie  前缀树
//    https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488490&idx=1&sn=db2998cb0e5f08684ee1b6009b974089&chksm=fd9cb8f5caeb31e3f7f67dba981d8d01a24e26c93ead5491edb521c988adc0798d8acb6f9e9d&token=1232059512&lang=zh_CN#rd

}
