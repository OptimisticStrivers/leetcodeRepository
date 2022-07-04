package edu.cmu.optimisticStrivers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DYQ_219_containsDuplicate2_easy {

//    Input: nums = [1,2,3,1], k = 3
//    Output: true

//    Input: nums = [1,2,3,1,2,3], k = 2
//    Output: false

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }


    //滑动窗口
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            while(right-left>k){
                set.remove(nums[left++]);
            }
            if(!set.add(nums[right])){ //加不进去 说明已经有了
                return true;
            }
        }
        return false;
    }

    //官方的滑动窗口
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
