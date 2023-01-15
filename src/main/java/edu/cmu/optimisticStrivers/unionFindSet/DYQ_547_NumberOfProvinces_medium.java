package edu.cmu.optimisticStrivers.unionFindSet;

/**
 * @ClassName: DYQ_547_NumberOfProvinces_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/14 2:56 PM
 * @Version 1.0
 */
public class DYQ_547_NumberOfProvinces_medium {

    int[] p;
    int count;

    int find(int i) {
        return p[i] == i ? i : (p[i] = find(p[i]));
    }

    void union(int i, int j) {
        int fi = find(i);
        int fj = find(j);
        if (fi == fj) {
            return;
        }
        p[fi] = fj;
        count--;
    }

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        p = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = i;
        }
        count = len;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(isConnected[i][j] == 1){
                    union(i,j);
                }
            }
        }
        return count;
    }
}
