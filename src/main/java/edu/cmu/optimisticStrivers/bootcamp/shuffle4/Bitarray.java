package edu.cmu.optimisticStrivers.bootcamp.shuffle4;

import java.util.BitSet;

/**
 * @ClassName: Bitarray
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/28 7:57 AM
 * @Version 1.0
 */
public class Bitarray {


    public static void main(String[] args) {
        int[] a = new int[]{1,1,2,3,4,4,5,2,7};
        BitSet bits1 = new BitSet(32000);
        BitSet res = new BitSet(32000);
        for (int i : a) {
            if(bits1.get(i)){
                res.set(i);
            }else{
                bits1.set(i);
            }
        }
        System.out.println(res);
    }
}
