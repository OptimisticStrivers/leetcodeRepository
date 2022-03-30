package edu.cmu.optimisticStrivers.dynamicProgramming;

public class CXY_119_PascalsTriangleII_easy {
    //用数组代替ArrayLis， 更加节省空间
    public List<Integer> getRow(int rowIndex) {
        int numsInRow = rowIndex + 1;
        int[] lastRow = new int[numsInRow];
        int[] currRow = new int[numsInRow];

        currRow[0] = 1;
        for(int myRowIndex = 1; myRowIndex <= rowIndex; myRowIndex++){
            int[] temp = currRow;
            currRow = lastRow;
            lastRow = temp;

            currRow[0] = 1;
            for(int i = 1; i < myRowIndex; i++){
                currRow[i] = lastRow[i-1] + lastRow[i];
            }
            currRow[myRowIndex] = 1;
        }

        List<Integer> ans = new ArrayList<>(numsInRow);
        for(int num:currRow){
            ans.add(num);
        }
        return ans;
    }

}
