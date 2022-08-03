package edu.cmu.optimisticStrivers.examQuestions;

/**
 * @ClassName: DYQ_20220326_Douyin1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/26 9:28 上午
 * @Version 1.0
 */
public class DYQ_20220326_Douyin1 {


    //数组 1 3 4 6 7 9 10 ,有序
    //给你的是 旋转后的， 7 9 10 1 3 4 6 7
    //让你找到原来数组的中位数，偶数要/2

    //二分，先找到最大的那个数的位置，再用长度算中位数

    public static void main(String[] args) {

        // 1 3 4 6 7 7 9 10
//        int[] nums = {7, 9, 10, 1, 3, 4, 6, 7};
//        int[] nums = {9, 10, 20, 7, 7, 7, 7, 7, 7, 7, 8};
        int[] nums = {8, 9, 7, 7, 7, 7, 7, 7, 7, 8, 8};

        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int max = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[l]) { //现在这个数小的话，说明10这个最大的数一定在左边
                r = mid - 1;
            } else { // 大于等于的话，当前的mid可能是10这个最大的数，但是最大的数还是又可能在右边
                if(mid == l){ //只有当前区间有两个元素或者一个元素的时候，mid 才会 等于 l， 为了避免死循环，比较元素
                    max = nums[r] < nums[l] ? l : r;
                    break;
                }
                l = mid;
            }
        }
        // l 当max == -1
        // 当max != -1, max
        max = max==-1? l : max;
        System.out.println(nums[max]);
    }


//    public void
}
