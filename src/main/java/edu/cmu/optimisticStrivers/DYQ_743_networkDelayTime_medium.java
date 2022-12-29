package edu.cmu.optimisticStrivers;

import java.util.*;

/**
 * @ClassName: DYQ_743_networkDelayTime_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/12 3:47 PM
 * @Version 1.0
 */
public class DYQ_743_networkDelayTime_medium {

//
//    //因为 网络是同时传递 数据报
//    //所以 我们其实找从节点开始的最长路径到 叶子节点即可。 一定可以保证所有其他节点都收到了消息
//
//
//    //三种方案
//
//    //1 bfs
//    //2 dfs
//    //3 dijkstra
//    class Pair<T, K> {
//        T key;
//        K value;
//
//        public Pair(T key, K value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public T getKey(){}
//    }
//
//    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
//
//    public int networkDelayTime(int[][] times, int n, int k) {
//
//        //将times 这个图 先转换为 adj map
//        //Map的key是
//        //List是value
//        //Pair的Key是 权重 value是 目的地点
//
//
//        for (int[] time : times) {
//            int source = time[0];
//            int target = time[1];
//            int travelTime = time[2];
//            adj.putIfAbsent(source, new ArrayList<>());
//            adj.get(source).add(new Pair(travelTime, target));
//        }
////        此处sort不知道有没有用
////        for (int key : adj.keySet()) {
////            Collections.sort(adj.get(key), (a, b) -> a.getKey() - b.getKey());
////        }
//        int[] resTime = new int[n + 1];
//        //迭代更新
//        Arrays.fill(resTime, Integer.MAX_VALUE);
//
//        // dfs(resTime, k, 0);
////         bfs(resTime, k);
//        // dijkstra(resTime, k);
//
//        int res = Integer.MIN_VALUE;
//        for (int i = 1; i <= n; i++) {
//            res = Math.max(res, resTime[i]); //取最长的一条路径
//        }
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }
//
//
////    private void bfs(int[] resTime, int source) {
////        Queue<Integer> queue = new ArrayDeque<>();
////        queue.offer(source);
////        resTime[source] = 0;
////
////        while (!queue.isEmpty()) {
////            int currNode = queue.poll();
////            if (!adj.containsKey(currNode)) continue;
////
////            for (Pair<Integer, Integer> p : adj.get(currNode)) {
////                int time = p.getKey();
////                int neighbor = p.getValue();
////                int travelTime = resTime[currNode] + time;
////                if (travelTime < resTime[neighbor]) {
////                    queue.offer(neighbor);
////                    resTime[neighbor] = travelTime;
////                }
////            }
////        }
////    }
//
////    private void dfs(int[] resTime, int source, int time) {
////        if (time >= resTime[source]) return;
////        resTime[source] = time;
////        if (!adj.containsKey(source)) return;
////
////        for (Pair<Integer, Integer> p : adj.get(source)) {
////            dfs(resTime, p.getValue(), time + p.getKey());
////        }
////    }



}
