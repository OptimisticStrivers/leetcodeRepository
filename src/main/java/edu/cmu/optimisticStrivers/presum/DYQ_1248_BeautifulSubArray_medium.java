package edu.cmu.optimisticStrivers.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DYQ_1248_BeautifulSubArray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 5:00 下午
 * @Version 1.0
 */
public class DYQ_1248_BeautifulSubArray_medium {

    //1248. 统计「优美子数组」

//    给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。


    //其实这种连续子数组感觉和dp有点像，但是还不完全一样，因为没有状态转移，这种连续子数组是中间一段段

    //比如 {2,2,2,1,2,2,1,2}; 2 这个 和
    // 哈  {2,2,2,1,2,2,1,2,2} 最后一个2可以在前面所有状态的基础上转移吗，不可以

    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int preCount = 0;
        map.put(0, 1);
        for (int num : nums) {
            if(num%2==1){
                preCount++;
            }
            if(map.containsKey(preCount-k)){ //必须放在if外面
                count += map.get(preCount-k);
            }
            map.put(preCount,map.getOrDefault(preCount,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,2,2,1,2,2,1,2,2,2};
//        int[] a = new int[]{2,2,2,1,2,2,1,2};

        System.out.println("res "+ numberOfSubarrays(a,2));
    }

}


