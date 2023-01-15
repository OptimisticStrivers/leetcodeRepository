package edu.cmu.optimisticStrivers.graph.shortestPath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: DYQ_743_networkDelay_dijkstra_heap
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 5:56 PM
 * @Version 1.0
 */
public class DYQ_743_networkDelay_dijkstra_heap {

//    Dijkstra的两种实现
//    使用优先队列，适用于稀疏图 即边不是太多 因为边太多的话 heap的维护耗时 反而出力不讨好
//    时间复杂度是 mlogn + n


//    1 <= k <= n <= 100
//    1 <= times.length <= 6000  最多只有6000条边
//    100*100 = 10000  6000<10000 不算太稀疏 我们就用heap？
//    times[i].length == 3


    //邻接向量星 建图 练习

    public static int networkDelayTime(int[][] times, int n, int k) {

        //建图
        int[] head = new int[110];
        Arrays.fill(head, -1); //初始化 链表 头部，然后我们是头插法 所以以后就变成尾巴了 用于遍历结束点
        int[] edge = new int[6010];
        int[] next = new int[6010];
        int[] weight = new int[6010];
        int edgeIndex = 0;

        for (int[] info : times) {
            int source = info[0];
            int target = info[1];
            int travelTime = info[2];
            edge[edgeIndex] = target;
            weight[edgeIndex] = travelTime;
            next[edgeIndex] = head[source];
            head[source] = edgeIndex;
            edgeIndex++;
        }
//
//        System.out.println(Arrays.toString(edge));
//        System.out.println(Arrays.toString(head));
//        System.out.println(Arrays.toString(next));
//        System.out.println(Arrays.toString(weight));

        int[] dis = dijstra(head, edge, next, weight, n, k);
        System.out.println(Arrays.toString(dis));
        int res = 0;
        for (int i = 1; i <= n; i++) { //dis 的 index 0 没有用过
            res = Math.max(dis[i], res);
        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }

    private static int[] dijstra(int[] head, int[] edge, int[] next, int[] weight, int n, int k) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;  //需要的 更新的时候要用
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.add(new int[]{k, 0});//起点到自己的距离为0

        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int id = poll[0];
            int step = poll[1];
            if (visited[id]) { //已经visited过的节点 即源到她的距离已经确定了 就不需要在站在她的位置上再眺望了 重复工作 可有可无 因为heap不会无止境 所以会结束
                continue; //但是加上可以节省时间的
            }
            visited[id] = true;

            for (int i = head[id]; i != -1; i = next[i]) {
                int j = edge[i];
                if (visited[j]) { //加不加 无所谓 因为已经被加入visited的 一定不会在被更新dis 即下面的if不会满足的
                    continue;
                }
                if (weight[i] + step < dis[j]) {
                    dis[j] = weight[i] + step;
                    heap.add(new int[]{j, dis[j]});
                }

            }
        }
        return dis;
    }


    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }

}
