package edu.cmu.optimisticStrivers.sort.quickSelect;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: DYQ_215_findKthLargest_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/5 9:15 PM
 * @Version 1.0
 */
public class DYQ_215_findKthLargest_medium {

    //method1 快排
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    //method2 heap 堆排序
    //只能用 小顶堆 想想为啥
//    根据当前队列元素个数或当前元素与栈顶元素的大小关系进行分情况讨论：
//
//    当优先队列元素不足 kk 个，可将当前元素直接放入队列中；
//    当优先队列元素达到 kk 个，并且当前元素大于栈顶元素（栈顶元素必然不是答案），可将当前元素放入队列中。

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; ++i) {
            queue.offer(nums[i]); //放k个
        }
        for (int i = k; i < nums.length; ++i) {
            if (queue.peek() < nums[i]) { //一定能更新
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll();
    }

//    public static void main(String[] args) {
//        int[] ints = new int[]{3, 2, 1, 5, 6, 4};
//        System.out.println(findKthLargest(ints, 2));
//    }


    //method3 快速选择
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int k, int left, int right) {
        int i = left;
        int j = right;
        int pivot = nums[left];
        while (i < j) {
            while (i < j && nums[j] <= pivot) j--;
            while (i < j && nums[i] >= pivot) i++;
            swap(nums, i, j);
        }
        swap(nums, left, i);
        if (i > k) return quickSort(nums, k, left, i - 1);
        if (i < k) return quickSort(nums, k, i + 1, right);
        //index k前面就是 k个最大元素 但是不知道谁是最大
        return nums[k];
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
