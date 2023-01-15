package edu.cmu.optimisticStrivers.sort.quickSelect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName: DYQ_1337_weakestKRows_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/5 5:58 PM
 * @Version 1.0
 */
public class DYQ_1337_weakestKRows_easy {

    //method1 直接数每行的军人个数 然后排序


    //method2 二分查找 + 堆
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        List<int[]> power = new ArrayList<int[]>();
        for (int i = 0; i < m; ++i) {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power.add(new int[]{pos + 1, i});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0]) {
                    return pair1[0] - pair2[0];
                } else {
                    return pair1[1] - pair2[1];
                }
            }
        });
        for (int[] pair : power) {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }

    //method3 二分查找 + 快速选择
    //https://leetcode.cn/problems/the-k-weakest-rows-in-a-matrix/solution/fang-zhen-zhong-zhan-dou-li-zui-ruo-de-k-xing-by-l/


}
