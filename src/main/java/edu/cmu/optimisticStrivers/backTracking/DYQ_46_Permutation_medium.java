package edu.cmu.optimisticStrivers.backTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: DYQ_46_Permutation_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/26 7:25 下午
 * @Version 1.0
 */
public class DYQ_46_Permutation_medium {

    public static void a(){

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        dfs(res,path,n,0,used,nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int size, int depth, boolean[] used, int[] nums) {
        if(depth==size) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < size; i++) {
            if(used[i]) continue;
            used[i] = true;
            path.addLast(nums[i]);
            dfs(res,path,size,depth+1,used,nums);
            path.removeLast();
            used[i] = false;
        }
    }

}
