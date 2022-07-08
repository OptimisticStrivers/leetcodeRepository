package edu.cmu.optimisticStrivers;

public class DYQ_79_wordSearching_medium {


    private boolean find;  // 定义为成员变量，方便以下两个成员方法使用和修改

    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        find = false;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                backtracking(i, j, board, word, visited, 0);  // 从左上角开始遍历棋盘每个格子
            }
        }
        return find;
    }

    public void backtracking(int i, int j, char[][] board, String word, boolean[][] visited, int pos){
        //这种写法真的不赖 最主要是把find全局保存 随用随取
        //回溯dfs的返回值还是voids
        if(i<0 || i>= board.length || j<0 || j >= board[0].length || visited[i][j] || find
                || board[i][j]!=word.charAt(pos))  return;

        if(pos == word.length()-1){
            find = true;
            return;
        }

        visited[i][j] = true;  // 修改当前节点状态
        backtracking(i+1, j, board, word, visited, pos+1);  // 遍历子节点
        backtracking(i-1, j, board, word, visited, pos+1);
        backtracking(i, j+1, board, word, visited, pos+1);
        backtracking(i, j-1, board, word, visited, pos+1);
        visited[i][j] = false; // 撤销修改
    }


}
