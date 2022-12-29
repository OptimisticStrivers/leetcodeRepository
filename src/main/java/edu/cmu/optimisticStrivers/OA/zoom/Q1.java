package edu.cmu.optimisticStrivers.OA.zoom;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/24 10:03 AM
 * @Version 1.0
 */
public class Q1 {


    static int solution(int[] arr1, int[] arr2) {

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            //shift one time

            int tail = arr1[arr1.length-1];
            for (int j = arr1.length-1; j > 0; j--) {
                arr1[j] =  arr1[j-1];
            }
            arr1[0] = tail;
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(arr1[j] + " ");
            }
            System.out.println();
            int curSum = 0;
            for (int j = 0; j < arr1.length; j++) {
                curSum += Math.abs(arr1[j] - arr2[j]);
            }
            System.out.println(curSum);
            res = Math.min(res, curSum);
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2, 11}, new int[]{10, 1, 8, 4}));
    }
}
