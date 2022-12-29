package edu.cmu.optimisticStrivers.bitManipulation;

/**
 * @ClassName: Manipulation
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/4 12:11 PM
 * @Version 1.0
 */
public class Manipulation {

    public static void main(String[] args) {

//
//        Integer a = 20;
//        System.out.println("origin: " + Integer.toBinaryString(a));
//        for (int i = 1; i < 10; i++) {
//            System.out.println("算数右移动 : " + i + " 位: " + Integer.toBinaryString(a >> i));
//        }

        Integer zero = 0;
        System.out.println("0   : " + Integer.toBinaryString(zero));
        Integer negativeOne = -1;
        System.out.println("-1  : " + Integer.toBinaryString(negativeOne)); //1取反 + 1
        Integer negativeTwo = -2;
        System.out.println("-2  : " + Integer.toBinaryString(negativeTwo)); //2取反 + 1

        System.out.println("Integer.max   " + Integer.toBinaryString(Integer.MAX_VALUE) + "  " + Integer.MAX_VALUE);
        System.out.println("Integer.min   " + Integer.toBinaryString(Integer.MIN_VALUE) + "  " + Integer.MIN_VALUE);


        Integer b = -20;
        System.out.println("origin: " + Integer.toBinaryString(b));
        for (int i = 1; i < 10; i++) {
            System.out.println("算数右移动 : " + i + " 位: " + Integer.toBinaryString(b >> i));
        }

    }
}
