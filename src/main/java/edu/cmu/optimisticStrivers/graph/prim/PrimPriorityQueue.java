package edu.cmu.optimisticStrivers.graph.prim;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: PrimPriorityqueue
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/14 4:25 PM
 * @Version 1.0
 */
public class PrimPriorityQueue {


    //拿到mst的total weight
    public double getMST_TotalWeight(double[][] graph) {
        int len = graph.length;
        int[] visited = new int[len];
        visited[0] = 1;
        double res = 0d;
        PriorityQueue<MyEdge> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));
        //当前节点
        int key = 0;
        MyEdge myEdge = new MyEdge();
        for (int k = 1; k < len; k++) { //n-1次
            for (int j = 0; j < len; j++)//记入新加入点的情况
            {
                if (visited[j] == 0)//没标记过的点就加入全家桶套餐 然后找出 到当前生成树最小的边
                {
                    myEdge = new MyEdge();
                    myEdge.toIndex = j;
                    myEdge.weight = graph[key][j];
                    priorityQueue.add(myEdge);
                }
            }
            while (!priorityQueue.isEmpty() && visited[priorityQueue.peek().toIndex] == 1)//最小边但是标记过就放弃
            {
                priorityQueue.poll();
            }
            if (priorityQueue.isEmpty()) //这里应该不会发生吧 但是如果不是连通图 就肯定没有最小生成树呀
                break;
            myEdge = priorityQueue.peek();
            key = myEdge.toIndex;
            res += myEdge.weight;//累加最小边的和
            visited[key] = 1;
        }
        return res;
    }

    static class MyEdge {
        public int toIndex;  //保存边的情况，to为通往的边，不需要保存from
        public double weight;

        public MyEdge() {
        }

        public MyEdge(int v1, double weight) {
            this.toIndex = v1;
            this.weight = weight;
        }
    }
}
