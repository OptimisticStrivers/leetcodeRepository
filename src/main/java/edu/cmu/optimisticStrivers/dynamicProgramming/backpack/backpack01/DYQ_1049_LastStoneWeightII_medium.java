package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpack01;

/**
 * @ClassName: DYQ_1049_LastStoneWeightII_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/21 4:13 下午
 * @Version 1.0
 */
public class DYQ_1049_LastStoneWeightII_medium {
//01背包最值问题

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int target = sum/2; //其实就是mid，就向下取整就可以，因为我们的目的是A<=B
        int[] dp = new int[target+1];
//        dp[0] = 1; //不能初始化，因为++的是stone本身
        for(int stone: stones){
            for (int i = target; i >= stone ; i--) { //必须从右往左，因为01背包的话，每个物品只能取一个，即一行不能重复取，这里可以对比322
                // 完全背包最值问题，322， coinchange
                // 上面的i>= stone 相当于原来这部分的if
                dp[i] = Math.max(dp[i],dp[i-stone]+stone);
            }
        }
        return sum-2*dp[target];
    }
}
