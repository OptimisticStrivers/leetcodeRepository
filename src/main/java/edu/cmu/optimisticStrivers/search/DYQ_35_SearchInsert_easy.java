package edu.cmu.optimisticStrivers.search;

/**
 * @ClassName: DYQ_35_SearchInsert_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/8 8:28 下午
 * @Version 1.0
 */
public class DYQ_35_SearchInsert_easy {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        //为什么必须有等号，比如2，3，4 找 target
        while(low<=high){
            int mid = (low+high)/2;
            int num = nums[mid];
            if(num<target){
                low=mid+1;
            }else if(num>target){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return high+1;
        // if(high<0) return 0;
        // if(low==nums.length) return low;
        // return  target>nums[high]?low:high;
    }
}
