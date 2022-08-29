package edu.cmu.optimisticStrivers.hash.inPlaceHash;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_448_findDisappearedNumbers_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/30 5:41 AM
 * @Version 1.0
 */
public class DYQ_448_findDisappearedNumbers_easy {


    //    进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
//     [1, n] 内
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            res.add(i + 1);
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == i + 1) {
//                res.remove(nums[i] - 1); 这样根据index remove肯定是不对的 要根据值 所以要转换为Integer
                res.remove(Integer.valueOf(nums[i]));
            }
            //数字不在该在的位置的话 说明 是重复的
        }
        return res;
    }


    //res.remove 超出时间限制 还是库函数不要随便调用 本来On时间复杂度 结果反而高了
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) res.add(i + 1);  //disappear就是反一下 这个位置上如果数字不对 那么原来的正确数字就是缺了
        }
        return res;
    }

    //或者不用while 用一遍for也可以 可以发现 其实还是一个隐式的while
//    遍历数组，将每个数字交换到它理应出现的位置上，下面情况不用换：
//        当前数字本就出现在理应的位置上，跳过，不用换。
//        当前数字理应出现的位置上，已经存在当前数字，跳过，不用换。
//    再次遍历，如果当前位置没对应正确的数，如上图索引 4、5，则将对应的 5、6 加入 res。
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == i + 1) { //当前数字本就出现在理应的位置上，跳过，不用换
                continue;
            }
            int idealIdx = nums[i] - 1;
            if (nums[i] == nums[idealIdx]) { //当前数字理应出现的位置上，已经存在当前数字，跳过，不用换
                continue;
            }

            int tmp = nums[i];
            nums[i] = nums[idealIdx];
            nums[idealIdx] = tmp;
            i--; //换了以后i要自己减一下 下次for才能加回来 或者直接写成大while
            //因为交换了以后，这个位置的新的数字还是不一定可以
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }
        return res;
    }

    //https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/solution/shou-hua-tu-jie-jiao-huan-shu-zi-zai-ci-kzicg/
    //其实和我们一直写的 用 for+while 的 原地hash是一个道理
    //他们这里也有隐藏的while
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            int idealIdx = nums[i] - 1;
            if (nums[i] == nums[idealIdx]) {
                i++;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[idealIdx];
            nums[idealIdx] = tmp;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        DYQ_448_findDisappearedNumbers_easy dyq_448_findDisappearedNumbers_easy = new DYQ_448_findDisappearedNumbers_easy();
        dyq_448_findDisappearedNumbers_easy.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
