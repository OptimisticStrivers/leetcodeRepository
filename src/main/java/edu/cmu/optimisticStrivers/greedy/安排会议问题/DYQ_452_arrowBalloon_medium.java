package edu.cmu.optimisticStrivers.greedy.安排会议问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: DYQ_452_arrowBalloon_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/15 1:28 PM
 * @Version 1.0
 */
public class DYQ_452_arrowBalloon_medium {

    //    这道题还有一种贪心的解法，其效率要比动态规划更好，但由于和本文的主题不一致，就不在这里讲了。

//    贪心思想：
//    因为本题用到了贪心算法所以先来了解一下「贪心算法」的问题需要满足的条件：
//
//    最优子结构：规模较大的问题的解由规模较小的子问题的解组成，规模较大的问题的解只由其中一个规模较小的子问题的解决定；
//    无后效性：后面阶段的求解不会修改前面阶段已经计算好的结果；
//    贪心选择性质：从局部最优解可以得到全局最优解。
//    综上可得：贪心算法就是做出当前状态下的最优选择认为就可以解决问题。
//    思路分析：
//    本题最直观的思路就是，如果重叠的气球越多越好这样一下就可以射爆更多的气球了，贪心就体现在每次都想去射重叠最多的气球这样就可以达到全局最优解用最少的 弓箭数。
//
//    局部最优解：当气球出现重叠时一起射所用弓箭最少。
//    全局最优解：射爆所用弓箭最少。


    //按照右边排序 代码更简单一些 效率高一丢丢
    // 尽量一根箭 射更多 就是局部最优 -> 全局最优
    public int findMinArrowShots_final(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); //右边界增序排列
        if (points == null || points.length == 0) {
            return 0;
        }
        int res = 1; //至少一根
        int last = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > last) {
                last = points[i][1];
                res++;
            }
        }
        return res;
    }

    //按照左边排序
    // 尽量一根箭 射更多 就是局部最优 -> 全局最优
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0])); //左边界增序排列
        if (points == null || points.length == 0) {
            return 0;
        }
        int res = 1; //至少一根
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= points[i - 1][1]) { // 和前一个有重合
                //更新这一根箭能射到的最大范围是
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            } else {
                res++;
            }
        }
        return res;
    }


    //按左边排序 还是 右边排序
//    https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/solution/tan-xin-an-endpai-xu-bi-an-startpai-xu-yao-hao-by-/
}
