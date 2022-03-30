package edu.cmu.optimisticStrivers.backTracking;

import java.util.*;

/**
 * @ClassName: DYQ_77_combination_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/4 7:19 下午
 * @Version 1.0
 */
public class DYQ_77_combination_medium {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(1,res,stack,k,n);
        return res;
    }

    public static void dfs(int curNode, List<List<Integer>> res, Stack<Integer> stack, int k, int n) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = curNode; i <= n; i++) {
            stack.push(i);
            dfs(i+1, res, stack, k, n);
            stack.pop();
        }
    }


    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

}
