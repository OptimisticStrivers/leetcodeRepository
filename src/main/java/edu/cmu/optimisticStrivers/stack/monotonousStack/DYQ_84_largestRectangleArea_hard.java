package edu.cmu.optimisticStrivers.stack.monotonousStack;

import java.util.Stack;

/**
 * @ClassName: DYQ_84_largestRectangleArea_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/17 8:14 PM
 * @Version 1.0
 */
public class DYQ_84_largestRectangleArea_hard {

    public int largestRectangleArea_1(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {

            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }


    public int largestRectangleArea(int[] heights) {
        int[] heightsNew = new int[heights.length + 2];
        //两边是哨兵
        System.arraycopy(heights, 0, heightsNew, 1, heights.length);
        Stack<Integer> stack = new Stack<>(); //单调递增栈 但是存index
        int res = 0;
        for (int i = 0; i < heightsNew.length; i++) {
            while (!stack.isEmpty() && heightsNew[stack.peek()] > heightsNew[i]) { //相等的时候 肯定还是要进栈的 然后遇到小的再算面积
                int popIndex = stack.pop(); //要算面积的是 被pop出的这一个
                res = Math.max(res, heightsNew[popIndex] * (i - stack.peek() - 1)); //左右边最小的
            }
            //元素必进stack
            stack.push(i);
        }
        return res;
    }

}
