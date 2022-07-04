package edu.cmu.optimisticStrivers.sort;

import java.util.ArrayList;
import java.util.List;

public class DYQ_bucketSort {


//    https://blog.csdn.net/qq_35344198/article/details/107378626
//    桶排序（Bucket sort）是计数排序算法的升级版，将数据分到有限数量的桶子里，然后每个桶再分别排序

    public static void main(String[] args) {
        DYQ_bucketSort dyq_bucketSort = new DYQ_bucketSort();
        int[] target = {8, 11, 13, 19, 26, 27, 34, 38};
        dyq_bucketSort.bucketSort(target);

        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
    }


    public int[] bucketSort(int[] target) {

        //找到最大值和最小值  以及极差
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < target.length; i++) {
            max = Math.max(max, target[i]);
            min = Math.min(min, target[i]);
        }
        int diff = max - min;

        int bucketNum = 5;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < target.length; i++) {
            int index = (target[i] - min) * bucketNum / diff;
            if (index == bucketNum) {
                index = bucketNum - 1;
            }
            list.get(index).add(target[i]);
        }
        int[] res = new int[target.length];
        for (int i = 0; i < bucketNum; i++) {
            int[] temp = innerSort(list.get(i));
            for (int j = 0; j < temp.length; j++) {
                res[j] = temp[j];
            }
        }
        return res;
    }

    public int[] innerSort(List<Integer> list) {
        int size = list.size();
        int[] target = new int[size];
        for (int i = 0; i < size; i++) {
            target[i] = list.get(i);
        }
        quickSort(target, 0, target.length - 1); //桶排序核心还是划分，所以这里sort不用快排这么快的也可以
        return target;
    }

    public void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = nums[begin];
        int l = begin;
        int r = end;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
        }
        nums[begin] = nums[l];
        nums[l] = pivot;
        quickSort(nums, l + 1, end);
        quickSort(nums, begin, l - 1);
    }

}
