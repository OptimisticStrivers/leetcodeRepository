package edu.cmu.optimisticStrivers.slidingWindow;

/**
 * @ClassName: DYQ_3_longesstSubstringWithNoDuplicates_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/16 6:34 PM
 * @Version 1.0
 */
public class DYQ_3_longesstSubstringWithNoDuplicates_easy {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        boolean[] dict = new boolean[128];
        int max = 1;
        int i = 0;
        dict[s.charAt(0)] = true;
        for (int j = 1; j < s.length(); j++) {
            if (dict[s.charAt(j)]) {
//                System.out.println(s.charAt(j));
                while (s.charAt(i) != s.charAt(j)) {
                    dict[s.charAt(i)] = false;
                    i++;
                }
                i++;
            }
            dict[s.charAt(j)] = true;
//            System.out.println(j + " " + i);
            max = Math.max(j - i + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
