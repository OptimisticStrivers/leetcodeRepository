package edu.cmu.optimisticStrivers.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DYQ_523_checkSubarraySum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/25 10:21 下午
 * @Version 1.0
 */
public class DYQ_523_checkSubarraySum_medium {


    //和974很像，都用了同余定理，但是put map的时候有细微区别

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(0,-1);
        for(int i = 0; i<nums.length; i++){
            preSum += nums[i];
            int remainder = (preSum%k+k)%k;
            if(map.containsKey(remainder)){ //前面contain的话，我们就用那个，因为最远！
                if(i-map.get(remainder)>1){
                    return true;
                }
            }else{
                //这个和之间的974有些不同
                map.put(remainder,i); //前面没有的话再放
            }
        }
        return false;
    }
}
