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

    public static int candy_final(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] nums = new int[ratings.length];//记录每一位孩子得到的糖果数
        nums[0] = 1;
        //先正序遍历，如果后一位比前一位高分，就给比前一位多1的糖果，否则给1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            } else {
                nums[i] = 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        //在倒叙遍历，如果前一位比后一位高分并且得到的糖果小于或等于后一位，就给前一位孩子比后一位孩子多一个糖果
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && nums[i] <= nums[i + 1]) {
                nums[i] = nums[i + 1] + 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        int count = 0;
        for (int i : nums) {
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(candy_final(new int[]{1,2,2}));
    }

    //    这在leetcode上是一道困难的题目，其难点就在于贪心的策略，如果在考虑局部的时候想两边兼顾，就会顾此失彼。
//
//    那么本题我采用了两次贪心的策略：
//
//    一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
//    一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
//    这样从局部最优推出了全局最优，即：相邻的孩子中，评分高的孩子获得更多的糖果。
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1); //先全部置为1
        //从左到右

        //1 2 4 4 3
        //1 2 3 1 1

        // 5 4 6 1
        // 1 1 2 1
        for (int i = 1; i < len; i++) { //从1开始 向右
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1; //大rating的多给一颗糖
        }
        // 5 4 6 1
        // 1 1 2 1
        // 2 1 2 1
        //从右往左 不能丢了刚才从左往右的局部状态 （无向后性 贪心）
        for (int i = len - 2; i >= 0; i--) { //从len-2开始 向左
            //本来就是左边的多的话 就左边的
            //如果是右边的多的话 左边就等于右边的+1
            if (ratings[i] > ratings[i + 1]) {
                if (candies[i + 1] == candies[i]) { //因为这个if可以进 在上面的if就一定没有进 所以两者一样
                    //但现在不能两者一样 而是 左边要多一个糖
                    candies[i]++;
                } else { //除了等号 candies[i+1]一定比candies[i]小 可以从上面的第一个for得出
                    candies[i] = candies[i];
                }
            }
//                candies[i] = Math.max(candies[i+1] + 1,candies[i]);
        }
        int result = 0;
        for (int candy : candies) {
            result += candy;
        }
        return result;
    }
}
