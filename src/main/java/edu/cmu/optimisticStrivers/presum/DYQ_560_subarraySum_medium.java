package edu.cmu.optimisticStrivers.presum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: DYQ_560_subarraySum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 4:45 下午
 * @Version 1.0
 */
public class DYQ_560_subarraySum_medium {

//    子串，子数组：必须连续
//
//    子序列：可以不连续



//    560. 和为 K 的子数组
//   leetcode 930. 和相同的二元子数组

    //枚举 o(n2)
//    普通前缀和 o(n2)

    // 哈希表+前缀和 (O1 + O(
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
        //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
        //输入：[3,1,1,0] k = 2时则不会漏掉
        //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int x : nums) {
            presum += x;
            //当前前缀和已知，判断是否含有 presum - k的前缀和，那么我们就知道某一区间的和为 k 了。
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);//获取次数
            }
            //更新
            map.put(presum,map.getOrDefault(presum,0) + 1);
        }
        return count;
    }


}
