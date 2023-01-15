package edu.cmu.optimisticStrivers.stack.monotonousStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: DYQ_503_nextGreaterElements2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/11 1:15 PM
 * @Version 1.0
 */
public class DYQ_503_nextGreaterElements2_medium {

//    public static int[] nextGreaterElements(int[] nums) {
//        //其实可以只用一个栈
//        Stack<Integer> indexStack = new Stack<>();
//        Stack<Integer> stack = new Stack<>(); //单调递减 或者相等
//        int[] res = new int[nums.length];
//        Arrays.fill(res, -1);
//        int steps = 2 * nums.length; //最多走两圈
//        int i = 0;
//        while (steps-- > 0) {
//            while (!stack.isEmpty() && nums[i] > stack.peek()) {
//                res[indexStack.pop()] = nums[i];
//                stack.pop();
//            }
//            stack.push(nums[i]);
//            indexStack.push(i);
//            i = (i + 1) % nums.length;
//        }
//        return res;
//    }

//    https://leetcode.cn/problems/next-greater-element-ii/solution/cong-po-su-jie-fa-de-jiao-du-qu-li-jie-d-trht/
    public static int[] nextGreaterElements(int[] nums) {
        //其实可以只用一个栈
        Stack<Integer> stack = new Stack<>(); //存单调递减的 nums[index] 实际就是
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int steps = 2 * nums.length; //最多走两圈
        int i = 0;
        while (steps-- > 0) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
            i = (i + 1) % nums.length;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}
