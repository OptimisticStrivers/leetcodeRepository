package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_400_NthDigit_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/7 10:09 AM
 * @Version 1.0
 */
public class DYQ_400_NthDigit_medium {


//    The 11
//    th digit
//    of the
//    sequence 1,2,3,4,5,6,7,8,9,10,11,...
//    is a 0,
//    which is
//    part of
//    the number 10.


    public int findNthDigit(int n) {

//        简单位数统计模拟题
//        https://leetcode.cn/problems/nth-digit/solution/gong-shui-san-xie-jian-dan-mo-ni-ti-by-a-w5wl/


        //1位数有 1-9 9 个数字   9个digit
        //2位数有 10-99 90个数字  180个digit
        //3位数有 100-999 900个数字  1800个digit


        //先定位到 n个digit 在长度为几的 位数数字群里
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }
        //此时len就是应该在的数字群的数字长度
        long s = (long) Math.pow(10, len - 1);//这个长度为len 的数字群 的起始数字 s
        //还需要往后多少个数字
        System.out.println("n " + n);
        s += n / len - 1; //因为n所统计的digits 现在包括s本身，所以要减去1
        System.out.println("s " + s);
        //同时把n也减掉
        n -= len * (n / len);
        System.out.println("n " + n);
        //n有两种情况 整除 说明 当前s的最后一位就是我们要的数字
        //或者n还剩余 > 0 则 s的下一个数字 往后推n位即可   例如 下一个数字是143 n为2 想获得4 : 143/(10^(3-2)%10)
//如果试减后结果恰好为 00，那么答案为当前 ss 的最后一个数字；否则（试减结果大于 00），则是 x + 1x+1 中（十进制表示，从左往右数）的第 nn 个数字。

//        return n == 0 ? (int) s % 10 : (s + 1) / Math.pow(10, len);

        return n == 0 ? (int) (s % 10) : (int) ((s + 1) / Math.pow(10, len - n) % 10);

    }

    public static void main(String[] args) {
//        System.out.println(10%10);

        DYQ_400_NthDigit_medium dyq_400_nthDigit_medium = new DYQ_400_NthDigit_medium();
//        System.out.println(dyq_400_nthDigit_medium.findNthDigit(10));


        int s = 142;
        int len = 3;
        int n = 2;

        System.out.println((int) ((s + 1) / Math.pow(10, len - n) % 10));
        // s + 1 = 143
        // Math.pow(10, 3 - 2) = 10;
        // 143/10 即 右边移动1位
        // 然后%10 找到最后一位 4
    }
}


