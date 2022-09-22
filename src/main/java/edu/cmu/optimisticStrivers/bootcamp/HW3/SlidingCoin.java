package edu.cmu.optimisticStrivers.bootcamp.HW3;

import java.util.HashMap;

/**
 * @ClassName: SlidingCoin
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/18 1:25 PM
 * @Version 1.0
 */
public class SlidingCoin {

    static int minimum_ops(char[][] board, int time_K, int row, int column) {
        // System.out.println(" time " + time_K + " row " + row + " column " + column);
        if(board==null)return -1;
        int rowLen = board.length;
        if(board.length == 0) return -1;  //这边界条件也太tm傻逼了
        if(board[0].length == 0) return -1;
        int columnLen = board[0].length;

//        if (rowLen == 0 && columnLen == 0) return -1;
        int maximumChange = rowLen + columnLen - 2;
        if (row == 0 && column == 0) {
            return 0;
        }

//        Set<String> hasTraversed = new HashSet<>();
//        Set<String> currentSet = new HashSet<>();
        HashMap<String, Integer> hasTraversed = new HashMap<>();
        HashMap<String, Integer> currentSet = new HashMap<>();

        //initialize currentSet with zero steps to go
        currentSet.put("0,0", 0);
        hasTraversed.put("0,0", 0);
        char[] directions = {'U', 'D', 'L', 'R'};
        if (moveWithOutEffort(board, 0, 0, hasTraversed, currentSet, row, column, time_K)) return 0;

//        System.out.println( hasTraversed.size() + currentSet.size());
//        System.out.println("123123");

//        for (int count = 1; count <= time_K; count++) { // i means current minimum step
        for (int count = 1; count <= maximumChange; count++) { // i means current minimum step
            HashMap<String, Integer> tempSet = new HashMap<>();

            for (String s : currentSet.keySet()) {
                Integer time = currentSet.get(s);
                String[] split = s.split(",");
                int curR = Integer.parseInt(split[0]);
                int curC = Integer.parseInt(split[1]);
                //这种 耗费 1步 的 add 的 part1 不需要 递归， 直接上下左右加就好
                for (char direction : directions) {
                    int[] next = checkMoveBoundary(curR, curC, board, direction);
                    if (next != null && time < time_K) {
                        if (next[0] == row && next[1] == column) return count;
                        tempSet.put(next[0] + "," + next[1], time + 1);
                        hasTraversed.put(next[0] + "," + next[1], time + 1);
                    }
                }
            }
            //tempSet 现在有了 part1 该 part2 了
//            for (String s : tempSet) { //无消耗"递归"  in thread "main" java.util.ConcurrentModificationException
            HashMap<String, Integer> temp1 = new HashMap<>(tempSet);
            for (String s : temp1.keySet()) {
                String[] split = s.split(",");
                boolean b = moveWithOutEffort(board, Integer.parseInt(split[0]), Integer.parseInt(split[1]), hasTraversed, tempSet, row, column, time_K);
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
    static boolean moveWithOutEffort(char[][] board, int i, int j, HashMap<String, Integer> hasTraversed, HashMap<String, Integer> currentSet, int row, int column, int time_k) {
        int[] pos = checkMoveBoundary(i, j, board, board[i][j]);
        int current_time = currentSet.get(i + "," + j);
        while (pos != null && current_time < time_k) { //边界条件下 可以到
//            System.out.println(11);
            String next = pos[0] + "," + pos[1];
//            System.out.println(pos[0] + " " + pos[1]);
            if (!hasTraversed.containsKey(next) && !currentSet.containsKey(next)) { //且 不会循环重复走
                if (pos[0] == row && pos[1] == column) {
                    return true;
                }
//                System.out.println("123   " + pos[0] + " " + pos[1] + " " + board[pos[0]][pos[1]]);
                current_time++;
                hasTraversed.put(next, current_time);
                currentSet.put(next, current_time);
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

//        System.out.println(minimum_ops(chars, 10, 3, 2));
//
//        char[][] chars = {{'R', 'D', 'D', '*'}, {'R', 'D', 'U', 'U'}, {'U', 'R', 'D', 'U'}, {'D', 'L', 'R', 'D'}};
//
//        System.out.println(minimum_ops(chars, 4, 0, 3));


        char[][] a = new char[10][];
//        System.out.println(a[1]); //Cannot read the array length because "cbuf" is null
        a[1] = new char[0];
//        System.out.println(a[1][0]); // Cannot load from char array because "a[1]" is null
        System.out.println(a[1][0]); //ctm ctm

    }
}
