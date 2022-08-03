package edu.cmu.optimisticStrivers.stack;

import java.util.Stack;

/**
 * @ClassName: DYQ_1249_minRemoveToMakeValid_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/30 8:07 下午
 * @Version 1.0
 */

public class DYQ_1249_minRemoveToMakeValid_medium {

    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    stack1.pop();
                } else {
                    stack.push(')');
                    stack1.push(i);
                }
            } else {
                if (chars[i] == '(') {
                    stack.push('(');
                    stack1.push(i);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(!stack1.isEmpty() && stack1.peek() == i){
            }else{
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.reverse().toString();


    }
}
