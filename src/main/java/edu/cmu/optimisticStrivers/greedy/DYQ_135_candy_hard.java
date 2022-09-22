package edu.cmu.optimisticStrivers.greedy;

import java.util.Arrays;

/**
 * @ClassName: DYQ_135_candy_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/31 7:36 PM
 * @Version 1.0
 */
public class DYQ_135_candy_hard {

//    There are n children standing in a line. Each child is assigned a rating value
//    given in the integer array ratings.

//    You are giving candies to these children subjected to the following requirements:
//    1 Each child must have at least one candy.
//    2 Children with a higher rating get more candies than their neighbors.

//    Return the minimum number of candies you need to have to distribute the candies to the children.
//    返回最少的candy个数 可以分发给孩子们 还能满足两个条件

//            n == ratings.length
//            1 <= n <= 2 * 10^4
//            0 <= ratings[i] <= 2 * 10^4


    //贪心 不要上来就想全局 这样就会顾此失彼 丢了左边 丢右边
    //所以我们从两个方向 达到 局部最优
    //两个方向都全部局部最优的话 就可以达到全局最优
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1); //先全部置为1
        //从左到右
        for (int i = 1; i < len; i++) { //从1开始 向右
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        //从右往左
        for (int i = len - 2; i >= 0; i--) { //从len-2开始 向左
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i+1] + 1,candies[i]);
        }
        int result = 0;
        for (int candy : candies) {
            result += candy;
        }
        return result;
    }
}
