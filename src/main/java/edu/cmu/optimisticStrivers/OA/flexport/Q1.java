package edu.cmu.optimisticStrivers.OA.flexport;

import java.util.Scanner;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/11/16 9:54 PM
 * @Version 1.0
 */
public class Q1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        nextInt 会滤掉 换行 空格什么的 直到nextInt
//        字母 会爆 InputMisMatchException
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a + b);

    }
}
