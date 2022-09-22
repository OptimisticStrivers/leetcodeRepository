package edu.cmu.optimisticStrivers.bootcamp;

/**
 * @ClassName: E1P2_MaximumDifferenceInArray
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/4 7:17 PM
 * @Version 1.0
 */
public class E1P2_MaximumDifferenceInArray {


    //两个for肯定必超 我们先试一下 hashmap
    //妈的 hashmap 也是 n^2
    static int maxDifference(int[] a) {
        if (a.length == 1) return -1;
        int res = Integer.MIN_VALUE;
        int minValue = a[0];
        for (int i = 1; i < a.length; i++) {
            res = Math.max(res, a[i] - minValue);
            minValue = Math.min(a[i], minValue);
        }
        if (res <= 0) return -1;
        return res;
    }
}
