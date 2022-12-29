package edu.cmu.optimisticStrivers.OA.goldsman;

import java.util.List;

/**
 * @ClassName: Q4
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/16 11:08 PM
 * @Version 1.0
 */
public class Q4 {

    /*
     * Complete the 'maxProfit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER costPerCut
     *  2. INTEGER salePrice
     *  3. INTEGER_ARRAY lengths
     */


    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        // Write your code here
        int maxRod = 0;
        for (int i = 0; i < lengths.size(); i++) {
            maxRod = Math.max(maxRod,lengths.get(i));
        }
        int resProfit = 0;

        for (int i = 1 ; i <= maxRod; i++) { //sale length
            int curProfit = 0;
            for (int j = 0; j < lengths.size(); j++) {
                int rodLen = lengths.get(j);
                int unitNum = rodLen/i;
                int cutNum = rodLen % i == 0 ? unitNum-1 : unitNum;
                if (unitNum * i * salePrice < cutNum * costPerCut ) continue;
                curProfit += unitNum * i * salePrice - cutNum * costPerCut;
            }
            resProfit = Math.max(resProfit,curProfit);
        }
        return resProfit;
    }

}
