package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_63_uniquePathsWithObstacles_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/17 11:48 上午
 * @Version 1.0
 */
public class DYQ_63_uniquePathsWithObstacles_medium {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0; //起点都到不了
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = 1; //一开始就在左上角

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                if(i==0&&j==0) continue;
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0; //无路可达
                    continue;
                }
                if(i==0){
                    dp[i][j] = dp[i][j-1];
                }else if(j==0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[rows-1][columns-1];
    }
}
