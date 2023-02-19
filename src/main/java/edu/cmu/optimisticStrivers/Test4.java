package edu.cmu.optimisticStrivers;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName: Test4
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/2/7 4:13 PM
 * @Version 1.0
 */
public class Test4 {


    public static void main(String[] args) {

        Character[] a = new Character[]{'V','6','t','N','V','B'};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        Arrays.sort(a, (a1,a2) -> a2 - a1);
//        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
        t, V, V, N, B, 6
                3 1 5 4 6 2



    }
}
