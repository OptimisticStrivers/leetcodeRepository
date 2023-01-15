package edu.cmu.optimisticStrivers.graph.graphDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_93_restoreIPAddress_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/8 7:35 PM
 * @Version 1.0
 */
public class DYQ_93_restoreIPAddress_medium {

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() > 12 || s.length() < 4) {
            return res;
        }
        build(res, s, 4, 0, new StringBuilder());
        return res;
    }

    private static void build(List<String> res, String s, int remainPart, int startIndex, StringBuilder sb) {
        if (s.length() - startIndex < remainPart || s.length() - startIndex > remainPart * 3) { //不够或者溢出
            return;
        }
        if (remainPart == 0 && startIndex == s.length()) { //i - 1，2，3 只有1这个我们加入res
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        if (remainPart <= s.length() - startIndex) {
            for (int i = 1; i <= 3; i++) { //当前part取几位
                if (startIndex + i > s.length()) {
                    continue;
                }
                String newPart = s.substring(startIndex, startIndex + i);
                boolean isValidPart = true; //判断其中有没有非 0-9 的字符, 判断是否在0-255
                for (int j = 0; j < newPart.length(); j++) {
                    if (newPart.charAt(j) > '9' || newPart.charAt(j) < '0') {
                        isValidPart = false;
                        break;
                    }
                }
                if (isValidPart && newPart.charAt(0) == '0' && newPart.length() > 1) { //有前导0 就不行 但是要排除 0000这种情况
                    isValidPart = false;
                }
                int newPartInt = Integer.parseInt(newPart);
                if (isValidPart && newPartInt < 0 || newPartInt > 255) {
                    isValidPart = false;
                }
                if (!isValidPart) {
                    continue;
                }
                int tempIndex = sb.length();
                //可以先放 但是不保证 后面可以 所以回溯
                sb.append(newPart).append(".");
                build(res, s, remainPart - 1, startIndex + i, sb);
                sb.delete(tempIndex, sb.length());
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("023")); //这个会变成23 所以要检验下
//        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
    }
}
