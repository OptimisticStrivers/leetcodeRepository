package edu.cmu.optimisticStrivers.bfs.graph_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: DYQ_133_cloneGraph_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/11 11:00 AM
 * @Version 1.0
 */
public class DYQ_133_cloneGraph_medium {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[101]; //每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100
        Node[] newNodes = new Node[101];
        newNodes[node.val] = new Node(node.val);
        queue.offer(node);
        visited[node.val] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                Node old = queue.poll();
                for (Node neighbor : old.neighbors) {
                    if (!visited[neighbor.val]) { //之前没有碰到过的节点 才会创新节点，并且加入队列
                        newNodes[neighbor.val] = new Node(neighbor.val);
                        queue.offer(neighbor);
                        visited[neighbor.val] = true; //即已经创造出新的node了
                    }
                    newNodes[old.val].neighbors.add(newNodes[neighbor.val]);
                }
            }
        }
        return newNodes[node.val];
    }
}
