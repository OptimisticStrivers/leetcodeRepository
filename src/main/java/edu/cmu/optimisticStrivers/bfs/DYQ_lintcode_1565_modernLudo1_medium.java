package edu.cmu.optimisticStrivers.bfs;

import java.util.*;

/**
 * @ClassName: DYQ_lintcode_1565_modernLudo1_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/3 10:55 AM
 * @Version 1.0
 */
public class DYQ_lintcode_1565_modernLudo1_medium {


    //bfs 但是没有第一层while里的for size
    //关键就是 一次掷骰子能走到的所有节点 在新的bfs的一层
    public int modernLudo1(int length, int[][] connections) {
        int[] res = new int[length + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= length; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        queue.offer(1);
        res[1] = 0; //起始位置就在1 所以是0次掷骰子
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= 6; i++) {
                if (current + i <= length && res[current + i] > res[current] + 1) {
                    queue.offer(current + i);
                    res[current + i] = res[current] + 1;
                }
            }
            for (int i = 0; i < connections.length; i++) {
                if(connections[i][0] == current && res[connections[i][1]] > res[current]){
                    //后面这个条件 会起作用的地方 比如 有 3-> 11 和 2->11 两种无损飞行
                    //那么这时候我们一定是往远了飞 下一层即使3也能跳到11 那也不如2直接跳到11
                    queue.offer(connections[i][1]);
                    res[connections[i][1]] = res[current];
                }
            }
        }
        return res[length];
    }


    //cassie的unvisited的是 for的时候 不需要遍历到出队元素 就可以把直连的元素入队
    //但是我的这种 只有在遍历到出队元素的时候 才会去入队直连元素 比如 例子中的9 就没有办法像cassie那种 优化掉，而是重复入队 然后被替换掉

//    SPFA
//    两种优化：1 unvisited 不会重复入队
//            2 priorityqueue 小顶堆 不懂


    //普通SPFA (shortest path fast algorithm)
    public int modernLudo(int length, int[][] connections) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph1(length, connections);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(1, 0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (distance.get(next) > distance.get(curr)) {
                    queue.offer(next);
                    distance.put(next, distance.get(curr));
                }
            }
            int limit = Math.min(length, curr + 6);
            for (int next = curr + 1; next <= limit; next++) {
                if (distance.get(next) > distance.get(curr) + 1) {
                    distance.put(next, distance.get(curr) + 1);
                    queue.offer(next);
                }
            }
        }
        return distance.get(length);
    }

    private Map<Integer, Set<Integer>> buildGraph1(int length, int[][] connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] conn : connections) {
            graph.get(conn[0]).add(conn[1]);
        }
        return graph;
    }


    //heap 小顶堆 优化SPFA
    public int modernLudo2(int length, int[][] connections) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(length, connections);
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(1, 0);
//        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (distance.get(next) > distance.get(curr)) {
                    queue.offer(next);
                    distance.put(next, distance.get(curr));
                }
            }
            int limit = Math.min(length, curr + 6);
            for (int next = curr + 1; next <= limit; next++) {
                if (distance.get(next) > distance.get(curr) + 1) {
                    distance.put(next, distance.get(curr) + 1);
                    queue.offer(next);
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
        for (int[] conn : connections) {
            graph.get(conn[0]).add(conn[1]);
        }
        return graph;
    }
}
