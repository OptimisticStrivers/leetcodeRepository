package edu.cmu.optimisticStrivers.dynamicProgramming;

/**
 * @ClassName: DYQ_122_BestTimeStock2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/7 7:03 PM
 * @Version 1.0
 */
public class DYQ_122_BestTimeStock2_medium {

//    [7, 1, 5, 6] 第二天买入，第四天卖出，收益最大（6-1），所以一般人可能会想，
//    怎么判断不是第三天就卖出了呢? 这里就把问题复杂化了，
//    根据题目的意思，当天卖出以后，当天还可以买入，所以其实可以第三天卖出，第三天买入，
//    第四天又卖出（（5-1）+ （6-5） === 6 - 1）。所以算法可以直接简化为只要今天比昨天大，就卖出。

//    算法题（×） 脑筋急转弯题( √ ）
//    扫描一遍 只要后一天比前一天大 就把这两天的差值加一下
    public int maxProfit1(int[] prices) {
        int ans = 0;
        for (int i = 1; i <= prices.length - 1; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }


    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buyingPrice = prices[0];
//        int oneProfit = 0;
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= buyingPrice) {
                buyingPrice = prices[i];
                continue;
            }
            while (i + 1 < prices.length && prices[i + 1] > prices[i]) { //找最大的点卖掉
                i++;
            }
            System.out.println(i + " " + prices[i] + " " + buyingPrice);
            totalProfit += prices[i] - buyingPrice;
            if (i + 1 < prices.length) buyingPrice = prices[i + 1]; //不可能一天即买 又买 没有意义
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
