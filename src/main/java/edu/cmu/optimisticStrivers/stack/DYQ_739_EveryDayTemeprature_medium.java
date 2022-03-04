package edu.cmu.optimisticStrivers.stack;

import java.util.Stack;

/**
 * @ClassName: DYQ_739_EveryDayTemeprature_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 10:42 下午
 * @Version 1.0
 */
public class DYQ_739_EveryDayTemeprature_medium {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int temp = stack.pop();
                System.out.println(temp+" "+ temperatures[i]);
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(test);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
//        1,1,4,2,1,1,0,0
    }

}
