package edu.cmu.optimisticStrivers.bootcamp.shuffle5.src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/8 4:31 PM
 * @Version 1.0
 */
public class Q2 {
//
//    10.1 Sorted Merge: You are given two sorted arrays,
//    A and B, where A has a large enough buffer at the end to hold B.
//    Write a method to merge B into A in sorted order.
//
//
//        A 12

//  b -> a
//
    Queue<Integer> a = new LinkedList<>();

    public int[] sort(int[] a, int[] b, int al, int bl) {
        int[] res = new int[al + bl];
        int pointA = 0;
        int pointB = 0;
        int counter = 0;
        while (pointA < al && pointB < bl) {
            int curIntA = a[pointA];
            int curIntB = b[pointB];
            if (curIntA < curIntB) {
                res[counter++] = curIntA;
                pointA++;
            } else {
                res[counter++] = curIntB;
                pointB++;
            }
        }
        if (pointA == al) {
            for (int i = pointB; i < bl; i++) {
                res[counter++] = b[i];
            }
        } else {
            for (int i = pointA; i < al; i++) {
                res[counter++] = a[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {};
        Q2 q2 = new Q2();
        int[] sort = q2.sort(a, b, 1, 0);
        for (int i : sort) {
            System.out.println(i);
        }

    }
}
