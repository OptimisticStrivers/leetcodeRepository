package edu.cmu.optimisticStrivers.bootcamp.HW3;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: TestCoin
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/18 4:51 PM
 * @Version 1.0
 */
public class TestCoin {

    static int minimum_ops(char[][] board, int time_K, int row, int column) {
        System.out.println(" time " + time_K + " row " + row + " column " + column);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        int rowLen = board.length;
        int columnLen = board[0].length;
        if (rowLen == 0 && columnLen == 0) return -1;
//        int maximumChange = rowLen + columnLen - 2;
        if (row == 0 && column == 0) return 0;

//        BoardPosition curBoardPosition = new BoardPosition(rowLen, columnLen);
        Set<String> hasTraversed = new HashSet<>();
        Set<String> currentSet = new HashSet<>();

        //initialize currentSet with zero steps to go
        currentSet.add("0,0");
        hasTraversed.add("0,0");
        char[] directions = {'U', 'D', 'L', 'R'};
        if (moveWithOutEffort(board, 0, 0, hasTraversed, currentSet, row, column)) return 0;

//        System.out.println( hasTraversed.size() + currentSet.size());
//        System.out.println("123123");

        for (int count = 1; count <= time_K; count++) { // i means current minimum step
            Set<String> tempSet = new HashSet<>();
            for (String s : currentSet) {
                String[] split = s.split(",");
                int curR = Integer.parseInt(split[0]);
                int curC = Integer.parseInt(split[1]);
                //这种 耗费 1步 的 add 的 part1 不需要 递归， 直接上下左右加就好
                for (char direction : directions) {
                    int[] next = checkMoveBoundary(curR, curC, board, direction);
                    if (next != null) {
                        if (next[0] == row && next[1] == column) return count;
                        tempSet.add(next[0] + "," + next[1]);
                        hasTraversed.add(next[0] + "," + next[1]);
                    }
                }
            }
            //tempSet 现在有了 part1 该 part2 了
//            for (String s : tempSet) { //无消耗"递归"  in thread "main" java.util.ConcurrentModificationException
            Set<String> temp1 = new HashSet<>(tempSet);
            for (String s : temp1) {
                String[] split = s.split(",");
                boolean b = moveWithOutEffort(board, Integer.parseInt(split[0]), Integer.parseInt(split[1]), hasTraversed, tempSet, row, column);
                if (b) return count;
            }

            currentSet = tempSet;
        }

        return -1;
    }

    static int[] checkMoveBoundary(int i, int j, char[][] board, char direction) {
        switch (direction) {
            case 'U':
                if (i - 1 >= 0) return new int[]{i - 1, j};
                break;
            case 'D':
                if (i + 1 <= board.length - 1) return new int[]{i + 1, j};
                break;
            case 'L':
                if (j - 1 >= 0) return new int[]{i, j - 1};
                break;
            case 'R':
                if (j + 1 <= board[0].length - 1) return new int[]{i, j + 1};
                break;
        }
        return null;
    }

    //no need to add counter
    static boolean moveWithOutEffort(char[][] board, int i, int j, Set<String> hasTraversed, Set<String> currentSet, int row, int column) {
        int[] pos = checkMoveBoundary(i, j, board, board[i][j]);
        while (pos != null) { //边界条件下 可以到
//            System.out.println(11);
            String next = pos[0] + "," + pos[1];
//            System.out.println(pos[0] + " " + pos[1]);
            if (!hasTraversed.contains(next) && !currentSet.contains(next)) { //且 不会循环重复走
                if (pos[0] == row && pos[1] == column) return true;
//                System.out.println("123   " + pos[0] + " " + pos[1] + " " + board[pos[0]][pos[1]]);
                hasTraversed.add(next);
                currentSet.add(next);
                pos = checkMoveBoundary(pos[0], pos[1], board, board[pos[0]][pos[1]]);
//                System.out.println("222   " +  pos[0] + " " + pos[1] + " " + board[pos[0]][pos[1]]) ;
            } else {
                pos = null;
            }
        }
        return false; // means there is no destination finding
    }


    public static void main(String[] args) {
//        char[][] chars = {{'R', 'D'}, {'*', 'D'}};
//        char[][] chars = {{'R', 'D'}, {'*', 'L'}};
//        System.out.println(minimum_ops(chars, 1, 1, 0));

//        char[][] chars = {{'R', 'L', 'U'}, {'D', 'R', 'R'}, {'L', 'R', '*'}, {'D', 'L', 'R'}};
//        char[][] chars = {{'R', 'L', 'U'}, {'D', 'R', 'R'}, {'L', 'R', 'L'}, {'D', 'L', '*'}};
        char[][] chars = {{'R', 'D', 'D','*'}, {'R', 'D', 'U','U'}, {'U', 'R', 'D','U'}, {'D', 'L', 'R','D'}};

        System.out.println(minimum_ops(chars, 4, 0, 3));

    }

}
