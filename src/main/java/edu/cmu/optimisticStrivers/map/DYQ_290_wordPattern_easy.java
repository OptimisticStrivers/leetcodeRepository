package edu.cmu.optimisticStrivers.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DYQ_290_wordPattern_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/7 12:50 PM
 * @Version 1.0
 */
public class DYQ_290_wordPattern_easy {


//    java+hashMap 这道题说的是对应关系，那首先想到的集合就是Map，将key（a）-value（dog）存在一起，每当遇到一个字母就去查看对应的单词。
//    失败有两种情况： 1.key存在，经过查找字母对应的单词和这个单词不匹配； 2.key不存在，但是这个单词已经被存了；
//    第二种情况要特别注意下
    public boolean wordPattern(String pattern, String s) {
        int len = pattern.length();
        Map<Character, String> map = new HashMap<>();
        String[] strings = s.split(" ");

        if(pattern.length() != strings.length) return false;

        char[] chars = pattern.toCharArray();
        for (int i = 0; i < len; i++) {
            char curChar = pattern.charAt(i);
            if (map.containsKey(curChar)) {
//                System.out.println(i + " " + curChar);
                if (!map.get(curChar).equals(strings[i])) { //情况一
                    return false;
                }
            } else { //key不存在的时候
                if(map.containsValue(strings[i])){ //情况二
                    return false;
                }
                map.put(curChar, strings[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DYQ_290_wordPattern_easy dyq_290_wordPattern_easy = new DYQ_290_wordPattern_easy();
        System.out.println(dyq_290_wordPattern_easy.wordPattern("abba", "dog dog dog dog"));
    }
}
