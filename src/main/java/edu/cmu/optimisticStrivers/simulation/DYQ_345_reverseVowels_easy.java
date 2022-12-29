package edu.cmu.optimisticStrivers.simulation;

import java.util.HashSet;

/**
 * @ClassName: DYQ_345_reverseVowels_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/28 11:51 AM
 * @Version 1.0
 */
public class DYQ_345_reverseVowels_easy {

    static HashSet<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }

    public static String reverseVowels(String s) {
        int l = 0;
        int r = s.length()-1;
        char[] chars = s.toCharArray();
        while (l < r) {
            while (l < r && !set.contains(chars[l]) ) l++;
            while (l < r && !set.contains(chars[r])) r--;
            char swap = chars[l];
            chars[l] = chars[r];
            chars[r] = swap;
            l++;
            r--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }


}
