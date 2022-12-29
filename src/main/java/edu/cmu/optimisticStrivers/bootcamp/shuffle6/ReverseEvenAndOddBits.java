package edu.cmu.optimisticStrivers.bootcamp.shuffle6;

/**
 * @ClassName: ReverseEvenAndOddBits
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/26 7:21 PM
 * @Version 1.0
 */
public class ReverseEvenAndOddBits {


    public static int swapOdd£venBits(int x) {
        return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
    }


}