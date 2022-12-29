package edu.cmu.optimisticStrivers.OA.Expedia;

import java.util.*;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/6 8:39 AM
 * @Version 1.0
 */
public class Q2 {


    public static void main(String[] args) {
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(5);
//        List<Integer> b = new ArrayList<>();
//        b.add(2);
//        b.add(5);
//        b.add(4);
//        System.out.println("res  " + getMinimumHealth(a, b, 3));


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        priorityQueue.offer(8);
        priorityQueue.offer(3);
        priorityQueue.offer(6);
        priorityQueue.offer(2);
        for (Integer integer : priorityQueue) {  //priorityQueue的迭代器 不保证顺序
            System.out.println(integer);
        }

//        TreeMap<Integer,Integer> map = new TreeMap<>();
//        map.put(1,1);
//        map.put(7,7);
//        map.put(2,2);
//        map.put(9,9);
//        map.put(4,4);
//        map.put(3,3);
//        map.put(8,8);
//
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
//            System.out.println(integerIntegerEntry.getKey());
//        }

    }

}


