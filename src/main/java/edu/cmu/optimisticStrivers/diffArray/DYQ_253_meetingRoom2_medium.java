package edu.cmu.optimisticStrivers.diffArray;

import java.util.Arrays;

/**
 * @ClassName: DYQ_253_meetingRoom2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 11:18 AM
 * @Version 1.0
 */
public class DYQ_253_meetingRoom2_medium {

//    给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时
//    间 intervals[i] = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会
//    议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。


    //或者也可以给你一个二维数组 问你有几个一维数组是重叠的

    public static int getNum(int[][] intervals) {
        int maxTime = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            maxTime = Math.max(maxTime, Arrays.stream(interval).max().getAsInt());
        }
//        System.out.println(maxTime);
        int[] diff = new int[maxTime + 2];
        for (int[] interval : intervals) {
            diff[interval[0]]++;
            diff[interval[1] + 1]--;
        }
        int presum = 0;
        int result = 0;
        for (int i : diff) {
            presum += i;
            result = Math.max(presum, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{2, 4}, {3, 3}, {5, 7}, {5, 8}, {6, 6}};
        System.out.println(getNum(ints));
    }
}
