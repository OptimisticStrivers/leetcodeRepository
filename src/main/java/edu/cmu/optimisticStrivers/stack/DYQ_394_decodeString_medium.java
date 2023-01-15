package edu.cmu.optimisticStrivers.stack;

import java.util.Stack;

/**
 * @ClassName: DYQ_394_decodeString_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 11:07 AM
 * @Version 1.0
 */
public class DYQ_394_decodeString_medium {

    //这个题 我觉得 递归 比 两个栈好些

//    输入：s = "x3[a2[c]]"
//    输出："xaccaccacc"


    //借用两个辅助栈 一个存要乘的数字 一个存之前的还要添加的字符串
    public static String decodeString(String s) {
        Stack<Integer> stackForNum = new Stack<>();
        Stack<String> stackForPreviousString = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
//                x3[a2[c]]
                //保存前面的String 保存 x
                stackForPreviousString.push(sb.toString());
                sb = new StringBuilder(); //clear
                //保存前面的数字  保存 3
                stackForNum.push(num);
                num = 0; //clear
            } else if (c == ']') {
                String previousString = stackForPreviousString.pop();  // a x
                int number = stackForNum.pop(); // 2 3
                StringBuilder newSB = new StringBuilder();
                while (number-- > 0) {
                    newSB.append(sb);
                }
                sb = new StringBuilder(previousString + newSB);
            } else if ('0' <= c && c <= '9') {
                //数字不只是个位数
                num = num * 10 + Integer.parseInt(c + "");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    //递归也是一样的思路
    public static String decodeString_recur(String s) {
        return dfs(s, 0)[0];
    }

    //只有遇到新的[才会进递归
    public static String[] dfs(String s, int i) {
        System.out.println(i);
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;//保存下一轮的乘数
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                num = num * 10 + Integer.parseInt(c + "");
            } else if (c == '[') {
                String[] res = dfs(s, i + 1);
                i = Integer.parseInt(res[0]); //']'的位置 for就会++
                System.out.println(num + "! !  " + res[1] + " !");
                while (num > 0) {
                    stringBuilder.append(res[1]);
                    num--;
                }
                System.out.println(num + "! !  " + res[1] + " !");

            } else if (c == ']') {
//                System.out.println(i + " !!");
                return new String[]{String.valueOf(i), stringBuilder.toString()}; //到那里了
            } else {
                stringBuilder.append(c);
            }
        }
        return new String[]{stringBuilder.toString()};
    }


    public static void main(String[] args) {
//        System.out.println(decodeString_recur("3[a]2[b]"));


//        for (int i = 0; i < 10 ; i++) {
//            System.out.println(i);
//            if(i == 5){
//                i++;
//            }
//
//        }
//
//        int i = 3;
//        while (i > 0){ //先比较 后-- 所以有 0
//            System.out.println(i);
//            i--;
//        }
//
//        int i = 3;
//        while (--i > 0) { //先比较 后-- 所以有 0
//            System.out.println(i);
////            i--;
//        }
//        System.out.println(i);
    }
}
