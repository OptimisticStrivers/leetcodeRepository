package edu.cmu.optimisticStrivers.bootcamp.HW6;

/**
 * @ClassName: Q3
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/23 11:21 AM
 * @Version 1.0
 */
public class Q3 {

    //coin collector

    public static int[] collector(boolean[][] grid, int C) {
        int columnLen = grid[0].length;
        int rowLen = grid.length;
        if(grid.length == 0 || grid[0].length == 0) return new int[0];
        int[] pre = new int[columnLen];
        pre[0] = grid[0][0] ? C + 1 : C;
        for (int i = 1; i < columnLen; i++) {
            pre[i] = pre[i - 1] + (grid[0][i] ? 1 : -1);
        }
        int[] left2right = new int[columnLen];
        int[] right2left = new int[columnLen];
        for (int row = 1; row < rowLen; row++) {
            //initialization
            for (int i = 0; i < columnLen; i++) {
                left2right[i] = pre[i] + (grid[row][i] ? 1 : -1);
                right2left[i] = pre[i] + (grid[row][i] ? 1 : -1);
//                cur[i] = pre[i] + (grid[row][i] ? 1 : -1);
            }
            //left -> right
            for (int i = 1; i < columnLen; i++) {
                left2right[i] = Math.max(left2right[i - 1] + (grid[row][i] ? 1 : -1), left2right[i]);
            }
            //right -> left
            for (int i = columnLen - 2; i >= 0; i--) {
                right2left[i] = Math.max(right2left[i + 1] + (grid[row][i] ? 1 : -1), right2left[i]);
            }

            for (int i = 0; i < columnLen; i++) {
                pre[i] = Math.max(left2right[i], right2left[i]);
            }
            pre = right2left;
        }

        return pre;
    }

    public static void main(String[] args) {
        boolean[][] booleans = new boolean[][]{
                {false, false, false, false, false, true, true, true},
                {true, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, true},
                {true, true, true, false, true, true, true, true},
        };
        collector(booleans, 10);
    }

//    .....***
//            *......*
//            *......*
//            *......*
//            *......*
//            ***.****

//    F T             10 11
//    F T             11 12
}
