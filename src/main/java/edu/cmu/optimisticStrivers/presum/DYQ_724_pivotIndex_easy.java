package edu.cmu.optimisticStrivers.presum;

/**
 * @ClassName: DYQ_724_pivotIndex_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 4:12 下午
 * @Version 1.0
 */
public class DYQ_724_pivotIndex_easy {

//    寻找数组的中心下标


    //理解了我们前缀和的概念（不知道好像也可以做，这个题太简单了哈哈）。我们可以一下就能把这个题目做出来，
    // 先遍历一遍求出数组的和，然后第二次遍历时，直接进行对比左半部分和右半部分是否相同，如果相同则返回 true，不同则继续遍历


    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(leftSum == sum-nums[i]-leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


}

