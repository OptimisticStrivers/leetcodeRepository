package edu.cmu.optimisticStrivers.backTracking;

/**
 * @ClassName: DYQ_37_Sudoku_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/31 2:18 AM
 * @Version 1.0
 */
public class DYQ_37_Sudoku_hard {

    //典型的回溯 backtracking 模拟题


    //盘面必须且只有唯一解
    public void solveSudoku(char[][] board) {

        //因为回溯 一定有空间存储 visited 数据

        boolean[][] rows = new boolean[board.length][9];
        boolean[][] columns = new boolean[board[0].length][9];
        boolean[][][] nines = new boolean[board.length / 3][board[0].length / 3][9];

//        int[][] board1 = new int[board.length][board[0].length];
        //初始化
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
//                    board1[i][j] = num;
                    rows[i][num - 1] = true;
                    columns[j][num - 1] = true;
                    nines[i / 3][j / 3][num - 1] = true;
                }
            }
        }
        backtrack(board, rows, columns, nines, 0, 0);

    }

    //从左到右 从上到下
    //所以到右边的时候，向下走一行
    private boolean backtrack(char[][] board, boolean[][] rows, boolean[][] columns, boolean[][][] nines, int i, int j) {
        if (j == board[0].length) {
            //下一行
            j = 0;
            i++;
            if (i == board.length) {
                return true;
            }
        }
        if(board[i][j] == '.' ){ //这个格子是空着的
            for (int k = 1; k <= 9; k++) {
                //都没有出现过
                if (!rows[i][k - 1] && !columns[j][k - 1] && !nines[i / 3][j / 3][k - 1]) {
                    //试一下这个数字可不可以
                    int num = board[i][j] - '0';
                    rows[i][num - 1] = true;
                    columns[j][num - 1] = true;
                    nines[i / 3][j / 3][num - 1] = true;
                    board[i][j] = (char) num; //有问题
                    if (backtrack(board, rows, columns, nines, i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.'; //cassie 提醒
                    //这里必须回执 '.' 因为 backtrack后面的节点 都要恢复成原来的状态
                    rows[i][num - 1] = false;
                    columns[j][num - 1] = false;
                    nines[i / 3][j / 3][num - 1] = false;
                }
            }
        }else {
            return backtrack(board, rows, columns, nines, i, j+ 1);
        }

        return true;
    }
}


