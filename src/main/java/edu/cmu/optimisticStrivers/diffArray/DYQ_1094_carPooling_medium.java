package edu.cmu.optimisticStrivers.diffArray;

/**
 * @ClassName: DYQ_1094_carPooling_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/5 5:23 PM
 * @Version 1.0
 */
public class DYQ_1094_carPooling_medium {

//    https://leetcode.cn/problems/car-pooling/solution/chai-fen-shu-zu-qian-zhui-he-yong-chai-f-8zlk/
//    此处建立差分数组diff,遍历到trips[i]时,diff[trips[i][1]]加上该地上车的乘客数目trips[i][0]
//    表示比上一位置增加了这么多乘客,在diff[trip[i][2]]处减去trips[i][0]表示乘客已下车，
//    那么数组diff的前缀和prefixSum[i]就表示i处的当前乘客数目，如果超过容量capacity就不能完成任务了。

    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for(int[] ints : trips){
            diff[ints[1]] += ints[0];
            diff[ints[2]] -= ints[0];
        }
        int sum = 0;
        for(int i = 0; i<=1000; i++){
            sum+=diff[i];
            if(sum > capacity){
                return false;
            }
        }
        return true;
    }
}
