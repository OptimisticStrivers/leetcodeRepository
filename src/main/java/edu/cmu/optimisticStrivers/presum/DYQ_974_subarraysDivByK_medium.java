package edu.cmu.optimisticStrivers.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DYQ_974_subarraysDivByK_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 5:34 下午
 * @Version 1.0
 */
public class DYQ_974_subarraysDivByK_medium {

//        nums = [4,5,0,-2,-3,1], k = 5

//        二、同余定理
//        几个整数除以同一个除数，若余数相同，则这几个整数同余。
//        1.余数的和决定和的余数。
//        2.余数的差决定差的余数。  负数也可以  -1,2,3   k = 2
//        3.余数的积决定积的余数。
//        4.余数的幂决定幂的余数。

    //和523有点不同 可以有负数 而且 一个value存数量 一个 存最远index
    public static int subarraysDivByK(int[] A, int K) {
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n : A) {
            sum += n;
            int curMod = (sum % K + K) % K;
//            [-1,2,9] 2 应该有两个满足条件的子数组 2 和 -1 2 9
//            int curMod = sum % K; //-1的余数必须是1 才能 把 9和-1之间的2 掏出来
            int preCount = map.getOrDefault(curMod, 0);
            result += preCount;
            map.put(curMod, preCount + 1);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(-1 % 2); //-1
        int[] a = new int[]{-1, 2, 9};
        System.out.println(subarraysDivByK(a, 2));
    }

//    [4, 5, 0, -2, -3, 1],
//            [5],
//            [5, 0],
//            [5, 0, -2, -3],
//            [0],
//            [0, -2, -3],
//            [-2, -3]
}
