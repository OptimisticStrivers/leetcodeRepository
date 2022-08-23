package edu.cmu.optimisticStrivers.bfs;

import java.util.*;

/**
 * @ClassName: DYQ_lintcode_1565
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/3 1:33 PM
 * @Version 1.0
 */
public class DYQ_lintcode_1565 {

    public int modernLudo(int length, int[][] connections) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(length, connections);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(1, 0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int limit = Math.min(node + 7, length + 1);
            for (int neighbor = node + 1; neighbor < limit; neighbor++) {
                List<Integer> connectedNodes = getUnvisitedNodes(graph, distance, neighbor); //cassie这种做法相当于，coonectednodes就是自己和直连的 放在一层 例子中的9
                for (int connectedNode : connectedNodes) {
                    if (connectedNode == length) {
                        return distance.get(node) + 1;
                    }
                    distance.put(connectedNode, distance.get(node) + 1);
                    queue.offer(connectedNode);
                }
            }
        }
        return distance.get(length);
    }

    private Map<Integer, Set<Integer>> buildGraph(int length, int[][] connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
        }
        return graph;
    }

    private List<Integer> getUnvisitedNodes(Map<Integer, Set<Integer>> graph, Map<Integer, Integer> distance, int node) {
        List<Integer> unvisitedNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (distance.containsKey(currentNode)) {
                continue;
            }
            unvisitedNodes.add(currentNode);
            for (int neighbor : graph.get(currentNode)) {
                if (!distance.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    unvisitedNodes.add(neighbor);
                }
            }
        }
        return unvisitedNodes;
    }


}
