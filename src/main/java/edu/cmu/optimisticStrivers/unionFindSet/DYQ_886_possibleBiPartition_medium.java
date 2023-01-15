package edu.cmu.optimisticStrivers.unionFindSet;

/**
 * @ClassName: DYQ_886_possibleBiPartition_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 1:50 PM
 * @Version 1.0
 */
public class DYQ_886_possibleBiPartition_medium {
    //本题有两种解法 一个是染色法 dfs 需要建图
    //第二个是并查集


    //反向点（用于union） + 并插集

    int[] p = new int[4010];

    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    void union(int a, int b) {
        p[find(a)] = find(b);
//        p[find(a)] = p[find(b)];
    }

    boolean query(int a, int b) {
        return find(a) == find(b);
    }

    public boolean possibleBipartition(int n, int[][] ds) {
        for (int i = 1; i <= 2 * n; i++) p[i] = i; //先把所有并查集中会出现的点 初始化出来 自己就是自己的帮主
        for (int[] info : ds) {
            int a = info[0], b = info[1];
            if (query(a, b)) return false;
            union(a, b + n);
            union(b, a + n);
        }
        return true;
    }


}
