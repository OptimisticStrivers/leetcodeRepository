package edu.cmu.optimisticStrivers.hard;

import java.util.Stack;

/**
 * @ClassName: DYQ_42_TrapRain_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/12 9:56 下午
 * @Version 1.0
 */
public class DYQ_42_TrapRain_hard {


    // calculate every collum and sum all
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int res = 0;
        // 两侧列不用看
        for (int i = 1; i < height.length - 1; i++) {
            //找到左侧最高的collum
            int leftHighest = 0;
            for (int k = 0; k < i; k++) {
                if (height[k] > leftHighest) {
                    leftHighest = height[k];
                }
            }
            //找到右侧最高的collum
            int rightHighest = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > rightHighest) {
                    rightHighest = height[j];
                }
            }
            int lowerOne = Math.min(leftHighest, rightHighest);
            //只有当前列比这个lowerOne低，才能蓄水
            if (lowerOne > height[i]) {
                res += lowerOne - height[i];
            }
        }
        return res;
    }

    // 用dp优化一下
    public int trap_dp(int[] height) {
        if (height.length <= 2) return 0;
        int res = 0;
        int[] dp_max_left = new int[height.length];
        int[] dp_max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            dp_max_left[i] = Math.max(dp_max_left[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i > 0; i--) {
            dp_max_right[i] = Math.max(dp_max_right[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int lowerOne = Math.min(dp_max_left[i], dp_max_right[i]);
            if (height[i] < lowerOne) {
                res += lowerOne - height[i];
            }
        }
        return res;
    }

    //dp再优化一下，到双指针
//    关于双指针的个人理解： 当maxleft<maxright，满足了maxleft一定是当前left的左右两边高墙之中较低的一个，所以可以用maxleft-h[left]计算，再使left右移。 当maxright<maxleft，满足了maxright一定是当前right的左右两边高墙的较低的一个，所以可以用maxright-h[right]计算，再使right左移。 left和right不断向中间靠拢，直到left>=right。


    //栈

    public int trap_stack(int[] height) {
        if (height.length <= 2) return 0;
        Stack<Integer> stack = new Stack<>();
//        stack.push(0); 和for的其实条件配合即可，可有可无
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            //前面还有，就会夹出水来
            //找到一个比pre高的，就能和current夹出水，要一直找，比如 3，2，1，4。current为4的时候，栈里面有3，2，1
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int pre = stack.pop();
                if(stack.isEmpty()){ //前面没了，比如第一个
                    break;
                }
                //需要再往前找一个，才能组成一个水，2,2,4也行，只不过是0，2，1，4也行
//                int prepre = stack.pop(); 不能pop，不知道前面的那个比current高还是低，高的话，还是应该在栈里，单调栈
                int waterHeight = Math.min(height[i],height[stack.peek()]) - height[pre];
                res += waterHeight*(i-stack.peek()-1);
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        char a = (char)'0' + 1;

        char b = 'a' + 1;
        int digit = 1;
        char c = (char) (digit < 10 ?  ('0' + digit) : ('a' + digit - 10));

        System.out.println(b);
    }
}
