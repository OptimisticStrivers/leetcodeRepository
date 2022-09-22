package edu.cmu.optimisticStrivers.bootcamp.shuffle3;

import java.util.*;

/**
 * @ClassName: FindDuplicates_bit
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/21 11:09 AM
 * @Version 1.0
 */
public class FindDuplicates_bit {

//    Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32,000.
//    The array may have duplicate entries and you do not know what N is.
//    With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?
//    因为我们不知道每一个重复元素具体是几次 所以没办法用异或运算了


//    We have 4 kilobytes of memory which means we can address up to 8 * 4 * 2i e bits.
//    Note that 32 * 210 bits is greater than 32000. We can create a bit vector with 32000 bits, where each bit represents one integer.
//    Using this bit vector, we can then iterate through the array, flagging each element v
//    by setting bit v to 1. When we come across a duplicate element, we print it.


    public Set<Integer> checkDuplicates(int[] array) {
        Set<Integer> res = new HashSet<>();
        BitSet bitSet = new BitSet();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(bitSet.get(array[i])){
                res.add(array[i]);
            }else{
                bitSet.set(array[i]);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        FindDuplicates_bit findDuplicates_bit = new FindDuplicates_bit();
        int[] ints = {1, 1, 1, 1, 2, 3, 4, 5, 5, 6, 6, 6};
        Set<Integer> list = findDuplicates_bit.checkDuplicates(ints);
        System.out.println(list.size());
    }
}
