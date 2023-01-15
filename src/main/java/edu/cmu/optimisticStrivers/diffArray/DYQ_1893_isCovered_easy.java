package edu.cmu.optimisticStrivers.diffArray;

/**
 * @ClassName: DYQ_1893_isCovered_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/5 4:23 PM
 * @Version 1.0
 */
public class DYQ_1893_isCovered_easy {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        //对差分数组进行处理
        for(int i = 0; i < ranges.length; i++){
            diff[ranges[i][0]]++;
            diff[ranges[i][1]+1]--;
        }
        //根据差分数组处理前缀和，为理解方便单独定义sum，可以原地做
        int[] sum = new int[52];
        for(int i = 1; i <= 51; i++){
            sum[i] = sum[i-1] + diff[i];
        }
        //从left到right判断是否满足sum > 0
        for(int i = left; i <= right; i++){
            if(sum[i] <= 0) return false;
        }
        return true;
    }

//    https://leetcode.cn/problems/check-if-all-the-integers-in-a-range-are-covered/solution/yi-ti-san-jie-bao-li-you-hua-chai-fen-by-w7xv/
//    所以差分数组前缀和不仅能查询是否被覆盖，还能查询某一区间被覆盖几次。



    //直接把差分数组 和 前缀合结合起来
    public static boolean isCovered1(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int i = 0; i < ranges.length; i++) {
            diff[ranges[i][0]]++;
            diff[ranges[i][1] + 1]--;
        }
        int sum = 0;
        for (int i = 0; i <= 51; i++) { //这里其实 1 到 50就可以 因为差分数组是前闭后开
            sum += diff[i];
            if (left <= i && i <= right && sum == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCovered1(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
    }
}
