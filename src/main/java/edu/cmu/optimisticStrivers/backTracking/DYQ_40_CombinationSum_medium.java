package edu.cmu.optimisticStrivers.backTracking;

import java.util.*;

/**
 * @ClassName: DYQ_40_CombinationSum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/31 9:05 上午
 * @Version 1.0
 */
public class DYQ_40_CombinationSum_medium {
//    给定一个候选人编号的集合
//    candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
//    candidates中的每个数字在每个组合中只能使用一次。


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, path, 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> path, int currentSum, int start) {
        if (currentSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (currentSum + candidates[i] > target) return; //剪枝
            //注意这里大于start是非常秒的，同一层的时候，用过的不可以再用了
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            path.addLast(candidates[i]);
            // dfs 里面 start 是 i+1， 因为选过的在下一层不可以再选，但是不同index相同数字在下一层还是可以用的。
            dfs(candidates, target, res, path, currentSum + candidates[i], i + 1);
            path.removeLast();
        }
    }


}
