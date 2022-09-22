package edu.cmu.optimisticStrivers.bootcamp;

import java.util.Arrays;

/**
 * @ClassName: E1P1_Pangram
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/4 2:43 PM
 * @Version 1.0
 */
public class E1P1_Pangram {


    static String isPangram(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            int[] count = new int[26];
            for (char c : string.toCharArray()) {
                if(c != ' '){
                    count[c - 'a'] = 1;
                }
            }
            if (Arrays.stream(count).sum() == 26) {
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
        }
        return stringBuilder.toString();
    }
}
