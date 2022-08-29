package edu.cmu.optimisticStrivers.hash.inPlaceHash;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_442_findDuplicates_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/30 5:39 AM
 * @Version 1.0
 */
public class DYQ_442_findDuplicates_medium {

//    给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
//    且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
//    你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。

//    输入：nums = [4,3,2,7,8,2,3,1]
//    输出：[2,3]


    //[1,n]的话，就都往前移一格，因为index要满足0开始
    //个人感觉比三叶的好一些
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        List<Integer> res = new ArrayList<>();
        //警示 内置函数 可能在大的usecase下 提高时间复杂度
//        for (int i = 0; i < len; i++) {
//            if (!res.contains(nums[i]) && nums[i] != i + 1) { 没必要用contains的话 跑不出来 因为复杂度太高
//                res.add(nums[i]);
//            }
//        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) { //因为题里面说 重复元素 重复次数最多两次 所以 有一个在正确的位子上 另一个就会被检查到
                res.add(nums[i]);
            }
        }
        return res;
    }

    //还是while的这种写法 时间有点长 想办法中途给他截停掉
    public List<Integer> findDuplicates1(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
            for (int j = 0; j < len; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
            //跳出循环 可能是 当前nums[i] 是正确的数字 nums[i] == i + 1
            //也可能是 当前数字 和 其应该在的位置上的数字相同 这种情况 直接 加入res
            //注意 这两个index 不能相同
            if (nums[i] == nums[nums[i] - 1] && i != nums[i] - 1 && !res.contains(nums[i])) {
                System.out.println(nums[i] + " " + nums[nums[i] - 1]);
                res.add(nums[i]);
            }

        }

        return res;
    }

    //三叶  负号处理很棒  但是真的不好理解
    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) { //遍历一遍就可以
            int t = nums[i];
            if (t < 0 || t - 1 == i) continue; //t-1==i 说明当前数字t就在他应该在位置
            if (nums[t - 1] == t) { //如果t要换到的位置 的数字 也是 t -> 说明重复了
                ans.add(t);
                nums[i] *= -1; //这个位置被处理过了 不用管了
            } else { //没重复 t换到该在的地方
                int c = nums[t - 1];
                nums[t - 1] = t;
                nums[i--] = c;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        DYQ_442_findDuplicates_medium dyq_442_findDuplicates_medium = new DYQ_442_findDuplicates_medium();
        System.out.println(dyq_442_findDuplicates_medium.findDuplicates1(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
//        System.out.println(dyq_442_findDuplicates_medium.findDuplicates(new int[]{1,1,2}));

    }


}
