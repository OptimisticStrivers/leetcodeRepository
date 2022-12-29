package edu.cmu.optimisticStrivers.graph.prim;

/**
 * @ClassName: PrimBase
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/14 4:07 PM
 * @Version 1.0
 */
public class PrimBase {

//    除了 Kruskal 算法以外，普里姆算法（Prim 算法）也是常用的最小生成树算法。虽然在效率上差不多。
//    但是贪心的方式和 Kruskal 完全不同。prim 算法的核心信仰是：从已知扩散寻找最小。
//    它的实现方式和 Dijkstra算法相似但稍微有所区别，Dijkstra 是求单源最短路径。
//    而每计算一个点需要对这个点从新更新距离。而 prim 甚至不用更新距离。直接找已知点的邻边最小加入即可！
//    对于具体算法具体步骤，大致为：
//            (已经是优先队列优化过的prim)
//    1寻找图中任意点，以它为起点，它的所有边 V 加入集合 (优先队列)q1, 设置一个 boolean数组bool[] 标记该位置已经确定。
//    2从集合 q1 找到距离最小的那个边 v1 并判断边另一点 p 是否被标记 (访问)，如果 p 被标记说明已经确定那么跳过，
//    如果未被标 (访问) 记那么标记该点 p, 并且与 p 相连的未知点 (未被标记) 构成的边加入集合 q1，边 v1 (可以进行计算距离之类，该边构成最小生成树)
//    重复 1，2 直到 q1 为空，构成最小生成树 ！




}

