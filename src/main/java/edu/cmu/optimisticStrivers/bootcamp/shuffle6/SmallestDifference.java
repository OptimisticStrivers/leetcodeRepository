package edu.cmu.optimisticStrivers.bootcamp.shuffle6;

import java.util.Arrays;

/**
 * @ClassName: SmallestDifference
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/26 5:20 PM
 * @Version 1.0
 */
public class SmallestDifference {

    public static int findSmallestDifference(int[] array1, int[] array2) {

        Arrays.sort(array1);
        Arrays.sort(array2);

        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        while(i< array1.length && j < array2.length){
            if(Math.abs(array1[i]-array2[j])<res){
                res = Math.abs(array1[i]-array2[j]);
            }

            if(array1[i] < array2[j]){
                i++;
            }else{
                j++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(findSmallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }
}
