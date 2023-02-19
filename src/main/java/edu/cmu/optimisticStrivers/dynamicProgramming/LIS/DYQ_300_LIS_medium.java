package edu.cmu.optimisticStrivers.dynamicProgramming.LIS;

import java.util.Arrays;

/**
 * @ClassName: DYQ_300_LIS_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/14 11:25 PM
 * @Version 1.0
 */
public class DYQ_300_LIS_medium {
    //不需要连续

    //方法一 经典dp 但是 n2

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i]表示以 nums[i] 结尾的 LIS 长度
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            int maxLISofI = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { //严格
                    maxLISofI = Math.max(maxLISofI, dp[j] + 1);
                }
            }
            dp[i] = maxLISofI;
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    //方法二 dp+贪心二分 nlogn
    //tail数组 可以证明 tail是递增的
    //tail[1] 表示长度为2的所有递增序列中 最小的第二个数
//    https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-e/
//    很具小巧思。新建数组 cell，用于保存最长上升子序列。
//
//    对原序列进行遍历，将每位元素二分插入 cell 中。
//
//    如果 cell 中元素都比它小，将它插到最后
//    否则，用它覆盖掉比它大的元素中最小的那个。
//    总之，思想就是让 cell 中存储比较小的元素。这样，cell 未必是真实的最长上升子序列，但长度是对的。


//    你可以理解这是一个栈，不断的再刷栈内的内容。比如一个序列 34512456，最开始数组中存放的是345，当出现1时，更新变成145，
//    实际是用1覆盖了原有栈的内容，这样做对原有长度没有影响，但是后面就刷成了12456，你可以认为是对栈的不断刷新，
//    当栈的长度增加时就是窗口增加了。这个做法确实比较巧妙

    public int lengthOfLIS_final(int[] nums) {
        /** 二分查找 */
        // 维护一个 cell 数组（递增），遍历 nums;
        // 若当前元素 num 比 cell 中最后一个元素大，则直接将其插入 cell;
        // 否则，将 cell 中比 num 大的第一个元素替换为 num
        int size = nums.length;
        if (size < 2) return size;
        int[] arr = new int[size];
        arr[0] = nums[0];
        int res = 1; // arr数组中实际存入的值的数量，即递增子序列的长度
        for (int i = 1; i < size; i++) {
            // 若当前元素 num 比 cell 中最后一个元素大
            if (nums[i] > arr[res - 1]) {
                arr[res] = nums[i];
                res++;
                continue;
            }
            // 否则，二分查找 cell 中比 num 大的第一个元素
            int left = 0, right = res - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                // left指针最终指向的就是比 num 大的第一个元素
                if (arr[mid] >= nums[i]) { //可以相等的 替换
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            arr[left] = nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int left = 0, right = 3, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // left指针最终指向的就是比 num 大的第一个元素
            if (arr[mid] >= 4) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }


}
