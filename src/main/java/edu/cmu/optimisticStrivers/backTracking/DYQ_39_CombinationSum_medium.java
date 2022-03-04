package edu.cmu.optimisticStrivers.backTracking;

import java.util.*;

/**
 * @ClassName: DYQ_39_CombinationSum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/31 8:39 上午
 * @Version 1.0
 */
public class DYQ_39_CombinationSum_medium {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates,target,res,path,0,0);
        return res;
    }

    //剪枝当然是好的！！！
    private void dfs(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> path, int currentSum, int start) {
        if(currentSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        //这个剪枝没啥用，因为下面的已经剪了
//        if(currentSum > target){
//            return; //剪枝
//        }

        for (int i = start; i < candidates.length; i++) {
            if(currentSum+candidates[i]>target) return; //剪枝
            path.addLast(candidates[i]);
            // dfs 里面 start 是 i， 因为选过的可以再选
            dfs(candidates,target,res,path,currentSum+candidates[i],i);
            path.removeLast();
        }
    }
}
