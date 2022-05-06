package edu.cmu.optimisticStrivers.linkedList;

import java.util.HashSet;

public class CXY_3_LongestSubstring_medium {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        int start = 0;
        int end = 1;
        int maxlen = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(start));
        while (true) {
            while (end < s.length() && (!(set.contains(s.charAt(end))))) {
                set.add(s.charAt(end));
                end++;
            }
            if(maxlen<(end-start)){
                maxlen = end-start;
            }
            if(end>=s.length()){
                return maxlen;
            }
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
        }
    }
}
