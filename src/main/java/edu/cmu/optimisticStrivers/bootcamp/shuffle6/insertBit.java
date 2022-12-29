package edu.cmu.optimisticStrivers.bootcamp.shuffle6;

/**
 * @ClassName: insertBit
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/26 5:02 PM
 * @Version 1.0
 */
public class insertBit {


//This problem can be approached in three key steps:
//1. Clear the bits j through i in N
//2. Shift M so that it lines up with bits j through i
//3. Merge M and N.


    public static int updateBits(int n, int m, int i, int j) {


//1. Clear the bits j through i in N
        int allOne = ~0;
//        System.out.println(allOne);
        int left = allOne << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;

    }

    public static void main(String[] args) {
//        int n = Integer.toBinaryString()
        System.out.println(Integer.toBinaryString(256));
        System.out.println(Integer.toBinaryString(65));
        int res = updateBits(256, 33, 1, 7);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(res));

    }
}
