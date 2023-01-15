package edu.cmu.optimisticStrivers.graph.shortestPath;

import java.util.Arrays;

/**
 * @ClassName: DYQ_743_networkDelay_dijkstra
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 5:33 PM
 * @Version 1.0
 */
public class DYQ_743_networkDelay_dijkstra {


//    使用时间复杂度为 n2 的「单源最短路」算法朴素 Dijkstra 算法进行求解，同时使用「邻接矩阵」来进行存图。
//    根据题意， 点作为源点，跑一遍 Dijkstra 我们可以得到从源点 k 到其他点 x 的最短距离。
//    再从所有最短路中取  即是「从 k 点出发，到其他点 x 的最短距离的最大值」。
//    朴素 Dijkstra 复杂度为 n2 ，可以过。


    //建图练习  int[][] 邻接矩阵 稠密的时候比较适合用

    //4步-2步 循环n次 在循环里确定pivot
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] ints : graph) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int[] info : times) {
            int source = info[0];
            int target = info[1];
            int travelTime = info[2];
            graph[source][target] = travelTime;
        }
        //step1 initialization
        boolean[] visited = new boolean[n + 1];
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
//        from就不需要了 不需要返回具体路径

        //循环 n 次
        for (int i = 1; i <= n; i++) {
            int nextNode = -1;
            int min = Integer.MAX_VALUE;
            for (int node = 1; node <= n; node++) {
                if (visited[node]) {
                    continue;
                }
                if (dis[node] < min) {
                    nextNode = node;
                    min = dis[node];
                }
            }
            if (nextNode == -1) {
                break;
            }
            visited[nextNode] = true;

            //step 4 以基准点 更新距离
            for (int j = 1; j <= n; j++) {
//                if (visited[j]) { //加不加 无所谓 因为已经被加入visited的 一定不会在被更新dis 即下面的if不会满足的
//                    continue;
//                }
                if (graph[nextNode][j] != Integer.MAX_VALUE) { //防止溢出
                    if (graph[nextNode][j] + dis[nextNode] < dis[j]) {
                        dis[j] = graph[nextNode][j] + dis[nextNode];
                    }
                }
            }
        }

//        int asInt = Arrays.stream(dis).max().getAsInt();
        int res = 0;
        for (int i = 1; i <= n; i++) { //跳过索引为0
            res = Math.max(dis[i], res);

        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


//
//
//    public int networkDelayTime(int[][] times, int n, int k) {
//        int[][] graph = new int[n + 1][n + 1];
//        for (int[] ints : graph) {
//            Arrays.fill(ints, Integer.MAX_VALUE);
//        }
//        for (int[] info : times) {
//            int source = info[0];
//            int target = info[1];
//            int travelTime = info[2];
//            graph[source][target] = travelTime;
//        }
//        //step1 initialization
//        boolean[] visited = new boolean[n + 1];
//        int[] dis = new int[n + 1];
////        from就不需要了 不需要返回具体路径
//
//        //step2 fill in
//        for (int i = 1; i <= n; i++) {
//            dis[i] = graph[k][i];
//        }
//        dis[k] = 0;
//        visited[k] = true;
//
//        //循环 n-1 次
//        for (int i = 1; i <= n - 1; i++) {
//            //step 3 找一个下一个基准点
//            int nextNode = -1;
//            int min = Integer.MAX_VALUE;
//            for (int node = 1; node <= n; node++) {
//                if (visited[node]) {
//                    continue;
//                }
//                if (dis[node] < min) {
//                    nextNode = node;
//                    min = dis[node];
//                }
//            }
//            if (nextNode == -1) {
//                break;
//            }
//            visited[nextNode] = true;
//
//            //step 4 以基准点 更新距离
//            for (int j = 1; j <= n; j++) {
//                if (visited[j]) {
//                    continue;
//                }
//                if (graph[nextNode][j] != Integer.MAX_VALUE) {
//                    if (graph[nextNode][j] + dis[nextNode] < dis[j]) {
//                        dis[j] = graph[nextNode][j] + dis[nextNode];
//                    }
//                }
//            }
//        }
//
//        int asInt = Arrays.stream(dis).max().getAsInt();
//        return asInt == Integer.MAX_VALUE ? -1 : asInt;
//    }


}
