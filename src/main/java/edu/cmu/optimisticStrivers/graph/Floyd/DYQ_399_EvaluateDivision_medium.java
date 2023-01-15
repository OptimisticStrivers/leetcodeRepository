package edu.cmu.optimisticStrivers.graph.Floyd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DYQ_399_EvaluateDivision_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 9:55 PM
 * @Version 1.0
 */
public class DYQ_399_EvaluateDivision_medium {


//    Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
//    queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//    Output: [3.75000,0.40000,5.00000,0.20000]

// 三种方法
    //floyd
    //dfs
    //并查集

//    方法一 floyd
//    这道题可以转化为一个 带权图问题。
//    a/b = 2, b/c=3 => a/c=6
//    可以抽象为 a到b的边权重为2，b到c的边权重为3， a到c的边权重为2*3=6，
//    图中任意2点的距离用2点之间边的权重乘积表示.
//    如此，问题归为，如何求图中任意两点的距离。
//    可以使用Floyd算法解决。

    //floyd 如果node本身是integer就能表示的话 那其实邻接矩阵是最好的建图方法
    //本题如果是这种字符串的node 我们还是用hashmap去模拟邻接矩阵吧         Map<String, Map<String,Double>>
    //记着floyd自己到自己是0 到不了的是INF

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double weight = values[i];
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, weight);
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(to).put(from, 1 / weight);
        }

        //floyd
        for (Map.Entry<String, Map<String, Double>> mid : graph.entrySet()) {
            for (Map.Entry<String, Map<String, Double>> from : graph.entrySet()) {
                for (Map.Entry<String, Map<String, Double>> to : graph.entrySet()) {
//                    from就算本来不能到to也可以的
//                    if(from.getValue().containsKey(to.getKey())){ //from能到to
                    //from能到 mid，mid能到to是更新的必要条件
                    //因为我们不需要最小距离 只要能到就行 所以只要满足上述条件 我们就改 from->to的权重值
                    if (from.getValue().containsKey(mid.getKey()) && mid.getValue().containsKey(to.getKey())) {
                        from.getValue().put(to.getKey(), from.getValue().get(mid.getKey()) * mid.getValue().get(to.getKey()));
                    }
                }
            }
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (graph.get(queries.get(i).get(0)) == null || graph.get(queries.get(i).get(1)) == null) { //没有这种node
                res[i] = -1d;
                continue;
            }
            if (graph.get(queries.get(i).get(0)).containsKey(queries.get(i).get(1))) {
                res[i] = graph.get(queries.get(i).get(0)).get(queries.get(i).get(1));
            }
        }
        return res;
    }


//    方法二 dfs
//    这是一个有向图的搜索问题。本质上就是求两个节点之间的距离。
//    首先定义邻接节点，里面有两个字段，分表表示邻接节点的名称和当前节点到达邻接节点所需的倍数；
//    然后构造一个map来存储图，map的键就是节点名称，map的值就是节点的邻接节点列表；
//    遍历给定所有算式，将节点和值都存到map当中；
//    遍历需要求的问题，深搜每个节点，为了防止进入环绕圈，用一个集合来存储已经搜索过的节点。

    public double[] calcEquation_dfs(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double weight = values[i];
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, weight);
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(to).put(from, 1 / weight);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            HashSet<String> visited = new HashSet<>(); //是否visited过 防止环
            res[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), 1d, visited);
        }
        return res;
    }

    //不需要保存状态 有点像22 generateParenthesis 不要往回溯上想
    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, double curNum, HashSet<String> visited) {
        if (!graph.containsKey(from) || visited.contains(from)) { //根本没有from这个节点 或者遇到了 环
            return -1d;
        }
        // 走到了终点，那就返回已经计算了的倍数
        if (from.equals(to)) return curNum;
        // 集合中添加当前走过的节点，防止绕圈
        visited.add(from);

        // 遍历当前节点的邻接节点
        for (Map.Entry<String, Double> stringDoubleEntry : graph.get(from).entrySet()) {
            // 继续深搜，倍数需要乘上下个一个节点的倍数
            double temp = dfs(graph, stringDoubleEntry.getKey(), to, curNum * stringDoubleEntry.getValue(), visited);
            // 如果搜到了答案，就直接返回答案
            if (temp != -1.0) return temp;

        }
        return -1d;
    }


}
