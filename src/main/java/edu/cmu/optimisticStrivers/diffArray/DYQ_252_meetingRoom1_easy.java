package edu.cmu.optimisticStrivers.diffArray;

import java.util.Arrays;

/**
 * @ClassName: DYQ_252_meetingRoom1_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/7 8:29 PM
 * @Version 1.0
 */
public class DYQ_252_meetingRoom1_easy {
    //Given an array of meeting time intervals consisting of start and end times
    // [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.


    public static boolean canAttendMeetings(int[][] intervals) {
        int max = -1;
        for (int[] interval : intervals) {
            max = Math.max(Arrays.stream(interval).max().getAsInt(), max);
        }
//        System.out.println(max);
        int[] ints = new int[max + 2];
        for (int[] interval : intervals) {
            ints[interval[0]]++;
            ints[interval[1] + 1]--;
        }
        int presum = 0;
        for (int anInt : ints) {
            presum += anInt;
            if (presum >= 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] ints = {{0, 30}, {5, 10}, {15, 20}};
        int[][] ints = {{7, 10}, {2, 4}};
        System.out.println(canAttendMeetings(ints));
    }


    //方法二 直接排序 看有没有重合
    public boolean canAttendMeetings1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //按照第一个元素排序
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) { //如果下一个第一个元素 比前一个的第二个元素还小的话 说明有overlapping
                return false;
            }
        }
        return true;
    }


}
