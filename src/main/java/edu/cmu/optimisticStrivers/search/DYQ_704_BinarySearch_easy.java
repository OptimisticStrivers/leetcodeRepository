package edu.cmu.optimisticStrivers.search;
/**
 * @ClassName: DYQ_704_BinarySearch_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/23 6:49 下午
 * @Version 1.0
 */
public class DYQ_704_BinarySearch_easy {
    //和35题差不多

    //二分的前提是有序
    //部分有序题

    //divide and conquer

//     1 2 2
//       0 1 2
    public int search(int[] nums, int target) {
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
        return -1;
    }

}
