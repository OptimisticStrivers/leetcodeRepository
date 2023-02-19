package edu.cmu.optimisticStrivers.brainTwister;

/**
 * @ClassName: DYQ_289_gameOfLife_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/7 5:28 PM
 * @Version 1.0
 */
public class DYQ_289_gameOfLife_medium {

    //in-place

//    三. 复合状态如何设计？
//    说真的，状态稍微多一点，这种用特定的新数字表示新状态的做法容易把自己搞懵，又是2又是-1的，自己的代码隔一天看，自己都捋不顺。
//    我咋干的？首先遍历的时候我不让每一个格子都看一眼周围的八个格子去更新自己状态。我换个角度，遍历的时候，如果这个格子里是活的，我就让它去“影响”周围的八个格子。
//    这样一来，大批原来是死了的格子就省了很多检查的时间。怎么“影响”？简单，我给被影响的格子里的数字加10。这样一来，个位存着这格子原来的状态，十位就存着它周围有多少个活格子了。
//    比如遍历完了之后一个格子里是41，那就表示它原来自己是1，然后被周围的四个活格子加了四个10，于是周围有四个活细胞。
//    等之后再遍历一遍，更新到最新状态就完事了。

//卡诺图简化状态
//1. 原来是活的，周围有2-3个活的，还是活的
//2. 原来是死的，周围有3个活的，成为活的
//3. 其他都是死了


    int[][] directions = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int column = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < 8; k++) {
                    int dx = directions[k][0];
                    int dy = directions[k][1];
                    if (i + dx >= 0 && i + dx < row && j + dy >= 0 && j + dy < column) {
                        if (board[i + dx][j + dy] % 10 == 1) board[i][j] += 10;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int j = 0; j < column; j++) {
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int aliveSurround = board[i][j] / 10;
                int originState = board[i][j] % 10;
                if (originState == 1 && (aliveSurround == 2 || aliveSurround == 3)) {
                    board[i][j] = 1;
                } else if (originState == 0 && aliveSurround == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
//
//        for (int i = 0; i < row; i++) {
//            System.out.println();
//            for (int j = 0; j < column; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//        }
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                board[i][j] %= 10;
//            }
//        }
    }

//    0, 1, 0
//    0, 0, 1
//    1, 1, 1
//    0, 0, 0

    public static void main(String[] args) {
        int[][] ints = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        DYQ_289_gameOfLife_medium dyq_289_gameOfLife_medium = new DYQ_289_gameOfLife_medium();
        dyq_289_gameOfLife_medium.gameOfLife(ints);
    }
}
