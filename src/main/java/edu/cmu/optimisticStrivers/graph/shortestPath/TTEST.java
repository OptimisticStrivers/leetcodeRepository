package edu.cmu.optimisticStrivers.graph.shortestPath;

import java.util.Arrays;

/**
 * @ClassName: TTEST
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 6:52 PM
 * @Version 1.0
 */
public class TTEST {

    int N = 110, M = 6010;
    // 邻接表
    int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
    int[] dist = new int[N];
    // 记录哪些点已经被更新过
    boolean[] vis = new boolean[N];
    int n, k, idx;
    int INF = 0x3f3f3f3f;

    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }

    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        // 初始化链表头
        Arrays.fill(he, -1);
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            add(u, v, c);
        }

        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(he));
        System.out.println(Arrays.toString(ne));
        System.out.println(Arrays.toString(w));



        // 最短路
//        dijkstra();
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }

    public static void main(String[] args) {
        TTEST ttest = new TTEST();
        ttest.networkDelayTime(new int[][]{
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);

    }
}
