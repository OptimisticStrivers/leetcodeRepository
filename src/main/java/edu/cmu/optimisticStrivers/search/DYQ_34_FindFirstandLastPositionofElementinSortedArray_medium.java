package edu.cmu.optimisticStrivers.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DYQ_34_FindFirstandLastPositionofElementinSortedArray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/23 7:09 下午
 * @Version 1.0
 */
public class DYQ_34_FindFirstandLastPositionofElementinSortedArray_medium {

    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1,-1};
        range[0] = searchRes(nums,target,true);
        range[1] = searchRes(nums,target,false);
        return range;
    }
//     3 4 4

    public int searchRes(int[] nums,int target,boolean isleft){
        int res = -1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(target < nums[mid]){
                right = mid-1;
            }else if(target > nums[mid]){
                left = mid +1;
            }else{
                res = mid;
                //这种找边界和严格二分查找的区别就是，找到也不要停下来，要往两边扩，直到扩不下去
                if(isleft){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        Integer[] a = {1,3};
        list.add(Arrays.asList(a));

    }

}
