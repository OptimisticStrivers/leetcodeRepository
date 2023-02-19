package edu.cmu.optimisticStrivers.dynamicProgramming.LIS;

import java.util.*;

/**
 * @ClassName: DYQ_491_findAllLIS_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/15 12:01 PM
 * @Version 1.0
 */
public class DYQ_491_findAllLIS_medium {

//    491. 递增子序列 由于需要找到所有的递增子序列，因此动态规划就不行了，妥妥回溯就行了，套一个模板就出来了。回溯的模板可以看我之前写的回溯专题。
//    这个题 去重注意一下

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 1) {
            return res;
        }
//        Set<>
        dfs(res, nums, 0, new LinkedList<Integer>()); //nums[i]必在
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, int start, LinkedList<Integer> path) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        //这个for循环代表 以 i为起点的 递增序列
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
//            if (i > start && nums[i] == nums[i - 1]) {
            if (set.contains(nums[i])) {
                //问题应该就出在“去重”上，用简单一点的输入[1,2,3,1,1,1,1] 方法：第一层 后面的四个1在第二层的时候只有一个能和第一层的1组合
                // 测试下就能看到区别。用nums[i]==nums[i-1]方式的前提是数据已经排好序，但是这个题的数据是固定的且不一定有序，所以“去重”方式要改动。
                continue;//去重
            }
            if (!path.isEmpty() && path.getLast() > nums[i]) {
                continue;
            }
            path.addLast(nums[i]);
            set.add(nums[i]);
//            System.out.println(start + "  " + i + " : " + path);
            dfs(res, nums, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{1, 6, 6}));
    }

}
