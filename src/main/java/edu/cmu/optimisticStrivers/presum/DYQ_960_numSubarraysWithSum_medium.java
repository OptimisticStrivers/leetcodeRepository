package edu.cmu.optimisticStrivers.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DYQ_960_numSubarraysWithSum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 4:52 下午
 * @Version 1.0
 */
public class DYQ_960_numSubarraysWithSum_medium {

    //和560很像


    public static int numberOfSubarrays(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int preCount = 0;
        map.put(0, 1);
        for (int num : nums) {
            if(num%2==1){
                preCount++;
                if(map.containsKey(preCount-k)){
                    count += map.get(preCount-k);
                }
            }
            map.put(preCount,map.getOrDefault(preCount,0)+1);
        }
        return count;
    }


}
