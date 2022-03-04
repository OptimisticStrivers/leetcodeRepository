package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_121_BestTimeStock_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/18 7:07 下午
 * @Version 1.0
 */
public class DYQ_121_BestTimeStock_easy {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxRevenue = 0;
        int minPrice = prices[0];
        for (int i = 1; i <prices.length; i++) {
            maxRevenue = Math.max(maxRevenue,prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxRevenue;
    }

}


