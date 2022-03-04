package edu.cmu.optimisticStrivers.stack;

import java.util.Stack;

/**
 * @ClassName: DYQ_946_ValidateStackSequences_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/22 6:42 下午
 * @Version 1.0
 */
public class DYQ_946_ValidateStackSequences_medium {

//    [1,2,3,4,5], popped = [4,3,5,2,1]
//     [1,2,3,4,5], popped = [4,3,5,1,2]

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int size = pushed.length;
        Stack<Integer> in = new Stack<>();
        int i = 0;
        for(int num : pushed){
            in.push(num);
            while(!in.isEmpty()&&in.peek()==popped[i]){
                in.pop();
                i++;
            }
        }
        return in.isEmpty(); //i==size
    }

    public static void main(String[] args) {
        validateStackSequences(new int[]{2,1,0},new int[]{1,2,0});
    }

}
