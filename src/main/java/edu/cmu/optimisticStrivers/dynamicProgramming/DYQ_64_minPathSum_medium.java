package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_64_minPathSum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/25 2:42 PM
 * @Version 1.0
 */
public class DYQ_64_minPathSum_medium {

//    https://blog.csdn.net/wodemaoheise/article/details/107544586


    //dp可以
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i];
            if (i > 0) {
                dp[0][i] += dp[0][i - 1];
            }
        }
        for (int i = 0; i < grid.length; i++) {
            dp[i][0] = grid[i][0];
            if (i > 0) {
                dp[i][0] += dp[i - 1][0];
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    //记忆化搜索也可以
    public int minPathSum_dfs(int[][] grid) {
        int[][] mem = new int[grid.length][grid[0].length];
        return dfs(grid, mem, 0, 0);
    }

    private int dfs(int[][] grid, int[][] mem, int r, int c) {
        if (r >= mem.length || c >= mem[0].length) {
            return Integer.MAX_VALUE;
        }
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }
        if (mem[r][c] == 0) {
            mem[r][c] = grid[r][c] + Math.min(dfs(grid, mem, r + 1, c), dfs(grid, mem, r, c + 1));
        }
        return mem[r][c];
    }

}
