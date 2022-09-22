package edu.cmu.optimisticStrivers.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_228_SummaryRanges_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/1 2:04 PM
 * @Version 1.0
 */
public class DYQ_228_SummaryRanges_easy {


    //汇总区间
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int begin = 0, end = 1;
        while (end < nums.length) {
            if (nums[end] != nums[end - 1] + 1) {
                if (end - begin == 1) {
                    res.add(String.valueOf(nums[begin]));
                } else {
                    res.add(nums[begin] + "->" + nums[end - 1]);
                }
                begin = end;
            }
            end++;
        }
        if (begin == nums.length - 1) {
            res.add(String.valueOf(nums[begin]));
        } else {
            res.add(nums[begin] + "->" + nums[nums.length - 1]);
        }
        return res;
    }



}
