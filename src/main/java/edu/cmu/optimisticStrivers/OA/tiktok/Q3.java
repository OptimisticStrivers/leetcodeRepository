package edu.cmu.optimisticStrivers.OA.tiktok;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Q3
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/11/14 9:59 PM
 * @Version 1.0
 */
public class Q3 {


    //暴力解法
    //其实就是从路径结尾 倒着来 回溯
    //比正着来回溯 会 省时间，因为至少保证这条路径是有结尾的？
    public static long dfs(String node, String startNode, Map<String, Map<String, Long>> graph, Set<String> visited) {
        if (node.equals(startNode)) { //这个必须放在第三个if的前面 因为startnode不用管from
            return 0; //家和办公室一样，居家办公了属于是
        }
        if (visited.contains(node)) {
            return Long.MAX_VALUE; //发现一个环 表示这条路径行不通
        }
        if (graph.get(node) == null) { //没有人可以到node
            return Long.MAX_VALUE;
        }

        visited.add(node); //结束node
        long ans = Long.MAX_VALUE;
        System.out.println(node);
        for (Map.Entry<String, Long> entry : graph.get(node).entrySet()) { //遍历所有能到node的边（很多个from Node）
            long res = dfs(entry.getKey(), startNode, graph, visited); //到达上一个点的最短距离
            System.out.println(" 1 " + entry.getKey() + " " + res);
            if (res < Long.MAX_VALUE) {
                ans = Math.min(ans, res + entry.getValue());
            }
        }
        visited.remove(node);
        return ans;
    }


    public static long get_shortest_time(String startNode, String endNode, String[][] paths) {
        Map<String, Map<String, Long>> graph = new HashMap<>();
        for (String[] path : paths) {
            String from = path[0];
            String to = path[1];
            long time = Long.parseLong(path[2]);
            graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, time);
//            https://blog.csdn.net/qq_25074189/article/details/110530768
        }
        return dfs(endNode, startNode, graph, new HashSet<>());
    }


    public static void main(String[] args) {

//        System.out.println(get_shortest_time("A", "D",
//                new String[][]{
//                        {"A", "B", "10"},
//                        {"A", "E", "3"},
//                        {"E", "B", "1"},
//                        {"B", "C", "2"},
//                        {"E", "C", "8"},
//                        {"E", "D", "2"},
//                        {"C", "D", "9"}}));
//        System.out.println(get_shortest_time("A", "B",
//                new String[][]{
//                        {"A", "B", "10"},
//                        {"C", "B", "5"},
//                }));

        System.out.println(get_shortest_time1("A", "D",
                new String[][]{
                        {"A", "B", "10"},
                        {"A", "E", "3"},
                        {"E", "B", "1"},
                        {"B", "C", "2"},
                        {"E", "C", "8"},
                        {"E", "D", "2"},
                        {"C", "D", "9"}}));
    }


    //或者缔结特斯拉也可以
    //选择到 结束节点 就结束dijstra即可 不需要所有节点的最短路径都算出来

    public static long get_shortest_time1(String startNode, String endNode, String[][] paths) {
        Map<String, Map<String, Long>> graph = new HashMap<>();
        for (String[] path : paths) {
            String from = path[0];
            String to = path[1];
            long time = Long.parseLong(path[2]);
            graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, time);
        }
        //先统计所有的点
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < paths.length; i++) {
            set.add(paths[i][0]);
            set.add(paths[i][1]);
        }
        //visited
        HashSet<String> visited = new HashSet<>();
        visited.add(startNode);
        //dis
        HashMap<String, Long> dis = new HashMap<>();
        for (String node : set) {
            dis.put(node, Long.MAX_VALUE);
        }
        dis.put(startNode, 0L);

        //step 1 initialization
        dis.putAll(graph.get(startNode));


        //step 2-4 重复 n-1次
        for (int i = 1; i < set.size(); i++) {
            //step 2 选择新的基准
            String minNode = null;
            long minDist = Long.MAX_VALUE;
            for (Map.Entry<String, Long> entry : dis.entrySet()) {
                if (visited.contains(entry.getKey())) { //被visited过 说明已经被确定下来了
                    continue;
                }
                if (entry.getValue() < minDist) {
                    minDist = entry.getValue();
                    minNode = entry.getKey();
                }
            }
            if (minNode.equals(endNode)) { //不需要走完
                break;
            }
            //step 3 加入该新基准 为 finalized 的点
            visited.add(minNode);

            //step 4 在新的基准基础上 修正 dis
            for (Map.Entry<String, Long> entry : graph.get(minNode).entrySet()) { //minnode 能到的点
                if (visited.contains(entry.getKey())) { //被visited过 说明已经被确定下来了
                    continue;
                }
                if (dis.get(entry.getKey()) > (entry.getValue() + dis.get(minNode))) {
                    dis.put(entry.getKey(), entry.getValue() + dis.get(minNode));
                }
            }
        }
        return dis.get(endNode);
    }
}