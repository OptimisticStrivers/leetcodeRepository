package edu.cmu.optimisticStrivers.OA.zoom;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/24 10:04 AM
 * @Version 1.0
 */
public class Q2 {


    static boolean[] solution(int[][] operations) {
        List<Boolean> res = new ArrayList<>();
        int operationNum = operations.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < operationNum; i++) {
            int[] cur = operations[i];
            int a1 = cur[1];
            int a2 = cur[2];
            System.out.println(cur[0]);
            if (cur[0] == 0) { //add
                list.add(new int[]{a1, a2});
            } else { //check
                if (list.size() == 0) {
                    res.add(true);
                    continue;
                }
                boolean isFalse = false;
                for (int[] rectangle : list) {
                    if ( (rectangle[0] < a1 || rectangle[1] < a2) && (rectangle[1] < a1 || rectangle[0] < a2)) {
                        res.add(false);
                        isFalse = true;
                        break;
                    }
                }
                if (!isFalse) res.add(true);
            }
        }
        boolean[] res1 = new boolean[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res1[i] = res.get(i);
        }
        return res1;
    }


    public static void main(String[] args) {
        int[][] test = new int[][]{
                {0, 3, 3},
                {0, 5, 2},
                {1, 3, 2},
                {1, 2, 4}
        };

        boolean[] solution = solution(test);
        for (boolean b : solution) {
            System.out.println(b);
        }

    }
}
