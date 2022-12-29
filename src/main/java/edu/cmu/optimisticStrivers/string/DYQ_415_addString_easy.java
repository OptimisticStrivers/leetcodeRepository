package edu.cmu.optimisticStrivers.string;

/**
 * @ClassName: DYQ_415_addString_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/26 8:15 PM
 * @Version 1.0
 */
public class DYQ_415_addString_easy {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carrier = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carrier != 0; i--, j--) {
            int a = i>=0 ? num1.charAt(i) - '0' : 0;
            int b = j>=0 ? num2.charAt(j) - '0' : 0;
            int val = a + b + carrier;
            sb.append(val%10);
            carrier = val/10;
        }
        return sb.reverse().toString();
    }
}
