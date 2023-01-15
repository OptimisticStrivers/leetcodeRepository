package edu.cmu.optimisticStrivers.array;

/**
 * @ClassName: DYQ_283_moveZeros_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 5:40 PM
 * @Version 1.0
 */
public class DYQ_283_moveZeros_easy {

//    你能尽量减少完成的操作次数吗？

    //如果要减少操作次数 即
    //遍历数组，遇到非0数，前面有几个0就往前面移动几格

    public void moveZeroes_final(int[] nums) {
        int n=nums.length;
        int t=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                ++t;
            }else{
                nums[i-t]=nums[i];
            }
        }
        for(int i=n-1;i>n-t-1;--i){
            nums[i]=0;
        }
    }



    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        while(true){
            while(zeroIndex<nums.length && nums[zeroIndex]!=0){ //先找到0
                zeroIndex++;
            }
            nonZeroIndex = zeroIndex + 1;
            while(nonZeroIndex<nums.length && nums[nonZeroIndex] == 0 ){
                nonZeroIndex++;
            }
            if(zeroIndex < nums.length && nonZeroIndex < nums.length){
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[zeroIndex];
                nums[zeroIndex] = temp;
            }
            if(zeroIndex == nums.length || nonZeroIndex == nums.length){
                return;
            }
        }

    }
}
