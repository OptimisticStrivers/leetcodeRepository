package edu.cmu.optimisticStrivers.dfs.islandProblem;

/**
 * @ClassName: DYQ_695_maxAreaOfIsland
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/18 9:48 上午
 * @Version 1.0
 */
public class DYQ_695_maxAreaOfIsland_medium {


    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j){
        if(i<0||j<0||i==grid.length||j==grid[i].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0; //沉岛思想，访问过的grid[i][j]把它沉下去
        return 1 + dfs(grid,i-1,j)+dfs(grid,i,j-1)+dfs(grid,i+1,j)+dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        String a = null;
        System.out.println(a);
        System.out.println( a == null);
//        System.out.println(a.length());
        String b = "";
        System.out.println(b.length());
        System.out.println(b==null); //false
        System.out.println(b.equals("")); //true
    }


}
