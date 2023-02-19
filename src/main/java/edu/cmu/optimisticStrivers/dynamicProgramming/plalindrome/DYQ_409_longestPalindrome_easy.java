package edu.cmu.optimisticStrivers.dynamicProgramming.plalindrome;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName: DYQ_409_longestPalindrome_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 1:05 PM
 * @Version 1.0
 */
public class DYQ_409_longestPalindrome_easy {

    public static int longestPalindrome(String s) {

        int[] ints = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                ints[c - 65]++;
            } else {
                ints[c - 97 + 26]++;
            }
        }
        System.out.println(Arrays.toString(ints));
        int num = 0;
        int hasOne = 0;
        for (int anInt : ints) {
            if (anInt % 2 == 1) {
                hasOne = 1;
            }
            num += anInt % 2 == 0 ? anInt : anInt - 1;
        }
        return num + hasOne;

    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("aaaAaaaa"));
    }

    public int longestPalindrome1(String s) {
        HashSet<Character> set = new HashSet<>();
        //2. ans to record paried char
        int ans = 0;
        //3. pair char
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                ans += 2;
            } else {
                set.add(s.charAt(i));
            }
        }
        return (set.isEmpty() ? ans : ans + 1);
    }


}
