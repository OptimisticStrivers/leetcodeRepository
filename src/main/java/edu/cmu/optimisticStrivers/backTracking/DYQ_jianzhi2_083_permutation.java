package edu.cmu.optimisticStrivers.backTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: DYQ_jianzhi2_083_permutation
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/8 5:33 PM
 * @Version 1.0
 */
public class DYQ_jianzhi2_083_permutation {

    //无重复元素  全排列
    //不需要sort 也不需要检查前面的元素


    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[len];
        // Arrays.sort(nums);
        Deque<Integer> deque = new ArrayDeque<>();
        backtracking(res, deque, nums, 0, visited, len);
        return res;
    }

    public void backtracking(List<List<Integer>> res, Deque<Integer> deque, int[] nums, int i, boolean[] visited, int len) {
        if (deque.size() == len) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int j = 0; j < len; j++) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            deque.add(nums[j]);
            backtracking(res, deque, nums, j + 1, visited, len);
            deque.pollLast();
            visited[j] = false;
        }

    }
}
