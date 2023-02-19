package edu.cmu.optimisticStrivers.greedy.安排会议问题;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: DYQ_435_eraseOverlapIntervals_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/15 12:52 PM
 * @Version 1.0
 */
public class DYQ_435_eraseOverlapIntervals_medium {

//    这道题还有一种贪心的解法，其效率要比动态规划更好，但由于和本文的主题不一致，就不在这里讲了。

    //和452射箭一个思路 但是稍有变化
    //现在 射几个箭 就代表一定有多少个
    public static int eraseOverlapIntervals_final(int[][] intervals) {
        // 本题其实和452.用最少数量的箭引爆气球非常像，弓箭的数量就相当于是非交叉区间的数量，
        // 只要把弓箭那道题目代码里射爆气球的判断条件加个等号（认为[0，1][1，2]不是相邻区间），然后用总区间数减去弓箭数量 就是要移除的区间数量了。
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); //左边界增序排列
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            int res = 1; //至少一根
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < intervals[i-1][1]) { // 必须严格 小 才算重合 ，这里和arrow那题有点区别
//                    [[1,2],[2,3],[3,4],[1,3]]
                    intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]); //可以这样理解
                    //2<3 那么 右边界就更新为2 因为只要尽量跨度小 后面才有可能尽可能多的不重合 res变量才能尽可能大，题目要的就是尽可能多的不重合
                    //换句话说 就是最后的结果集里面 留下的是[1,2] 删掉的是 [1,3]

                    //但是452这里考虑的思路不同
                    //因为 只有把区间往小的那方划，那么才能保证这一箭都穿过，才能继续往后面迭代
                }else{
                    res ++;
                }
            }
            //删掉最少个区间数量
            //那么就要求独立区间的数量尽量多

            //res 我们需要多少个箭 即 多少个独立区间
            //那么我们就需要删除掉 len-res个
            return intervals.length - res;
    }


    //动态规划 会超时
    public static int eraseOverlapIntervals(int[][] intervals) {
        //找最长序列即可
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        System.out.println(Arrays.toString(dp));
        int maxLen = Arrays.stream(dp).max().getAsInt();
        return intervals.length - maxLen;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        }));
    }
}
