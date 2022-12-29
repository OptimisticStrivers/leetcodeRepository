package edu.cmu.optimisticStrivers.bitManipulation;

/**
 * @ClassName: BitRotate
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/4 12:29 PM
 * @Version 1.0
 */
public class BitRotate {


//    rotate N-bit X left by K bits
    //10100 -> 2     ->  10010
    public static int leftRotate(int num, int n) {
        int len = Integer.toBinaryString(num).length();
        int wrapped = num >>> (len - n);
        System.out.println(" wrapped " + Integer.toBinaryString(wrapped));
        num <<= n;
        System.out.println(" num  " + Integer.toBinaryString(num));
        return num | wrapped;  //并没有截断 啊 现在结果是 10 10010
    }


    public static void main(String[] args) {
        int target = 20;
        System.out.println("target  " + Integer.toBinaryString(target));
        int res = leftRotate(target, 2);
        System.out.println("res     " + Integer.toBinaryString(res));
    }

    static boolean bit(long V, int N) {
        long num = 1L << N; //这里必须是1L 否则是int运算 会有截断

        return (V & num) == num;
    }
}
