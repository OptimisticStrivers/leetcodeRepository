package edu.cmu.optimisticStrivers.bootcamp.HW4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: PlasticConservation
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/24 10:09 PM
 * @Version 1.0
 */
public class PlasticConservation {

//    complete graph 完全图  n*(n-1) 条边
//    spanning tree 生成树
//    MST minimum spanning tree 最小生成树
//    Prim's MST algorithm 不要求必须是完全图，只是这道题恰好是而已，只要求是连通图即可

//    Euclidean distance 欧几里得距离

//
//    The company you work for, Plastics Inc., has been contracted to produce a part which will hold all of the N screws needed to attach other components of a widget being built by the customer.  Your boss wants you to figure out the minimum amount of plastic needed to produce a single piece that will connect all of the screw locations so that the cost can be kept as low as possible.  Having listened to 11-601 Lecture 6, you realize that the optimum solution is equivalent to a minimum spanning tree over the complete graph on the screw positions, using Euclidean distance as the cost of each edge.
//
//    Implement the function min_cost, which takes an array of the (x,y) coordinates of the screws, and returns the minimum cost, which is the sum of the edge lengths in the minimum spanning tree.
//
//    Optional Utility Code


//    hints
//You may use any algorithm of your choice,
//    but Prim's algorithm is probably the easiest (and MST algorithms which look more efficient may not be,
//    since you're processing a maximally-dense graph).
//    The most important fields for Prim's algorithm in the provided utility classes are Edge.length,
//    Vertex.min_length, and Vertex.min_edge.
//
//    Because we're asking only for the total lengths of the selected edges, you don't need to store them,
//    only update the sum of lengths as you select edges.


    //prim MST

    class Graph {
        int vertexs; //表示顶点个数
        char[] data;//存放顶点数据
        int[][] weight; //使用邻接矩阵存放边

        public Graph(int vertexs, char[] data, int[][] weight) {
            this.vertexs = vertexs;
            this.data = data;
            this.weight = weight;
        }
    }

    //普通prim
//    使用邻接表来存储图，能使得所需的空间最小 不用老师给的数据结构
    static double min_cost(Position[] positions) {
        int len = positions.length;
        double[][] graph = generateGraph(positions);

        //标记已访问顶点
        int[] visited = new int[len];
        //将开始顶点标记已访问
        visited[0] = 1;
        //h1、h2标记最小的权值weight位置
        int h2 = -1;
        //记录最小权值
        double minWeight = Double.MAX_VALUE;
        double res = 0d;
        //除开始顶点，将其他graph.vertexs-1个顶点进行选取
        for (int k = 1; k < len; k++) {
            //遍历图的所有情况，找到此轮的最小权值连接的顶点
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    //选取的顶点要求：i是已经选取的的顶点，j是未选取的顶点，找到满足情况的最小权值，记录位置
                    if (visited[i] == 1 && visited[j] == 0 && graph[i][j] < minWeight) {
                        minWeight = graph[i][j];
                        h2 = j;
                    }
                }
            }
            //将此轮选取的最小权值连接的顶点信息输出
//            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值=" + minWeight);
            //将此轮选取的顶点标记为已访问
            visited[h2] = 1;
            res += minWeight;
            //重新初始化minWeight值
            minWeight = Integer.MAX_VALUE;
        }
        return res;
    }

    public static double[][] generateGraph(Position[] positions) {
        int len = positions.length;
        //初始化 临接矩阵
        double[][] graph = new double[len][len];
        Position pos1 = null;
        Position pos2 = null;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    graph[i][j] = 0d;
                    continue;
                }
                pos1 = positions[i];
                pos2 = positions[j];
                double xsquared = (pos1.x - pos2.x) * (pos1.x - pos2.x);
                double ysquared = (pos1.y - pos2.y) * (pos1.y - pos2.y);
                double edge = Math.sqrt(xsquared + ysquared);
                graph[i][j] = edge;
            }
        }
        return graph;
    }


    //prim 堆优化
//    首先，prim算法的思想是，从一个起点开始，通过不断的纳入与当前生成树距离最短的且不在生成树中的点来构造最小生成树，
//    当所有点都纳入到生成树以后，就得到了最小生成树。使用邻接表来存储图，能使得所需的空间最小。
//    通过一个数组来存放各个点到当前生成树的最短距离，可以避免重复比较，从而提升效率。
//    但我们所要获取的是该数组里的距离最小的那个点。如果没有进行堆优化，那从这个数组里找出最小距离的点的时间复杂度是O（n）,
//    通过堆优化，我们获取最小值的时间复杂度则为O（log2n）,在图的点数目很大时，能有效的提升效率。

    static double min_cost1(Position[] positions) {
        int len = positions.length;
        double[][] graph = generateGraph(positions);
        int[] visited = new int[len];
        visited[0] = 1;
        int h1 = -1;
        int h2 = -1;
        //记录最小权值
        double minWeight = Double.MAX_VALUE;
        double res = 0d;
        PriorityQueue<MyEdge> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));
//        while(!q.empty())q.pop();
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
//                    now.to = j;
//                    now.v = graph[key][j];
//                    q.push(now);
                }
            }
            while (!priorityQueue.isEmpty() && visited[priorityQueue.peek().toIndex] == 1)//最小边但是标记过就放弃
            {
                priorityQueue.poll();
            }
            if (priorityQueue.isEmpty()) //这里应该不会发生吧
                break;
            myEdge = priorityQueue.peek();
            key = myEdge.toIndex;
            res += myEdge.weight;//累加最小边的和
            visited[key] = 1;
        }
        return res;
    }


    //表示边 index1:表示顶点1的在字符数组中的下标
    static class MyEdge {
        public int toIndex;  //保存边的情况，to为通往的边，不需要保存fro
        public double weight;

        public MyEdge() {

        }

        public MyEdge(int v1, double weight) {
            this.toIndex = v1;
            this.weight = weight;
        }
    }


    public class Position {
        short x, y;

        Position(int x_pos, int y_pos) {
            x = (short) x_pos;
            y = (short) y_pos;
        }

        Position(Position pos) {
            x = pos.x;
            y = pos.y;
        }
    }


}
