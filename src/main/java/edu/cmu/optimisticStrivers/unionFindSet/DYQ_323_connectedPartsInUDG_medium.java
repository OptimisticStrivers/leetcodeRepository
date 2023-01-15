package edu.cmu.optimisticStrivers.unionFindSet;

/**
 * @ClassName: DYQ_323_connectedPartsInUDG_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/14 11:26 AM
 * @Version 1.0
 */
public class DYQ_323_connectedPartsInUDG_medium {

//    给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
//    示例 1:
//    输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
//
//            0          3
//            |          |
//            1 --- 2    4
//
//    输出: 2
//
//    示例 2:
//    输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
//
//            0           4
//            |           |
//            1 --- 2 --- 3
//
//    输出:  1
//
//    注意:
//    你可以假设在 edges 中不会出现重复的边。
//    而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现。


    static int[] p;
    static int count;

    private static int find(int x) {
        return p[x] != x ? (p[x] = find(p[x])) : x;
    }

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
            count--;
        }
    }

    private static boolean connected(int x, int y) {
        return find(x) == find(y);
    }


    public static int solve(int n, int[][] edges) {
        p = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            union(from, to);
        }
        return count;
    }


    public static void main(String[] args) {
//        System.out.println(solve(5,new int[][]{{0,1},{1,2},{3,4}}));
        System.out.println(solve(5,new int[][]{{0,1},{1,2},{3,4},{2,3}}));

    }


}
