package edu.cmu.optimisticStrivers.dfs.islandProblem;

/**
 * @ClassName: DYQ_1905_countSubIslands
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/18 10:21 上午
 * @Version 1.0
 */
public class DYQ_1905_countSubIslands_medium {

    static boolean check = true; //每次找到grid2的一个岛，都重置check为true，只要此岛grid2里面的每一个元素都和grid1重合，result++
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid1, grid2, i, j);
                    result = check ? result + 1 : result;
                    check = true; //重置
                }
            }
        }
        return result;
    }

    static int[][] direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || j < 0 || i == grid2.length || j == grid2[i].length || grid2[i][j] == 0) {
            return;
        }
        //下面的scope grid2[i][j]==1
        if (grid1[i][j] != 1) {
            check = false; //这里千万不能return，只要!=1，就要把整片岛都沉下去！！！
        }
        grid2[i][j] = 0; //沉岛
        //直接写成一句return也可以，这种方向向量也挺帅
        for (int k = 0; k < 4; k++) {
            dfs(grid1, grid2, i + direction[k][0], j + direction[k][1]);
        }
    }

}
