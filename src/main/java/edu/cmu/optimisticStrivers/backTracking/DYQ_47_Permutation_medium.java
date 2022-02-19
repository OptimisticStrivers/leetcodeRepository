package edu.cmu.optimisticStrivers.backTracking;

import java.util.*;

/**
 * @ClassName: DYQ_47_Permutation_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/26 7:46 下午
 * @Version 1.0
 */
public class DYQ_47_Permutation_medium {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums); //默认是升序
        int size = nums.length;
        boolean[] used = new boolean[size];
        dfs(res, path, size, 0, used, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int size, int depth, boolean[] used, int[] nums) {
        if (depth == size) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < size; i++) {
//            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {1
            if (i > 0 && nums[i] == nums[i - 1] ) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(res, path, size,depth+1,used,nums);
                // 回退
                used[i] = false;
                path.removeLast();
            }
        }
    }


}
