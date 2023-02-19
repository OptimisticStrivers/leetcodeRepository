package edu.cmu.optimisticStrivers.backTracking;

import java.util.*;

/**
 * @ClassName: DYQ_90_Subsets2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/29 6:55 下午
 * @Version 1.0
 */
public class DYQ_90_Subsets2_medium {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int n = nums.length;
        Arrays.sort(nums);
        dfs(res, path, nums, n, 0, true);
        return res;
    }

    private static void dfs(List<List<Integer>> res, Deque<Integer> path, int[] nums, int n, int start, boolean newDepth) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < n; i++) {
            if (!newDepth && i > 0 && nums[i] == nums[i - 1]) continue;
            path.addLast(nums[i]);
            dfs(res, path, nums, n, i + 1, true);
            path.removeLast();
            newDepth = false;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2};
        subsetsWithDup(a);
    }


    // 90 子集2
    // 与子集1不一样的是，原始数组里面可以有相同的数字

    public List<List<Integer>> subsetsWithDup1(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(); // 空集是所有集合的子集
        getSubSet(res, 0, temp, nums);
        return res;
    }

    private void getSubSet(List<List<Integer>> res, int start, List<Integer> temp, int[] nums) {
        res.add(new ArrayList<>(temp)); // 先把上次的子集temp加入结果集res里,注意这里千万不可以传引用
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue; // 跳过相同的元素,和上个数字相等，就跳过
            }
            temp.add(nums[i]);
            getSubSet(res, i + 1, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
