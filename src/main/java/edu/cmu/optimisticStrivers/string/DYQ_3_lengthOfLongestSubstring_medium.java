package edu.cmu.optimisticStrivers.string;

import java.util.Arrays;

/**
 * @ClassName: DYQ_3_lengthOfLongestSubstring_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/31 2:41 下午
 * @Version 1.0
 */
public class DYQ_3_lengthOfLongestSubstring_medium {


    //关键就是这个128
    //0-127就是大部分的字符
//     s 由英文字母、数字、符号和空格组成
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        Arrays.fill(index,-1);
        int start = 0;
        int res = 0;
        for(int i = 0; i<s.length(); i++){
            int pos = s.charAt(i);
            start = Math.max(start, index[pos]+1);
            res = Math.max(res, i-start+1);

            index[pos] = i;

        }
        return res;
    }
}
