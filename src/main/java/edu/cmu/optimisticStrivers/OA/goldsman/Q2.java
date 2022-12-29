package edu.cmu.optimisticStrivers.OA.goldsman;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/16 9:29 PM
 * @Version 1.0
 */
public class Q2 {

    public static long minStart(List<Integer> arr) {
        //find the minimum cur
        long minimum = 0;
        long cur = 0;
        for(int i : arr){
            cur += i;
            System.out.println(cur);
            if( minimum > cur){
                minimum = cur;
            }
        }
        return minimum <= 0? (-1 * minimum + 1):0;
    }



    public static long minStart1(List<Integer> arr) {

        long minResult = (long)arr.get(0);
        long sum = (long)arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            minResult = Math.min(minResult, sum += (long)arr.get(i));
        }
        return minResult >= 0 ? 1 : Math.abs(minResult) + 1;
    }


    public static void main(String[] args) {

//        ArrayList<Integer> ints = new ArrayList<>();
//        ints.add(-5);
//        ints.add(4);
//        ints.add(-2);
//        ints.add(3);
//        ints.add(1);
//        ints.add(-1);
//        ints.add(-6);
//        ints.add(-1);
//        ints.add(0);
//        ints.add(5);
//        System.out.println(minStart(ints));


//        int b = 19283217372141212;
        long a = 19283217372141212L;
        System.out.println(a);
        System.out.println(-1*a);
        System.out.println(-a);
        long b = 9223372036854775807L;
        System.out.println(-1*b);
        long c  = -9223372036854775808L;
//        long d = -9223372036854775809L;
//        long c = 9223372036854775808L;

    }
}
