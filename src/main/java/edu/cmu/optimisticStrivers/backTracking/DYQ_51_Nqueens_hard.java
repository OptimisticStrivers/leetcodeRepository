package edu.cmu.optimisticStrivers.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DYQ_51_Nqueens_hard {

    //    https://leetcode.cn/problems/n-queens/solution/dai-ma-sui-xiang-lu-51-n-queenshui-su-fa-2k32/
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
//        boolean[][] visited = new boolean[n][n];
        char[][] chessBoard = new char[n][n]; //用于增加进res 也顺便能当visited用
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        dfs(chessBoard, 0, n); //第0行 进去
        return res;
    }

    public void dfs(char[][] chessBoard, int row, int n) {
        if (row == n) {  //n纬度的棋盘  最多有n层   但是3皇后 (三皇后 且 棋盘是3乘3) 本身属于无解的
            // row 等于0开始的 比如n=3 那么3的时候其实就是结束的时候 因为 0 1 2 3
            add(chessBoard, n);
            return;
        }
        for (int column = 0; column < n; column++) {  //n列
            if (canPutAQueen(row, column, n, chessBoard)) {
                chessBoard[row][column] = 'Q';
                dfs(chessBoard, row + 1, n);
                chessBoard[row][column] = '.';
            }
        }
    }

    public void add(char[][] chessBoard, int n) {
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String cur = "";
//            for (int j = 0; j <n ; j++) {
//                cur += chessBoard[i][j];
//            }
//            list.add(cur);
//        }
//        res.add(list);
        List<String> list = new ArrayList<>();

        for (char[] c : chessBoard) {
            list.add(String.copyValueOf(c));
        }
        res.add(list);
    }

    private boolean canPutAQueen(int row, int column, int n, char[][] chessBoard) {
        //行不用检查

        //检查列
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][column] == 'Q') return false;
        }
        // 检查45度对角线
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) { //验证前一行的即可
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = column + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }
}
