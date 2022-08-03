package edu.cmu.optimisticStrivers.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: DYQ_301_removeInvalidParentheses_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/31 12:36 下午
 * @Version 1.0
 */
public class DYQ_301_removeInvalidParentheses_hard {


    int maxCount;
    int maxlen;
    int score;
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int length = s.length();
        int left  = 0;
        int right = 0;
        for(int i = 0;i < length;i++){
            /**
             * 统计共有多少个 左括号 和 右括号！
             */
            if('(' == s.charAt(i)){
                left++;
            }else if(')' == s.charAt(i)){
                right++;
            }
        }
        /**
         * 选用出 最大的合法括号个数，即左括号和右括号中个数较少的一个！
         * 因为合法的括号一定是成对出现的！
         */
        maxCount = Math.min(left, right);
        dfs(s,0,"",0);
        return new ArrayList<>(set);
    }
    void dfs(String s,int index,String current,int score){
        if(score < 0 || score > maxCount){
            /**
             * 小于0说明遍历到了 ')' 但是前面没有 ‘(’ 所以不合法提前结束！
             * 大于max，说明后面没有足够数量的')' 和前面的'('匹配了 ，所以也不合法，提前结束！
             */
            return;
        }
        if(index == s.length()){
            /**
             * 说明遍历到了最后一个字符！
             */
            if(score == 0 && current.length() >= maxlen){
                /**
                 * 等于0，说明刚好左右括号匹配合法！！！！
                 * 如果合法，且大于前面已经遍历过合法的字符串长度，则更新最长合法长度！
                 */
                if(current.length() > maxlen){
                    /**
                     * 如果是大于原来长度，则需要先清空原来合法长度答案
                     * 如果是等于，则在原来合法长度答案基础上继续添加子答案！
                     */
                    set.clear();
                }
                set.add(current);
                maxlen = current.length();
            }
            return;
        }
        char c = s.charAt(index);
        if(c == '('){
            /**
             * 有可能选用这个‘(’，则传入  current + String.valueOf(c),因为增加了一个左括号，所以分数要加1
             * 如果不选用这个'('，则直接传入原来字符即可，即不带这个‘(',所以不影响前面合法性，所以分数不变！
             * 下面右括号同理！
             */
            dfs(s,index + 1,current + String.valueOf(c), score + 1);
            dfs(s,index + 1,current, score);
        }else if(c == ')'){
            dfs(s,index + 1,current + String.valueOf(c), score - 1);
            dfs(s,index + 1,current, score);
        }else{
            /**
             * 说明是 字母字符，不影响括号字符合法性！！！所以score分数不变！
             */
            dfs(s,index + 1,current + String.valueOf(c), score);
        }
    }

}
