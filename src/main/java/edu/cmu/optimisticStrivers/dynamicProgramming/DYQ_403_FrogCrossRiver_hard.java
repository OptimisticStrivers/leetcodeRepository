package edu.cmu.optimisticStrivers.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DYQ_403_FrogCrossRiver_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/7 6:57 下午
 * @Version 1.0
 */
public class DYQ_403_FrogCrossRiver_hard {

//    如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
//    [0,1,3,5,6,8,12,17]

    //https://leetcode-cn.com/problems/frog-jump/solution/gong-shui-san-xie-yi-ti-duo-jie-jiang-di-74fw/

    //拉胯的dfs
    Map<Integer, Integer> map = new HashMap<>();
    public boolean canCross_dfs(int[] ss) {
        int n = ss.length;
        // 将石子信息存入哈希表
        // 为了快速判断是否存在某块石子，以及快速查找某块石子所在下标
        for (int i = 0; i < n; i++) {
            map.put(ss[i], i);
        }
        // check first step
        // 根据题意，第一步是固定经过步长 1 到达第一块石子（下标为 1）
        if (!map.containsKey(1)) return false;
        return dfs(ss, ss.length, 1, 1);
    }

    private boolean dfs(int[] ss, int n, int u, int k) {
        if(u == n-1) return true; //树底
        for (int i = -1; i <= 1 ; i++) {
            if(k+i==0) continue; //不允许原地踏步
            int next = u + k + i;
            if(map.containsKey(next)){
                boolean cur = dfs(ss,n,next,k+i);
                if(cur) return true;
            }
        }
        return false;
    }

    Map<Integer, Integer> map1 = new HashMap<>();
    // int[][] cache = new int[2009][2009];
    Map<String, Boolean> cache1 = new HashMap<>();
    //记忆化搜索
    public boolean canCross_dfs1(int[] ss) {
        int n = ss.length;
        for (int i = 0; i < n; i++) {
            map1.put(ss[i], i);
        }
        if (!map1.containsKey(1)) return false;
        return dfs1(ss, ss.length, 1, 1);
    }

    private boolean dfs1(int[] ss, int n, int u, int k) { //u是index，k是到u的上一步跳的距离
        String a = u + "_" + k;
        if(cache1.containsKey(a)) return cache1.get(a);
        if(u == n-1) return true; //树底
        for (int i = -1; i <= 1 ; i++) {
            if(k+i==0) continue; //不允许原地踏步
            int next = ss[u] + k + i;
            if(map1.containsKey(next)){ //contains 就代表可以向后跳
                boolean cur = dfs1(ss,n,map1.get(next),k+i);
                cache1.put(a, cur);
                if(cur) return true; //能继续以k+i走，并且可以走到头
            }
        }
        cache1.put(a,false); //已经到达u,以k的上一步跳跃距离，但是接着走不下去了
        return false;
    }


    //dp
    public boolean canCross(int[] ss) {
        int n = ss.length;
        // check first step
        if (ss[1] != 1) return false;
        boolean[][] f = new boolean[n + 1][n + 1];
        f[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int k = ss[i] - ss[j];
                // 我们知道从位置 j 到位置 i 是需要步长为 k 的跳跃
                // 而从位置 j 发起的跳跃最多不超过 j + 1
                // 因为每次跳跃，下标至少增加 1，而步长最多增加 1
                if (k <= j + 1) {
                    f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (f[n - 1][i]) return true;
        }
        return false;
    }



}
