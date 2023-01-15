package edu.cmu.optimisticStrivers.sort.quickSelect;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: DYQ_jianzhi40_getKLeastNumbers_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/5 6:02 PM
 * @Version 1.0
 */
public class DYQ_jianzhi40_getKLeastNumbers_easy {


//    https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/

    //method1 sort
    public int[] getLeastNumbers1(int[] arr, int k) {
//        如果想要降序，Arrays.sort(scores,Collections.reverseOrder());。
//        首先要注意的是不能用int这个类型了，要用Integer，不能使用基本类型（int,double, char），如果是int型需要改成Integer，float要改成Float
//        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.sort(arr);
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }


    //method2 heap
    //只能用 大顶堆 想想为啥
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]); //放k个
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) { //一定能更新
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll(); //这个return 结果里的顺序无所谓
        }
        return vec;
    }

//    https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/jian-zhi-offer-40-zui-xiao-de-k-ge-shu-j-9yze/
    //利用 快速排序 O(n) 时间复杂度

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int k, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            while (i < j && arr[i] <= pivot) i++;
            swap(arr, i, j);
        }
        swap(arr, left, i); //index为k 前面的k个都是 k least
        if (i > k) return quickSort(arr, k, left, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, right);
        return Arrays.copyOf(arr, k);
    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
