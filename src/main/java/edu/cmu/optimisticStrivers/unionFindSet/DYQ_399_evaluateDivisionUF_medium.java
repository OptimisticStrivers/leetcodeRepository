package edu.cmu.optimisticStrivers.unionFindSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DYQ_399_evaluateDivisionUF_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/14 12:11 PM
 * @Version 1.0
 */
public class DYQ_399_evaluateDivisionUF_medium {

    //本仓库还有两种方法 一个是 floyd 一个是dfs
    //并查集解法可以衍生于990这题


    //首先这题 和 990不同的地方有2点
    //1 990因为每一个node都是一个小写字母 那么就可以用int作为UF的下标 这题需要先把string做一个index的映射
    //2 这题还需要保存节点到其帮主的路径权重 但是由于我们UF一般（边查询边维护是UF的特点）都会路径压缩 所以我们除了parent数组 还要维护一个weight数组-表示当前节点到帮主的距离
    //weight实例 比如 a/b = 2  b/c = 6  路径压缩以后a/c = 12 如果c是帮主 那么 Weight[a index] = 12


    int[] p;
    double[] weight;


    int find(int x) {
        if (p[x] != x) {
            int originalFather = p[x];
            p[x] = find(p[x]);
            //路径压缩的时候记得 更改权重
            weight[x] *= weight[originalFather]; //father的权重已经在find递归里面被改掉了
        }
        return p[x];
    }

    //    https://leetcode.cn/problems/evaluate-division/solution/399-chu-fa-qiu-zhi-nan-du-zhong-deng-286-w45d/
//    推导关系理清楚
    void union(int a, int b, double num) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return; //不会产生新的边
        }
        p[pa] = pb;
        weight[pa] = weight[b] * num / weight[a];
    }

    double query(int a, int b) {
        if (find(a) == find(b)) {
            return weight[a] / weight[b];
        } else {
            return -1;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //首先 equations 的length*2 一定能涵盖所有的node
        p = new int[equations.size() * 2];
        weight = new double[equations.size() * 2];
        Arrays.fill(weight, 1);
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        //建立 node string 和 index的联系
        Map<String, Integer> map = new HashMap<>();
        int indexCounter = 0;
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            if (!map.containsKey(numerator)) {
                map.put(numerator, indexCounter++);
            }
            if (!map.containsKey(denominator)) {
                map.put(denominator, indexCounter++);
            }
            int indexNumerator = map.get(numerator);
            int indexDenominator = map.get(denominator);
            union(indexNumerator, indexDenominator, values[i]);
        }

        double[] doubles = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            if (!map.containsKey(numerator) || !map.containsKey(denominator)) {
                doubles[i] = -1d;
            } else {
                doubles[i] = query(map.get(numerator), map.get(denominator));
            }
        }
        return doubles;

    }


}
