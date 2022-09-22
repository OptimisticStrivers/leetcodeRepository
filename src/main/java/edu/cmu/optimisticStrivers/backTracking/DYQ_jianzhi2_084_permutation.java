package edu.cmu.optimisticStrivers.backTracking;

import java.util.*;

/**
 * @ClassName: DYQ_jianzhi2_084_permutation
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/8 4:48 PM
 * @Version 1.0
 */
public class DYQ_jianzhi2_084_permutation {

//    剑指 Offer II 084. 含有重复元素集合的全排列
//    给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。


    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[len];
        Arrays.sort(nums);
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
            //第三个条件必须有，只有前面的一个没有被用过，你才比前后。前面的被用过的时候，后面的即时一样也可以用
            if (j > 0 && nums[j - 1] == nums[j] && visited[j-1]) {
                continue;
            }

            visited[j] = true;
            deque.add(nums[j]);
            backtracking(res, deque, nums, j + 1, visited, len);
            deque.pollLast();
            visited[j] = false;
        }

    }


    public static void main(String[] args) {
        DYQ_jianzhi2_084_permutation dyq_jianzhi2_084_permutation = new DYQ_jianzhi2_084_permutation();
        dyq_jianzhi2_084_permutation.permuteUnique(new int[]{
                1, 1, 2});
    }
}
