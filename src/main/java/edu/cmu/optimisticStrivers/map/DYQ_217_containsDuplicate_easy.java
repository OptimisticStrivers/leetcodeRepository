package edu.cmu.optimisticStrivers.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: DYQ_217_containsDuplicate_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/24 2:14 AM
 * @Version 1.0
 */
public class DYQ_217_containsDuplicate_easy {

    //排序
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == before){
                return true;
            }
            before = nums[i];
        }
        return false;
    }


    //set去重
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> res = new HashSet<Integer>();
        for(int i:nums)
            res.add(i);
        return res.size()<nums.length?true:false;
    }


    //哈希表
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }



}
