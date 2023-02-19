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
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        List<List<Integer>> res = new ArrayList<>();
//        Deque<Integer> path = new ArrayDeque<>();
//        Arrays.sort(candidates);
//        dfs(candidates,target,res,path,0,0);
//        return res;
//    }
//
//    //剪枝当然是好的！！！
//    private void dfs(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> path, int currentSum, int start) {
//        if(currentSum == target) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        //这个剪枝没啥用，因为下面的已经剪了
////        if(currentSum > target){
////            return; //剪枝
////        }
//
//        for (int i = start; i < candidates.length; i++) {
//            if(currentSum+candidates[i]>target) return; //剪枝
//            path.addLast(candidates[i]);
//            // dfs 里面 start 是 i， 因为选过的可以再选
//            dfs(candidates,target,res,path,currentSum+candidates[i],i);
//            path.removeLast();
//        }
//    }

    //题目已经保证了 candidates 里面的数字不同

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
//        Arrays.sort(candidates); 这个无所谓 因为这道题 candidates里面的元素都是唯一
        dfs(res, candidates, 0, target, stack, 0 );
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int curSum, int target, Stack<Integer> stack, int begin) {
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<>(stack));  //需要硬拷贝 不能软拷贝
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            stack.push(candidates[i]);
            dfs(res, candidates, curSum + candidates[i], target, stack, i);
            stack.pop();
        }
    }

}
