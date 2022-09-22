package edu.cmu.optimisticStrivers.sort;

/**
 * @ClassName: DYQ_bubbleSort
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/8 12:28 PM
 * @Version 1.0
 */
public class DYQ_bubbleSort {


    //ascending
    public int[] sort(int[] target) {
        for (int i = target.length - 1; i > 0; i--) {  //n-1次冒泡就够了
            for (int j = 0; j < i; j++) {
//                System.out.println(target[j + 1]);
//                System.out.println(target[j]);
                if (target[j + 1] < target[j]) {
//                    System.out.println("true");
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
        return target;
    }

    public static void main(String[] args) {
        DYQ_bubbleSort dyq_bubbleSort = new DYQ_bubbleSort();
//        int[] ints = dyq_bubbleSort.sort(new int[]{1, -1, 2, 9, 5, 1, 4});
        int[] ints = dyq_bubbleSort.sort(new int[]{9,2,4,2,1,4,0,-1});


        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }


    }

}
