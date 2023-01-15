package edu.cmu.optimisticStrivers.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DYQ_438_findAnagrams_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 7:41 PM
 * @Version 1.0
 */
public class DYQ_438_findAnagrams_medium {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int n1 = s.length();
        int n2 = p.length();
        if (n2 > n1) {
            return res;
        }
        int[] sInt = new int[26];
        int[] pInt = new int[26];
        for (int i = 0; i < n2; i++) {
            sInt[s.charAt(i) - 'a']++;
            pInt[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sInt, pInt)) { //顺序相同 且元素值相同
            res.add(0);
        }
        for (int i = n2; i < n1; i++) { //从第一个pattern往后走吧
            sInt[s.charAt(i - n2) - 'a']--;
            sInt[s.charAt(i) - 'a']++;
            if (Arrays.equals(sInt, pInt)) {
                res.add(i - n2 + 1); //起始索引 是 i-n2的下一个
            }
        }
        return res;
    }

}
