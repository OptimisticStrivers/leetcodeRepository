为什么弗洛伊德算法支持负权值？

答：因为路径更新是根据新值和旧值比较获得的，
最终的结果都是在最后一次迭代过程中对全局进行更新而得到的，
中间的每次迭代只是一次局部调整而非最终结果。
而不像迪杰斯特拉采用的贪心策略，每一次迭代都确定出一条最短路径，
负权的出现使得不能保证每次迭代都是最优解。



Floyd的讲解
https://www.bilibili.com/video/BV1q4411M7r9/?spm_id_from=333.337.search-card.all.click&vd_source=d21b5a63a1eab7ffc0276b7427ed223d

例题：
743

第二个S表填的是从i到j的路径到达j点的前驱点

初始化的时候
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
////                w[i][j] = w[j][i] = i == j ? 0 : INF; //这个初始化操作很重要
//                w[i][j] = w[j][i] = i == j ? 0 : Integer.MAX_VALUE;
//            }
//        }

     for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }
a-a 最短距离 是 0 否则是 INF
![img.png](img.png)