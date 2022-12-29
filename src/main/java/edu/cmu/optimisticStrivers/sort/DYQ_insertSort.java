package edu.cmu.optimisticStrivers.sort;

import java.util.Arrays;

/**
 * @ClassName: DYQ_insertSort
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/22 12:12 PM
 * @Version 1.0
 */
public class DYQ_insertSort {

//    https://blog.csdn.net/qq_35344198/article/details/106546399

    public void sort(int[] target) {
        int len = target.length;
        for (int i = 1; i < len; i++) {  //从第二个元素开始作为被插入的元素
            //每一次插入到 从 0-i-1 的已经有序的 序列中
            int insertionValue = target[i];
            int j = i - 1;
            for (; j >= 0 && target[j] > insertionValue; j--) {
                target[j + 1] = target[j]; //没必要每次都换 insertion value 和 target[j]
                //直接吧target[j] 往后移就可以了 即 target[j+1] = target[j]
            }
            target[j + 1] = insertionValue;
        }
    }

//    public static void main(String[] args) {
//        DYQ_insertSort dyq_insertSort = new DYQ_insertSort();
//        int[] target = new int[]{1, 0, -1, 3, 2, 9, 3, 4};
//        dyq_insertSort.sort(target);
//        for (int i = 0; i < target.length; i++) {
//            System.out.print(target[i] + " ");
//        }
//    }


    public static int[] insertWithBS(int[] target) {
        int len = target.length;
        for (int i = 1; i < len; i++) {
//            System.out.println(i);
            int value = target[i];
            int index = bs(target, 0, i, value); //从 0 - i 找一个位置 插 所以不能是i-1
//            int index = bs(target, 0, i-1, value); //不对 8,9 增序 会 排为 9 8
//            System.out.println(i - index);
            System.arraycopy(target, index, target, index + 1, i - index);
            target[index] = value;
        }
        return target;
    }

    public static int bs(int[] target, int low, int high, int key) {
        while (low < high) { //这里切忌== 会死循环
            int mid = low + (high - low) / 2;
            if (target[mid] <= key) {  //加上等于号 才是稳定排序呀 相等了以后要往后找位置
                low = mid + 1;
            } else {
//                0 2 1
                high = mid; //必须是 mid 因为要保留要插的位置
//                high = mid - 1; //不对了
                // 0 8 4 这种 会变成 4 0 8 因为最远 4 也应该在8在的位置，而不是直接跳过8的位置
                // 8 4 这种是侥幸过的 因为low恰好卡在了正确节点
                // 0 2
            }
        }
        return low;
    }


//    0 3 4   ->2
//    0 4 2   ->1
//    0 2 2   ->2

    public static void main(String[] args) {
//        int[] a = new int[]{9, 8, 3, 3, 1, 2, 6, 3, 13, 4, 2, 7, 8, 9, 9,0,9,0};
//        int[] a = new int[]{9, 8, 3, 3, 1, 2, 6, 3, 13, 4, 2, 7, 8, 9, 9,0,9,0};
//        int[] a = new int[]{8, 9};
//        int[] a = new int[]{9, 8};
//        int[] a = new int[]{9, 8,9};
//        int[] a = new int[]{0, 2};

//        int[] a = new int[]{0, 2, 2};
        int[] a = new int[]{2, 1};
//        int[] a = new int[]{0, 2, 3};

        System.out.println(Arrays.toString(insertWithBS(a)));
//        a = new int[]{8,8};
//        a = new int[]{7,8};
//        System.out.println(bs(a, 0, 1, 8)); //应该是2 否则不稳定

//        System.arraycopy(a, 1, a, 3 + 1, 0); //报错
//
//        System.out.println(Arrays.toString(a));
//        System.arraycopy(a, 1, a, 2, 0);
//        System.out.println(Arrays.toString(a));
//
////        System.arraycopy(a, 1, a, 1, 1); //copy 一个 不会有问题
//        System.arraycopy(a, 1, a, 2, 0); //copy 一个 不会有问题



        /*    Otherwise, if any of the following is true, an IndexOutOfBoundsException is thrown and the destination is not modified:
            The srcPos argument is negative.
                    The destPos argument is negative.
            The length argument is negative.
                    srcPos+length is greater than src.length, the length of the source array.
                    destPos+length is greater than dest.length, the length of the destination array.*/
//        [8,9]
//        System.arraycopy(a, 1, a, 2, 0); //不会报错 tmd 但是根本没2这个索引
//        System.arraycopy(a, 1, a, 3, 0); //会报错  index 3
//        System.arraycopy(a, 1, a, 2, 1); //会报错  index 3

//         9 8 3 5 2
//
//         9 8 3 8 3
//        System.arraycopy(a,);

    }


//    public static int bs(int[] target, int low, int high, int key) {
//        while (low < high) {
//            int mid = low + (high - low) / 2;
//            if (target[mid] <= key) {
//                low = mid + 1;
//            } else {
//                high = mid;
//            }
//        }
//        return low;
//    }

}