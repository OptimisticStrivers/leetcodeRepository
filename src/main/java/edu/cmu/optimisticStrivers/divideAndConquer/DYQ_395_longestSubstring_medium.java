package edu.cmu.optimisticStrivers.divideAndConquer;

/**
 * @ClassName: DYQ_395_longestSubstring_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 5:59 PM
 * @Version 1.0
 */
public class DYQ_395_longestSubstring_medium {

    //    分治思路：
//
//    对于当前String s，历遍并将所有字符进行出现次数记录
//    重新历遍String，如果发现其出现次数少于k，以当前i前后分别再调用
//    longestSubstring(s.substring(0,i),k)以及
//    longestSubstring(s.substring(i+1,s.length()),k)并取二者较大值
//    如果没有小于k的字符，直接返回当前string长度
//            完成分治之后直接返回
    public int longestSubstring(String s, int k) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)-'a'] < k) { //只要是分裂点 当前串s一定是不合法的 所以检验两边字串的合法字串 谁长
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(i + 1), k));
            }
        }
        return s.length();

    }
}
