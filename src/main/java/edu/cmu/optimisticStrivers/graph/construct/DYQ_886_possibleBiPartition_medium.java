package edu.cmu.optimisticStrivers.graph.construct;

import java.util.Arrays;

/**
 * @ClassName: DYQ_886_possibleBiPartition_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 12:12 PM
 * @Version 1.0
 */
public class DYQ_886_possibleBiPartition_medium {

    //本题有两种解法 一个是染色法 dfs 需要建图
    //第二个是并查集

//    https://leetcode.cn/problems/possible-bipartition/solution/by-ac_oier-6j0n/

    //可以用下面的方法做链式向量星 也可以 直接 Map<Integer,List/Set<Integer>>
    //    1 <= n <= 2000
//    0 <= dislikes.length <= 10000

    int[] head = new int[2010]; //表示所有节点的邻接链表的第一条边
    int[] next = new int[20010]; //表示某条边的下一条边的index
    int[] edge = new int[20010]; //表示边
    //int[] weight = new int[20010]
    int edgeIndex = 0;

    private void construct(int from, int to) {
        edge[edgeIndex] = to;
//        next[head[from]] = edgeIndex; //尾插 会有问题 因为head初始化都是-1
        next[edgeIndex] = head[from]; //头插
        head[from] = edgeIndex;
        edgeIndex++;
    }

    int[] color = new int[2010]; //0 无色 1 黄色 2 红色

    //染色法
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //建图  邻接表  链式前向星
        Arrays.fill(head, -1);
        for (int[] dislike : dislikes) {
            construct(dislike[0], dislike[1]);
            construct(dislike[1], dislike[0]);
        }
        for (int i = 1; i <= n; i++) { //n个点 着色
            if (color[i] != 0) { //提前多申请了空间 不会越界
                continue;
            }
            if (!dfs(i, 1)) return false; //着色失败的话 return false
            //无所谓一开始是什么颜色 你想 如果这里是2了 其实没有改变的  只是相反颜色的区别
        }
        return true;
    }

    public boolean dfs(int i, int col) {
        color[i] = col;
        for (int edgeC = head[i]; edgeC != -1; edgeC = next[edgeC]) { //遍历i的所有边 看 有没有冲突的
            int node = edge[edgeC];
            if (color[node] == col) {
                return false;
            }
            if (color[node] == 0 && !dfs(node, 3 - col)) return false; //给和i相邻的node 都上另外一个颜色
        }
        return true;
    }


}
