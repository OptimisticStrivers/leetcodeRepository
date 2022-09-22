package edu.cmu.optimisticStrivers.graph;

import java.util.Arrays;

/**
 * @ClassName: DYQ_Dijkstra
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/20 11:31 上午
 * @Version 1.0
 */
public class DYQ_Dijkstra {


    public int[] result;
    public boolean[] gotTheShortestPath;

    //适宜条件为 全部为正权边 双向边
    //graph为 n*n 的矩阵
    //处理结果为 从start索引这个地方 出发 到所有点的最短距离
    public void getShortestPath(int[][] graph, int start) {
        result = new int[graph.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0; //result初始化的时候 不能直接接matrix 这样会直接引用别人
        for (int j = 0; j < graph.length; j++) {
            result[j] = Math.min(result[j], graph[start][j]);
        }
        gotTheShortestPath = new boolean[graph.length];
        gotTheShortestPath[start] = true;

//        for (int i : result) {
//            System.out.print(i + " ");
//        }

        //一共n个节点 那么循环n-1次 得到单源最短的所有路径

        for (int i = 0; i < graph.length - 1; i++) {
            //先找出当前 result 里离start最近的节点，当然不可以是已经找到的
            int nextNodeIndex = -1;
            int distance = Integer.MAX_VALUE;
            for (int j = 0; j < graph.length - 1; j++) {
                if (!gotTheShortestPath[j] && distance > result[j]) {
                }
            }

        }


    }

    public static void main(String[] args) {
        DYQ_Dijkstra dyq_dijkstra = new DYQ_Dijkstra();
        int[][] matrix;
        int[] v1 = new int[]{0, Integer.MAX_VALUE, 10, Integer.MAX_VALUE, 30, 100};
        int[] v2 = new int[]{Integer.MAX_VALUE, 0, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] v3 = new int[]{10, 5, 0, 50, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] v4 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 50, 0, 20, Integer.MAX_VALUE};
        int[] v5 = new int[]{30, Integer.MAX_VALUE, Integer.MAX_VALUE, 20, 0, 60};
        int[] v6 = new int[]{100, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 60, 0};
        matrix = new int[][]{v1, v2, v3, v4, v5, v6};

        dyq_dijkstra.getShortestPath(matrix, 0);
    }


    //普里姆 prim

    //缔结斯特拉
//    游泳水位接雨水Ⅱ都是bfs+优先队列就是dijkstra
//            有试试经典的LC207好用别忘了回来给我加米哦
    //两步
    // 1.每次从未标记的节点中，选择距离出发点最近的节点，标记，收录到最优路径集合中
    // 2.计算刚加入节点A的邻近节点B的距离（不包含标记的节点），若（节点A的距离+节点A到节点B的边长）<节点B的距离，更新节点B的距离，及B的前面点。 （相等的话，可改可不改）
    // 直到所有都被标记
    // 无权的图，直接bfs就行

    //弗洛伊德，如果权重有负数，或者 想要求任意两点间的最短路径，这时候要用弗洛伊德

//    /


}
