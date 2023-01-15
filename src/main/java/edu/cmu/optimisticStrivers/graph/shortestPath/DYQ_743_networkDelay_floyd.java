package edu.cmu.optimisticStrivers.graph.shortestPath;

/**
 * @ClassName: DYQ_743_networkDelay_prim
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 5:33 PM
 * @Version 1.0
 */
public class DYQ_743_networkDelay_floyd {
//
//    根据「基本分析」，我们可以使用复杂度为 n3 的「多源汇最短路」算法 Floyd 算法进行求解，同时使用「邻接矩阵」来进行存图。
//    空间复杂度为n2
//    此时计算量约为 10^6 ，可以过。
//    跑一遍 Floyd，可以得到「从任意起点出发，到达任意起点的最短距离」。
//    然后从所有 w[k][x]  中取 max 即是「从 k 点出发，到其他点 x 的最短距离的最大值」。


    //dijkstra是基于贪婪
    //floyd 是基于迭代 动态规划 一般认为比dijkstra简单 以代码简洁优雅而著称
    //每次循环的本质是基于动态规划
    //  通过三个嵌套循环 即可得到图中任意两点最短距离 以及最短距离路径（可以有 可以无 看需不需要 就像是dijkstra的from数组一样）

    //适用于各种图 普遍的事 赋权无向图 本题是赋权有向图


//    1 <= k <= n <= 100
//            1 <= times.length <= 6000
//    times[i].length == 3
//            1 <= ui, vi <= n
//    ui != vi
//0 <= wi <= 100
//    所有 (ui, vi) 对都 互不相同（即，不含重复边）

    int N = 110, M = 6010;
    // 邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
    int[][] w = new int[N][N];
    //    int INF = 0x3f3f3f3f;
    int n, k;

    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
//                w[i][j] = w[j][i] = i == j ? 0 : INF; //这个初始化操作很重要
                w[i][j] = w[j][i] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }
        // 最短路
        floyd();
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, w[k][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
//        return ans >= INF / 2 ? -1 : ans;
    }

    void floyd() {
        // floyd 基本流程为三层循环：
        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (w[i][p] != Integer.MAX_VALUE && w[p][j] != Integer.MAX_VALUE && w[i][p] + w[p][j] < w[i][j]) {
                        w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                    }
                }
            }
        }
    }
}
