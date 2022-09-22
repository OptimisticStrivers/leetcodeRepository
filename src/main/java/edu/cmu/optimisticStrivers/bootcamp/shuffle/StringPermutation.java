package edu.cmu.optimisticStrivers.bootcamp.shuffle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: StringPermutation
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/8 10:00 AM
 * @Version 1.0
 */
public class StringPermutation {

    //ascii 排序
    public boolean check1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i] != chars2[i]) return false;
        }
        return true;
    }


    //map

    public boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c,map.get(c)-1);
                if(map.get(c) < 0) return false;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        System.out.println(stringPermutation.check("apple","ppale"));
        System.out.println(stringPermutation.check1("apple","ppale"));
    }
}
