package edu.cmu.optimisticStrivers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName: DYQ_218_SkylineProblem_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/24 3:44 AM
 * @Version 1.0
 */
public class DYQ_218_SkylineProblem_hard {


    //    https://leetcode.cn/problems/the-skyline-problem/solution/gong-shui-san-xie-sao-miao-xian-suan-fa-0z6xc/
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> afterSorted = new ArrayList<>();
        for (int[] building : buildings) {
            int l = building[0];
            int r = building[1];
            int height = building[2];
            afterSorted.add(new int[]{l, -1 * height});
            afterSorted.add(new int[]{r, height});
        }
        //所有的节点都要排序的呀 一共 2*building个数 个 节点
        //横坐标不同的时候 按照横坐标升序就好 就是出现时间嘛
        //横坐标相同的时候 再按照 纵坐标 升序  即矮的在前面
        Collections.sort(afterSorted, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        System.out.println("节点个数  " + afterSorted.size());
        // 大根堆
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int prev = 0;
        q.add(prev);
        for (int[] p : afterSorted) {
            int x = p[0], height = p[1];
            if (height < 0) {
                // 如果是左端点，说明存在一条往右延伸的可记录的边，将高度存入优先队列
                q.add(-height);
            } else {
                // 如果是右端点，说明这条边结束了，将当前高度从队列中移除
                q.remove(height);
            }
            // 取出最高高度，如果当前不与前一矩形“上边”延展而来的那些边重合，则可以被记录
            int cur = q.peek();
            System.out.println("peek " + cur);
            if (cur != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(x); //横坐标
                list.add(cur); //高度
                res.add(list);
                prev = cur;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = new int[]{0, 3, 5};
        int[] b = new int[]{0, 2, 8};
        int[][] test = new int[][]{a, b};
        DYQ_218_SkylineProblem_hard dyq_218_skylineProblem_hard = new DYQ_218_SkylineProblem_hard();
        List<List<Integer>> skyline = dyq_218_skylineProblem_hard.getSkyline(test);
        for (List<Integer> list : skyline) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }
}
