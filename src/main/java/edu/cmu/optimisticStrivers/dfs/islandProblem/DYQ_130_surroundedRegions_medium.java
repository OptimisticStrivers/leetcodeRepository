package edu.cmu.optimisticStrivers.dfs.islandProblem;

/**
 * @ClassName: DYQ_130_surroundedRegions_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/14 11:36 AM
 * @Version 1.0
 */
public class DYQ_130_surroundedRegions_medium {


//    给你一个 M×N 的二维矩阵，其中包含字符 X 和 O，让你找到矩阵中四面被 X 围住的 O，并且把它们替换成 X。

//dfs
//    注意哦，必须是四面被围的 O 才能被换成 X，也就是说边角上的 O 一定不会被围，进一步，与边角上的 O 相连的 O 也不会被 X 围四面，也不会被替换。
//其实这个问题应该归为 岛屿系列问题 使用 DFS 算法解决：
//先用 for 循环遍历棋盘的四边，用 DFS 算法把那些与边界相连的 O 换成一个特殊字符，比如 #；然后再遍历整个棋盘，把剩下的 O 换成 X，把 # 恢复成 O。这样就能完成题目的要求，时间复杂度 O(MN)。

    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    //把边上的0都换成* 并且与之相连的也换成*
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '*';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

//    另外，一些使用 DFS 深度优先算法解决的问题，也可以用 Union-Find 算法解决。 但是杀鸡用牛刀了
//    https://leetcode.cn/problems/surrounded-regions/
//    比如力扣第 130 题「 被围绕的区域」：


}
