package edu.cmu.optimisticStrivers.dynamicProgramming.plalindrome;

/**
 * @ClassName: DYQ_125_isPalindrome_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 1:26 PM
 * @Version 1.0
 */
public class DYQ_125_isPalindrome_easy {

    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}
