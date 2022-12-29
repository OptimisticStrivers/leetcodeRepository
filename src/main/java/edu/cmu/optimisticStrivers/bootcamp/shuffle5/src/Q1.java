package edu.cmu.optimisticStrivers.bootcamp.shuffle5.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/8 4:07 PM
 * @Version 1.0
 */
public class Q1 {
//    String target = "1121";

//    1112
//    1       1               1       2
// 1 1 1 2    1 1 2
    public List<String> solve(String target) {
        char[] chars = target.toCharArray();
        Arrays.sort(chars);
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        List<String> res = new ArrayList<>();
        dfs(chars, 0, stack, stack1, res);
        return res;
    }

    public void dfs(char[] chars, int i, Stack<Character> stack, Stack<Integer> stack1, List<String> res) {
        if (stack.size() == chars.length) {
            StringBuilder temp = new StringBuilder();
            for (Character character : stack) {
                temp.append(character);
            }
            temp.reverse();
            res.add(temp.toString());
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (stack1.contains(j)) {
                continue;
            }
            if (j > 0 && chars[j - 1] == chars[j] && !stack1.contains(j - 1)) continue;
            stack.push(chars[j]);
            stack1.push(j);
            dfs(chars, j + 1, stack, stack1, res);
            stack.pop();
            stack1.pop();
        }
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        String target = "1121";
//        112 121 211
//        1121 1211 1112 2111
        List<String> solve = q1.solve(target);
        System.out.println(solve.size());
        for (String s : solve) {
            System.out.println(s);
        }
    }
}
