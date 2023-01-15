package edu.cmu.optimisticStrivers.OA.tiktok;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/11/14 9:59 PM
 * @Version 1.0
 */
public class Q2 {

    public static void main(String[] args) {
        int m = 2;
        int n = 7;
        int[][] a = new int[][]{
                {0, 2}, {4, 4}, {6, 6}
        };
        int[] diff = new int[n + 1];
        for (int[] ints : a) {
            diff[ints[0]]++;
            diff[ints[1] + 1]--;
        }
        int sum = 0;
        int count = 0;
        for (int i = 0; i < 7; i++) {
            sum += diff[i];
            if (sum == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

}
