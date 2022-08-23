package edu.cmu.optimisticStrivers;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_229_majorityElement2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/5 10:54 AM
 * @Version 1.0
 */
public class DYQ_229_majorityElement2_medium {


//    Could you solve the problem in linear time and in O(1) space
    // 用哈希表 肯定可以 但是会超 O1 空间复杂度

    //正确做法 摩尔投票法
//    如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
//    如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；
//    如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。
//    所以以后碰到这样的问题，而且要求达到线性的时间复杂度以及常量级的空间复杂度，直接套上摩尔投票法。
//    https://leetcode.cn/problems/majority-element-ii/solution/liang-fu-dong-hua-yan-shi-mo-er-tou-piao-fa-zui-zh/

//    所以摩尔投票法分为两个阶段：抵消阶段和计数阶段。

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        //大于1/3选票 最多有两个candidate 所以先摘出来
        int candidate1 = nums[0], count1 = 0;
        int candidate2 = nums[0], count2 = 0;

        for (int num : nums) {
            if (num == candidate1) { //即使 一开始初始化的 两个candidate相同也没事 因为count1 count2 一开始都是0
                count1++;
                continue;
            }
            if (num == candidate2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                candidate1 = num; //切换candidate
                count1++;
                continue;
            }
            if (count2 == 0) {
                candidate2 = num;
                count2++;
                continue;
            }
            //没有命中 预先的 两个candidate 且两个candidate还有余票可以被抵消
            count1--;
            count2--;
        }


        //第二阶段 检验两个candidate 是否合法
        count1 = 0;
        count2 = 0;
        //这样写不太好
        // 输入：
        //[1]
        //输出：
        //[1,1]
        //预期结果：
        //[1]
//        for (int num : nums) {
//            if(num == candidate1) count1++;
//            if(num == candidate2) count2++;
//        }

        for (int num : nums) {
            if(num == candidate1){
                count1++;
                continue;
            }
            if(num == candidate2) count2++;
        }
        if(count1 > nums.length/3) res.add(candidate1);
        if(count2 > nums.length/3) res.add(candidate2);
        return res;
    }




}
