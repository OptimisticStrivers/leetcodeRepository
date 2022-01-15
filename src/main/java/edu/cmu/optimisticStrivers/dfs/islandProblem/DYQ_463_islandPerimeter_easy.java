package edu.cmu.optimisticStrivers.dfs.islandProblem;

/**
 * @ClassName: DYQ_463_islandPerimeter
 * @Description: 岛屿问题1：岛屿的周长
 * @Author Yuqi Du
 * @Date 2022/1/15 4:49 下午
 * @Version 1.0
 */
public class DYQ_463_islandPerimeter_easy {

    //入口方法
    public static int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public static int dfs(int[][] grid, int i, int j) {
        if ((i >= grid.length) || (i < 0) || (j >= grid[0].length) || (j < 0)) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        grid[i][j] = 2;
        // 不是2 不是0 那一定是1喽
        return dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(test));
    }
}
