package edu.cmu.optimisticStrivers.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_118_PascalTriangle_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/7 6:38 下午
 * @Version 1.0
 */
public class DYQ_118_PascalTriangle_easy {

    //传统dp
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
                if(j==0 || j==i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
                subList.add(arr[i][j]);
            }
            list.add(subList);
        }
        return list;
    }


    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0) return res;
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || j==i){
                    cur.add(1);
                }else{
                    cur.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(new ArrayList<>(cur));
        }
        return res;
    }
}
