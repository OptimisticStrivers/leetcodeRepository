package edu.cmu.optimisticStrivers.slidingWindow;

import java.util.HashMap;

/**
 * @ClassName: DYQ_76_minWindow_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 6:27 PM
 * @Version 1.0
 */
public class DYQ_76_minWindow_hard {

    //438 先看下 再看76

    //要求O(M+N) 说明 one pass
    //双指针 滑动窗口

    public String minWindow(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        // needs是需要的字符和数量，window记录窗口中有效的字符和数量
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // valid 变量表示窗口中满足 need 条件的字符个数
        int valid = 0;
        int left = 0, right = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        for (char c : t) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 进行窗口内数据的一系列更新
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1); //无论如何 只要需要 就先放进去 这样才能缩小嘛
                // ⭐注意：两个Integer类型的数据不能直接用< == >判断
                if (window.get(c).equals(needs.get(c))) {
                    valid++; //一个所需字符的个数已经满足了
                }
            }

            // 判断左侧窗口是否要收缩 一直收缩左边就行
            while (valid == needs.size()) {
                // 在这里更新最小覆盖子串(更新最终结果)
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left + 1;
                }
                // d 是将移要出窗口的字符
                char d = s[left];
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (needs.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    // window窗口内的数据无法满足，不再有效
                    // ⭐注意：两个Integer类型的数据不能直接用< == >判断
                    if (window.get(d) < needs.get(d)) {
                        valid--;
                    }
                }
            }
            // 扩大窗口
            right++;
        }

        // 返回最小覆盖子串(使用三目运算使代码简洁)
        return len == Integer.MAX_VALUE ? "" : source.substring(start, start + len);
    }

//
//    public static void main(String[] args) {
//        System.out.println(minWindow("aa"
//                , "a"));
//    }
}
