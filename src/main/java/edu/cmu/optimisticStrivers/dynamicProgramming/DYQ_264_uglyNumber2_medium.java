package edu.cmu.optimisticStrivers.dynamicProgramming;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DYQ_264_uglyNumber2_medium {
//    https://leetcode.cn/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode-solution-uoqd/

    //使用小顶堆
    public static int nthUglyNumber(int n) {
        int[] primes = {2,3,5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();  //小顶堆
        set.add(1L);
        priorityQueue.add(1L);
        int res = 1;
        for (int i = 0; i < n ; i++) {
            res = Math.toIntExact(priorityQueue.poll());
            for (int j = 0; j < 3; j++) {
                int prime = primes[j];
                if(set.add((long) (prime * res))){
                    priorityQueue.add((long) (prime*res));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber1(10));
    }


//    方法一使用最小堆，会预先存储较多的丑数，导致空间复杂度较高，维护最小堆的过程也导致时间复杂度较高。可以使用动态规划的方法进行优化。
        //动态规划
//    相当于3个数组，分别是能被2、3、5整除的递增数组，且每个数组的第一个数都为1。
//    然后就简单了，维护三个指针，将三个数组合并为一个严格递增的数组。就是传统的双指针法，只是这题是三个指针。
//    然后优化一下，不要一下子列出这3个数组，因为并不知道数组预先算出多少合适。
//    这样就一边移指针，一边算各个数组的下一个数，一边merge，就变成了题解的动态规划法的代码。


    public static int nthUglyNumber1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = 2 * dp[p2];
            int num3 = 3 * dp[p3];
            int num5 = 5 * dp[p5];
            int num = Math.min(Math.min(num2,num3),num5);
            dp[i] = num;
            System.out.println(i+1 + " " + dp[i]);
//            if(num == num2){
//                p2++;
//            }else if(num == num3){  //这样写 有问题，因为如果有两个 比如 6 可以由2*3 也可以 3*2 那么最后dp数组里面会出现两个6
//                p3++;
//            }else{
//                p5++;
//            }
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {    //这样写，就会跳过重复的数字
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n-1];
    }
}

