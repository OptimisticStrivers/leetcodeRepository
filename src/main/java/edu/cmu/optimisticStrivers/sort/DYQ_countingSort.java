package edu.cmu.optimisticStrivers.sort;

public class DYQ_countingSort {

//    https://blog.csdn.net/qq_35344198/article/details/107206269
//    计数排序，典型的空间换时间， 有点像桶排序的前生
//    计数排序有三个阶段，1：普通版  2：优化额外空间temp   3：优化为稳定排序
    public static int[] sort0(int[] target) {
        int len = target.length;
        //找到最大值
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            maxValue = Math.max(target[i], maxValue);
        }
        int[] temp = new int[maxValue + 1];

        for (int i = 0; i < len; i++) {
            temp[target[i]]++;
        }

        int index = 0;
        for (int i = 0; i <= maxValue; i++) {
            while (temp[i] != 0) {
                 target[index++] = i;
                 temp[i]--;
            }
        }
        return target;
    }

    public static int[] sort1(int[] target) {
        int len = target.length;
        //找到最大值
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            maxValue = Math.max(target[i], maxValue);
            minValue = Math.min(target[i], minValue);
        }
        int[] temp = new int[maxValue-minValue+1];
        for (int i = 0; i < len; i++) {
            temp[target[i]-minValue]++;
        }

        int index = 0;
        for (int i = 0; i <= maxValue-minValue; i++) {
            while (temp[i] != 0) {
                target[index++] = i+minValue;
                temp[i]--;
            }
        }
        return target;
    }


    public static int[] sort2(int[] target) {
        int len = target.length;
        //找到最大值
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            maxValue = Math.max(target[i], maxValue);
            minValue = Math.min(target[i], minValue);
        }
        int[] temp = new int[maxValue-minValue+1];
        for (int i = 0; i < len; i++) {
            temp[target[i]-minValue]++;
        }

        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i-1] + temp[i];
        } //关键一步，变为稳定排序

        int[] res = new int[len];
        for (int i = len-1; i >= 0; i--) {
            int cur = target[i];
            System.out.println(temp[cur-minValue]);  // temp[cur-minValue] 代表 cur这个数 应该在的res的第几个位置，所以下一行要减1
            res[temp[cur-minValue]-1] = cur;
            temp[cur-minValue]--;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] target = {1,7,4,9,0,5,2,4,7,3,4};
        int[] target1 = {83,80,88,90,88,86};
//        printArray(sort0(target));
//        printArray(sort1(target1));
//        printArray(sort1(target));
//        printArray(sort2(target));
        printArray(sort2(target1));

//        printArray(target);
    }

    private static void printArray(int[] target) {
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i]+" ");
        }
    }
}
