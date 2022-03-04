package edu.cmu.optimisticStrivers.search;

/**
 * @ClassName: CXY_240_SearchA2DMatrixII_medium
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/23/22 10:36 pm
 * @Version 1.0
 */
public class CXY_240_SearchA2DMatrixII_medium {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int totalCount = row + column - 1;

        int a = 0;
        int b = column - 1;
        for (int i = 0; i < totalCount; i++) {
            if(matrix[a][b] < target){
                if(a+1 < row) {
                    a++;
                }
            }else if(matrix[a][b] > target){
                if(b-1 >= 0) {
                    b--;
                }
            }else {
                return true;
            }

        }
        return false;
    }
}

