package edu.cmu.optimisticStrivers.sort;

import java.util.ArrayList;
import java.util.List;

public class DYQ_bucketSort {

//    排序算法的稳定性，通俗地讲就是能保证排序前2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序相同。
//
//    在简单形式化一下，如果Ai = Aj, Ai原来在位置前，排序后Ai还是要在Aj位置前。
//
//    稳定性的好处。排序算法如果是稳定的，那么从一个键上排序，然后再从另一个键上排序，第一个键排序的结果可以为第二个键排序所用，
//    以其为基础。基数排序就是这样，先按低位排序，逐次按高位排序，低位相同的元素其顺序再高位也相同时是不会改变的。
//    另外，如果排序算法稳定，对基于比较的排序算法而言，元素交换的次数可能会少一些。
//
//    常见的稳定排序算法：冒泡排序，插入排序，基数排序，归并排序



//    https://blog.csdn.net/qq_35344198/article/details/107378626
//    桶排序（Bucket sort）是计数排序算法的升级版，将数据分到有限数量的桶子里，然后每个桶再分别排序

    public static void main(String[] args) {
        DYQ_bucketSort dyq_bucketSort = new DYQ_bucketSort();
        int[] target = {1, -1, 2, 9, 5, 1, 4};

        int[] ints = dyq_bucketSort.bucketSort(target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }

        //        int[] ints = dyq_bucketSort.bucketSort(new int[]{1, -1, 2, 9, 5, 1, 4});
//        int[] ints = dyq_bucketSort.bucketSort(new int[]{2,1});
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
        int count = 0;
        for (int i = 0; i < bucketNum; i++) {
            int[] temp = innerSort(list.get(i));
            for (int j = 0; j < temp.length; j++) {
                res[count++] = temp[j];
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
