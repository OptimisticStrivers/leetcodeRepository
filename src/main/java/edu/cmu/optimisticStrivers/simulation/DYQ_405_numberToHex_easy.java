package edu.cmu.optimisticStrivers.simulation;

/**
 * @ClassName: DYQ_405_numberToHex_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/28 12:22 PM
 * @Version 1.0
 */

//https://blog.csdn.net/q495745324/article/details/125462067
//正数的原码、反码、补码等于它二进制的本身
//而一个负数的原码就是在最高位（也就是符号位）写1，反码就是符号位为1，其余数字对原码取反，补码就是对反码的最后一位+1
//在计算机中，数字都是以二进制补码的方式存储。



public class DYQ_405_numberToHex_easy {
//    给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用补码运算方法。
//    注意:
//    十六进制中所有字母(a-f)都必须是小写。
//    十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
//    给定的数确保在32位有符号整数范围内。
//    不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
//    示例 1：
//    输入: 26
//    输出:"1a"
//    示例 2：
//    输入: -1
//    输出:"ffffffff"

    public static String toHex(int num) {
        final int BITS = 32, GROUP_SIZE = 4, MASK = 0xf;
        StringBuffer hex = new StringBuffer();
        for (int i = BITS - GROUP_SIZE; i >= 0; i -= GROUP_SIZE) {
            int digit = (num >> i) & MASK; //用 逻辑右移 或者 无符号右移 都无所谓的 因为只要低四位
            if (hex.isEmpty() && digit == 0) { //只有第一个16进制的0被跳过了
//                System.out.println("skip");
                continue;
            }
            char c = digit < 10 ? (char) ('0' + digit) : (char) ('a' + digit - 10);
            hex.append(c);
//            System.out.println(hex.toString());
        }
        return hex.isEmpty() ? "0" : hex.toString();
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(26));
//        System.out.println(toHex(26));

        System.out.println(Integer.toBinaryString(-2));
        System.out.println(toHex(-2));
    }

}
