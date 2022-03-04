package edu.cmu.optimisticStrivers.dynamicProgramming.backpack.backpackComplete;

import java.util.List;

/**
 * @ClassName: DYQ_139_WordBreak_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/21 3:51 下午
 * @Version 1.0
 */
public class DYQ_139_WordBreak_medium {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            for(String word : wordDict){
                int len  = word.length();
                // dp[i][j],表示前i个单词，是否可以组成长度为j的字符串，由于每个字符串都需所有的单词组合一遍，
                // 因此将背包重量的循环放到物品个数的循环之前。
                if(i>=len && s.substring(i-len,i).equals(word)){
                    dp[i] |= dp[i-len];
                }
            }
        }
        return dp[n];
    }
}
