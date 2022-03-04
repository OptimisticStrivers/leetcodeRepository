package edu.cmu.optimisticStrivers.backTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: DYQ_78_Subsets_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/29 6:22 下午
 * @Version 1.0
 */
public class DYQ_78_Subsets_medium {

    //回溯1
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int n = nums.length;
        dfs(res,path,n,0,0,nums);
        return res;
    }
    public void dfs(List<List<Integer>> res, Deque<Integer> path, int n, int depth, int index, int[] nums){
        res.add(new ArrayList<>(path));
        if(depth==n){
            return;
        }
        for (int j = 0; j < n ; j++) {
            if(j<index){
                continue;
            }
            path.addLast(nums[j]);
            dfs(res,path,n,depth+1,j+1,nums);
            path.removeLast();
        }
    }


    //回溯2
    public List<List<Integer>> subset2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs2(res, path, nums, 0);
        return res;
    }

    public void dfs2(List<List<Integer>> res, List<Integer> path, int[] nums, int start) {
        res.add(new ArrayList<Integer>(path)); // 注意，要复制，不能直接给引用
        if (start >= nums.length) { // 可有可无，分析下
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs2(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    //追加
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1 << nums.length); // 参数是initialCapacity
        // 空集是所有集合的子集，先加进去，也作为以后追加的起点
        res.add(new ArrayList<Integer>());
        // 每遍历一个元素，就把之前的子集全部复制再追加新元素
        for (int i = 0; i < nums.length; i++) {
            // for(int j = 0 ; j<res.size(); j++) { // List的length用的是size
            for (int j = 0, k = res.size(); j < k; j++) {
                // 复制一个新的
                List<Integer> newList = new ArrayList<>(res.get(j)); // 这个参数就不是initialCapacity，是Collection
                // 再追加
                newList.add(nums[i]);
                res.add(newList);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        list1.add( list0);
        list1.add( new ArrayList<>(list0));
        System.out.println(list1.size());
        list1.get(0).remove(0);

        System.out.println(list1.get(1).get(0));
    }
}
