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

    public static int subarraysDivByK(int[] nums, int k) {
//        nums = [4,5,0,-2,-3,1], k = 5

//        二、同余定理
//        几个整数除以同一个除数，若余数相同，则这几个整数同余。
//        1.余数的和决定和的余数。
//        2.余数的差决定差的余数。  负数也可以  -1,2,3   k = 2
//        3.余数的积决定积的余数。
//        4.余数的幂决定幂的余数。


        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int preSum = 0;
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            int remainder = (preSum % k + k) % k;
            if (map.containsKey(remainder)) {
                res += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{4,5,0};
        int[] a = new int[]{4, 5};
        System.out.println(subarraysDivByK(a, 5));
    }

//    [4, 5, 0, -2, -3, 1],
//            [5],
//            [5, 0],
//            [5, 0, -2, -3],
//            [0],
//            [0, -2, -3],
//            [-2, -3]
}
