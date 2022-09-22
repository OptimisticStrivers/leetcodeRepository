package edu.cmu.optimisticStrivers.OA.CITADEL;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/20 1:42 PM
 * @Version 1.0
 */
public class Q1 {


    /*
     * Complete the 'getMostVisited' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY sprints
     */

    public static int getMostVisited(int n, List<Integer> sprints) {
//        System.out.println(n);
        int len = sprints.size();
        int[] ints = new int[n];

        //len-1 sprints
        for (int i = 0; i < len - 1; i++) {
            int begin = sprints.get(i);
            int end = sprints.get(i + 1);
            int small = Math.min(begin, end);
            int big = Math.max(begin, end);
            for (int j = small - 1; j <= big - 1; j++) {
                ints[j]++;
            }
        }

        int most = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (ints[i] != 0) {
                if(ints[i] > most){
                    most = ints[i];
                    index = i;
                }
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(4);
        list.add(1);
        list.add(5);
        list.add(10);
        list.add(3);
        System.out.println(getMostVisited(10, list));
    }
}
