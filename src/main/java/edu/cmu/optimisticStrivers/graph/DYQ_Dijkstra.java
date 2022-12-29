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


    //适宜条件为 全部为正权边 双向边
    //graph为 n*n 的矩阵
    //处理结果为 从start索引这个地方 出发 到所有点的最短距离


    public static void main(String[] args) {
        DYQ_Dijkstra dyq_dijkstra = new DYQ_Dijkstra();
        int[][] matrix;
        int[] v0 = new int[]{0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, 3};
        int[] v1 = new int[]{Integer.MAX_VALUE, 0, 8, 15, Integer.MAX_VALUE, 6, Integer.MAX_VALUE};
        int[] v2 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] v3 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] v4 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 3, 0, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] v5 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 0, Integer.MAX_VALUE};
        int[] v6 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 0};
        matrix = new int[][]{v0, v1, v2, v3, v4, v5, v6};
//        System.out.println(Arrays.toString(matrix));
        dijkstra(matrix, 0);

//        int[] v1 = new int[]{0, Integer.MAX_VALUE, 10, Integer.MAX_VALUE, 30, 100};
//        int[] v2 = new int[]{Integer.MAX_VALUE, 0, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        int[] v3 = new int[]{10, 5, 0, 50, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        int[] v4 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 50, 0, 20, Integer.MAX_VALUE};
//        int[] v5 = new int[]{30, Integer.MAX_VALUE, Integer.MAX_VALUE, 20, 0, 60};
//        int[] v6 = new int[]{100, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 60, 0};
//        matrix = new int[][]{v1, v2, v3, v4, v5, v6};

//        dyq_dijkstra.getShortestPath(matrix, 0);
    }


//    https://blog.csdn.net/qq_63786973/article/details/125220500?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-125220500-blog-81629274.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-125220500-blog-81629274.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=1
//    需要的资源
//    图结构 graphNet ： 带权的图 （网），用邻接矩阵表示
//    路径前驱数组 path[ ] ：存储 从起点 V0 到 终点 Vm 的 当前 最短路径 终点 的前驱 ，即 V0->Vm的前驱->Vm（此步在接下来会充分解析）
//    最短路径数组 dist[ ] ：存储 从起点 V0 到 终点 Vm 的 当前 最短路径长度，即当前的权值之和
//    集合数组 S[ ] ：检查 从起点 V0 到 某顶点 是否已经求得最短路径
//    集合 V ： 图节点总数

    //    Step1	将与V0有连线的顶点之间 对应的最短路径长度 path[ ] 初始化为 权值
//    Step2	选择Vm，使dist[ Vm ]=Min{ dist[ Vi ]，Vi属于V-S
//    Step3	将Vm加入S中
//    Step4	在求得 dist[ Vm ]的基础上，修正从起点 V0 到集合V-S 上任意顶点 Vi 的最短路径的长度
//    重复以上 2~4 步共 n-1 次即可求得 V0 到图中 其他每个顶点 对应的最短路径
    public static Node[] dijkstra(int[][] graph, int start) {
        int numOfNodes = graph.length;
        //path 记录pre node
        int[] path = new int[numOfNodes];
//        Arrays.fill(path, -1);
        //path[start] = start;   没有必要
        //dist
        int[] dist = new int[numOfNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        //S
        boolean[] reachedMinDist = new boolean[numOfNodes];
        reachedMinDist[start] = true;
        //step1
        for (int i = 0; i < numOfNodes; i++) {
            //dist[i] = Math.min(graph[start][i],dist[i]); 和下面的一个道理
            dist[i] = graph[start][i];
            path[i] = graph[start][i] == Integer.MAX_VALUE ? -1 : start;  //初始化的时候没必要 因为在下面选出
        }
//        System.out.println("path " + Arrays.toString(path));
//        System.out.println("dist " + Arrays.toString(dist));
//        System.out.println("reached min " + Arrays.toString(reachedMinDist));
//        System.out.println();
        //n个点 step2-4 重复n-1次即可
        int curNode = start;
        for (int i = 0; i < numOfNodes - 1; i++) {
            //step2
            int minNode = -1;
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < numOfNodes; j++) {
                if (!reachedMinDist[j] && minDist > dist[j]) {
                    minDist = dist[j];
                    minNode = j;
                }
            }
            if (minNode == -1) { //代表根本没有下一个最近点
//                System.out.println("minDIst " + minDist);
//                System.out.println("minNode " + minNode);
//                System.out.println("break " + (i+1));
                break;
            }
            //step3
            reachedMinDist[minNode] = true;
            //step4
            for (int j = 0; j < numOfNodes; j++) {
                if (!reachedMinDist[j] && (dist[j] - graph[minNode][j]) > minDist) {
                    dist[j] = minDist + graph[minNode][j]; //还是会溢出
                    path[j] = minNode;
                }
            }
//            System.out.println("node " + (i + 1));
//            System.out.println("path " + Arrays.toString(path));
//            System.out.println("dist " + Arrays.toString(dist));
//            System.out.println("reached min " + Arrays.toString(reachedMinDist));
//            System.out.println();
        }

        return new Node[1];
    }


    private static class Node {
        private Integer dis;
        private Integer from;

        public Node(Integer dis, Integer from) {
            this.dis = dis;
            this.from = from;
        }
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
