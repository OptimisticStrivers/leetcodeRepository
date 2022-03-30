package edu.cmu.optimisticStrivers.dfs.islandProblem;

/**
 * @ClassName: DYQ_200_numberOfIslands_medium
 * @Description: 岛屿问题2：岛屿的个数
 * @Author Yuqi Du
 * @Date 2022/1/15 5:10 下午
 * @Version 1.0
 */
public class DYQ_200_numberOfIslands_medium {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    //这个dfs方法最大作用就是，把1改为2，登记为遍历过，也即同一个岛
    public void dfs(char[][] grid, int row, int column) {
        if ((row < 0) || (row >= grid.length) || (column < 0) || (column >= grid[0].length)) {
            return;
        }
        if (grid[row][column] != '1') { //不是0也不是2
            return;
        }
        grid[row][column] = '2';
        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }


    //bfs
    //行和列可以算出唯一一个值
}
