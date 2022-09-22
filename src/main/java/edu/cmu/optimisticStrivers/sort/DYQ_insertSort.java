package edu.cmu.optimisticStrivers.sort;

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

    public static void main(String[] args) {
        DYQ_insertSort dyq_insertSort = new DYQ_insertSort();
        int[] target = new int[]{1, 0, -1, 3, 2, 9, 3, 4};
        dyq_insertSort.sort(target);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
    }

}
