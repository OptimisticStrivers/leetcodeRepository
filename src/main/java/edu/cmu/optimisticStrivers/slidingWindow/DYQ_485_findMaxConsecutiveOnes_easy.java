package edu.cmu.optimisticStrivers.slidingWindow;

/**
 * @ClassName: DYQ_485_findMaxConsecutiveOnes_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/15 10:33 上午
 * @Version 1.0
 */
public class DYQ_485_findMaxConsecutiveOnes_easy {

    //滑动窗口
    // public int findMaxConsecutiveOnes(int[] nums) {
    //     int left = 0, right = 0;
    //     int res = 0;
    //     while(right<nums.length){
    //          if(nums[right] == 0){
    //              res = Math.max(res,right-left);
    //              left = right+1;
    //          }
    //         right++;
    //     }
    //     res = Math.max(right-left, res);
    //     return res;
    // }

    //一次遍历
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cur = 0 ;
        for(int i = 0; i<nums.length; i++){
            cur += nums[i];
            if(nums[i]==0){
                res = Math.max(res,cur);
                cur = 0;
            }
        }
        res = Math.max(res,cur); //不是0结尾的话
        return res;
    }


    //字符串分割
}
