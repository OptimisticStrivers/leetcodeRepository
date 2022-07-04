package edu.cmu.optimisticStrivers;

import java.util.TreeSet;

public class DYQ_220_containsDuplicate3_meduim {

//    Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array
//    such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.


//    https://leetcode.cn/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/

    //红黑树   这个重点理解
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

//        简单采用 AVL 树，会导致每次的插入删除操作都触发 AVL 的平衡调整，一次平衡调整会伴随着若干次的旋转。
//        而红黑树则很好解决了上述问题：将平衡调整引发的旋转的次数从「若干次」限制到「最多三次」。
//        因此，当「查询」动作和「插入/删除」动作频率相当时，更好的选择是使用「红黑树」。

        int n = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            Long up = treeSet.ceiling(u);
            Long down = treeSet.floor(u);
            if(up!=null && Math.abs(up-u)<=t) return true;
            if(down!=null && Math.abs(down-u)<= t) return true;
            treeSet.add(u);
            if(i-k>=0){ //等于0不可
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }


    //桶排序








}
