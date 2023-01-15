package edu.cmu.optimisticStrivers.twoPointers;

/**
 * @ClassName: DYQ_246_strobogrammatic_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/11 12:13 PM
 * @Version 1.0
 */
public class DYQ_246_strobogrammatic_easy {

    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;
        char[] nums = num.toCharArray();
        while (left <= right) {
            //满足要求的位置
            if ((nums[left] == '0' && nums[right] == '0') || (nums[left] == '1' && nums[right] == '1') ||
                    (nums[left] == '8' && nums[right] == '8') ||
                    (nums[left] == '6' && nums[right] == '9') || (nums[left] == '9' && nums[right] == '6')) {
                ++left;
                --right;
            } else {
                return false;//否则直接返回false
            }
        }
        return true;
    }
}
