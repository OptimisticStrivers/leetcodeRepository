package edu.cmu.optimisticStrivers.array;

/**
 * @ClassName: DYQ_908_smallestRange1_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/22 5:49 下午
 * @Version 1.0
 */
public class DYQ_908_smallestRange1_easy {

//    public xxxx(int[] nums){
//
//
//    }


    //pure math
    public static int smallestRangeI(int[] nums, int k) {

//        int small = 0;
        int small = nums[0]; //初始化什么时候是0，什么时候是首元素/随便一个元素？？？
        int big = nums[0];
        for (int i = 0; i < nums.length; i++) {
            small = Math.min(small,nums[i]);
            big = Math.max(big,nums[i]);
        }


        System.out.println(small+":"+big);
//        if(big-k<small+k){
//            return 0;
//        }else{
//            return big-small-2*k;
//        }

        return big-k<small+k   ?   0   :   big-small-2*k;
    }

    public static void main(String[] args) {
        smallestRangeI(new int[]{1,3,4,89,2,3},3);
    }
}
