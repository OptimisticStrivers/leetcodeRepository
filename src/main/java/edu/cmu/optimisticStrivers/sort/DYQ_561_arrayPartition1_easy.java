package edu.cmu.optimisticStrivers.sort;

public class DYQ_561_arrayPartition1_easy {


    public static void main(String[] args) {
        DYQ_561_arrayPartition1_easy dyq_561_arrayPartition1_easy = new DYQ_561_arrayPartition1_easy();
        System.out.println(dyq_561_arrayPartition1_easy.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));

    }

    public int arrayPairSum(int[] nums) {
//        让接近的放成一个pair
        quickSort(nums, 0, nums.length - 1);
        //升序
        //从后往前 先救下大的
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            res += Math.min(nums[i], nums[i - 1]);
            i--;
        }
        return res;
    }


    public void quickSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }

        int pivot = nums[i];
        int begin = i;
        int end = j;

        while (begin < end) {
            while (begin < end && nums[end] >= pivot) {
                end--;
            }
            while (begin < end && nums[begin] <= pivot) {
                begin++;
            }
            int swap = nums[begin];
            nums[begin] = nums[end];
            nums[end] = swap;
        }

        nums[i] = nums[begin];
        nums[begin] = pivot;

        quickSort(nums, begin + 1, j);
        quickSort(nums, i, begin - 1);

    }
}
