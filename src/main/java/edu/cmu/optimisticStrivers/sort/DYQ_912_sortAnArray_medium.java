package edu.cmu.optimisticStrivers.sort;

/**
 * @ClassName: DYQ_912_sortAnArray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/17 10:52 上午
 * @Version 1.0
 */
public class DYQ_912_sortAnArray_medium {
    //快排的关键就是，挖坑+分治
    public int[] sortArray(int[] nums) {
//        columns(nums, 0, nums.length - 1);
        return nums;
    }
//    public void quickSort(int[] nums, int begin, int end) {
//        if (begin >= end) { //递归终止条件，非常重要
//            return;
//        }
//        int pivot = nums[begin]; //存下来基准
//        int l = begin; //必须是begin 不能begin+1
//        int r = end;
//        while (l < r) {
//            //升序排列
//            while (l < r && nums[r] >= pivot) {
//                r--; //找到第一个比pivot小的数
//            }
//            while (l < r && nums[l] <= pivot) {
//                l++;
//            }
//            //换一下这两个数字
//            int temp = nums[r];
//            nums[r] = nums[l];
//            nums[l] = temp;
//        }
//        //把基准换掉
//        nums[begin] = nums[l];
//        nums[l] = pivot;
//        quickSort(nums, l + 1, end);
//        quickSort(nums, begin, l - 1);
//    }


//    public void quickSort(int[] nums, int begin, int end) {
//        if (begin >= end) { //递归终止条件，非常重要
//            return;
//        }
//        int pivot = nums[begin]; //存下来基准
//        int l = begin + 1;
//        int r = end;
//        while (l < r) {
//            //升序排列
//            while (l < r && nums[r] >= pivot) {
//                r--; //找到第一个比pivot小的数
//            }
//            while (l < r && nums[l] <= pivot) {
//                l++;
//            }
//            //换一下这两个数字
//            int temp = nums[r];
//            nums[r] = nums[l];
//            nums[l] = temp;
//        }
//        //把基准换掉
//        if (nums[l] < pivot) {
//            nums[begin] = nums[l];
//            nums[l] = pivot;
//        }
//        quickSort(nums, l + 1, end);
//        quickSort(nums, begin, l - 1);
//    }


//    //用for 粗略划分，比他小的在左，比他大和等于的在右
//    public void quickSort(int[] nums, int begin, int end) {
//        if (begin >= end) { //递归终止条件，非常重要
//            return;
//        }
//        int pivot = nums[begin]; //存下来基准
//        int l = begin; //必须是begin 不能begin+1
//        for (int r = begin + 1; r <= end; r++) {
//            if (nums[r] < pivot) { //两个小的交换
//                l++;
//                int swap = nums[r];
//                nums[r] = nums[l];
//                nums[l] = swap;
//            }
//        }
//        //l 会停在 最后一个小于pivot的点， 下一个就是大于和等于
//        nums[begin] = nums[l];
//        nums[l] = pivot;
//        quickSort(nums, l + 1, end);
//        quickSort(nums, begin, l - 1);
//    }

}
