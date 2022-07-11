package edu.cmu.optimisticStrivers.tree.trie;

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


    //Trie  前缀树  当然还是要用dfs 但是预先构建的前缀树能帮我们快速剪枝
    //https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488490&idx=1&sn=db2998cb0e5f08684ee1b6009b974089&chksm=fd9cb8f5caeb31e3f7f67dba981d8d01a24e26c93ead5491edb521c988adc0798d8acb6f9e9d&token=1232059512&lang=zh_CN#rd
    //模仿208 并且用TreeNode格式


    class TrieNode {
        String curString;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    Set<String> res = new HashSet<>();//dfs的时候收集结果
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] vis = new boolean[15][15];

    public List<String> findWords1(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i]); //构建 前缀树
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pos = board[i][j] - 'a';
                if (root.tns[pos] != null) {
                    vis[i][j] = true;
                    dfs(i, j, board, root.tns[pos]);
                    vis[i][j] = false;
                }
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int i, int j, char[][] board, TrieNode trieNode) {
        if (trieNode.curString != null) {  //到结尾了 找到了一个
            res.add(trieNode.curString);
//            return;  这里不能return  因为可能又重复的前缀单词  比如oa 和 oaa  这里return的话 oaa就找不到了
        }
        for (int[] d : dirs) {
            int dx = i + d[0], dy = j + d[1];
            if (dx < 0 || dx >= board.length || dy < 0 || dy >= board[0].length) continue;
            if (vis[dx][dy]) continue;
            int u = board[dx][dy] - 'a';
            if (trieNode.tns[u] != null) {
                vis[dx][dy] = true;
                dfs(dx, dy, board, trieNode.tns[u]);
                vis[dx][dy] = false;
            }
        }
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.tns[pos] == null) {
                cur.tns[pos] = new TrieNode();
            }
            cur = cur.tns[pos];
        }
        cur.curString = word; //最后一个记录，相当于也是end的作用了
    }


}
