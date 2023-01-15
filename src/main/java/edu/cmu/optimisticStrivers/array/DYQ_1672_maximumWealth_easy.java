package edu.cmu.optimisticStrivers.array;

import java.util.Arrays;

/**
 * @ClassName: DYQ_1672_maximumWealth_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/7 11:11 AM
 * @Version 1.0
 */
public class DYQ_1672_maximumWealth_easy {

    public int maximumWealth(int[][] accounts) {

        int max = 0;
        for(int i = 0; i<accounts.length; i++){
            int sum = Arrays.stream(accounts[i]).sum();
            max = Math.max(sum,max);
        }
        return max;

    }
}
