package edu.cmu.optimisticStrivers.array;

import java.util.Arrays;

/**
 * @ClassName: DYQ_910_smallestRange2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/22 6:05 下午
 * @Version 1.0
 */
public class DYQ_910_smallestRange2_medium {

    public int smallestRangeII(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums); //从小到大的顺序。
        int max = nums[0];
        int min = nums[0];
        //不切刀的特殊情况,即整体上移或者下移，或者也可理解为刀在-1或者len-1
        int answer = nums[len - 1] - nums[0];

        //切刀，注意刀口的位置，i是被切到左边的，因此最后一刀是在len-2
        for (int i = 0; i < len-1; i++) {
            max = Math.max(nums[i] + k, nums[len - 1] - k);
            min = Math.min(nums[0] + k, nums[i + 1] - k);
            answer = Math.min(answer, max-min);
        }
        return answer;
    }


    //Arrays.sort复习

//    1.Arrays.sort(int[] a) //小到大
//    2.Arrays.sort(int[] a, int fromIndex, int toIndex) //前闭后开
//    3.public static void sort(T[] a,int fromIndex,int toIndex, Comparator c)

    //Comparator是一个接口，所以这里我们自己定义的类MyComparator要implents该接口
    //而不是extends Comparator
    // class MyComparator implements Comparator<Integer>{
    // @Override
    // public int compare(Integer o1, Integer o2) {
    // 如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值，
    //这样颠倒一下，就可以实现反向排序了
    // if(o1 < o2) { //后面的比前面的大，就换，不就是从大到小
    // return 1;
    // }else if(o1 > o2) {
    // return -1;}
    // else {
    // return 0;
    // }
    // }


}
