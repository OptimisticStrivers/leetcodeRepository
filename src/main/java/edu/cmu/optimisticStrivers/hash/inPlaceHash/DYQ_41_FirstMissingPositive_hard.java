package edu.cmu.optimisticStrivers.hash.inPlaceHash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: DYQ_41_FirstMissingPositive_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/30 3:25 AM
 * @Version 1.0
 */
public class DYQ_41_FirstMissingPositive_hard {


    // O(n) time and uses constant extra space.

    //hash表的话 肯定空间复杂度高 虽然时间复杂度是On
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= len; i++) { //从1开始到len+1 都是可能结果
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return len + 1;  //[1] 的预期结果 应该是 2
    }


    //排序然后再从1开始二分查找
    //时间复杂度：O(NlogN)，这里 NN 表示数组的长度。时间复杂度主要消耗在排序上，排序使用 O(NlogN)。
    //二分查找使用每一步使用的时间复杂度是 O(logN)，整体上仍然是 O(NlogN)
    //空间复杂度：O(1)

    public int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            int res = binarySearchNums(nums, i);
            if (res == -1) return i;
        }
        return len + 1; //1到len 都有的话 就是len+1喽
    }

    private int binarySearchNums(int[] nums, int i) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > i) {
                right = mid - 1;
            } else if (nums[mid] < i) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //其实这里不二分也可以 直接排序以后找突变的元素就行
    public int firstMissingPositive2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] == pre) continue;
            //跳过负数和0 //当然也要跳过重复的元素 不能让pre这个计数器变多次
            if (nums[i] != ++pre) {
                return pre;
            }
        }
        //如果都没有return 说明这时候pre 等于 len
        return pre + 1; //len+1
    }


    //核心就是 把能换的 nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]
    // 换到 他该到的位置
    // 最后剩下的 所有其他位置 最小的+1就是 缺失的最小正整数
    //https://leetcode.cn/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
    //"原地哈希" 这个思想就相当于我们自己编写哈希函数，这个哈希函数的规则特别简单，那就是数值为 i 的数映射到下标为 i - 1 的位置。
    public int firstMissingPositive3(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //hash 换位 过一遍
            //这里必须是while 因为换了一次以后 i确实换到nums[i]-1这个位置了
            //但是现在的i可能还是可以换的 那么也需要换到 nums[i]-1这个新位置
            //为了防止死循环 就是两个位置的数字不能一样 一样的话 就会一直换下去
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) { //nums[i]合法的话 是最大能取到len的
//                if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) { //nums[i]合法的话 是最大能取到len的
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }

    public static void main(String[] args) {
        DYQ_41_FirstMissingPositive_hard dyq_41_firstMissingPositive_hard = new DYQ_41_FirstMissingPositive_hard();
//        System.out.println(dyq_41_firstMissingPositive_hard.binarySearchNums(new int[]{0, 1, 2}, 3));

        dyq_41_firstMissingPositive_hard.firstMissingPositive3(new int[]{3, 4, -1, 1});

    }
}
