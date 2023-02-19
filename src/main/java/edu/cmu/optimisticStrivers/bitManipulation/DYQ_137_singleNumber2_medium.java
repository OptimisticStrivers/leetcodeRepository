package edu.cmu.optimisticStrivers.bitManipulation;

/**
 * @ClassName: DYQ_137_singleNumber2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/5 4:09 PM
 * @Version 1.0
 */
public class DYQ_137_singleNumber2_medium {


    //重复出现的数字 累加的话 在 每一bit上 都可以通过 取余数 来找到 唯一出现一次的数字
//    实际上，只需要修改求余数值 mm ，即可实现解决 除了一个数    字以外，其余数字都出现 mm 次 的通用问题。


//    异或运算：x ^ 0 = x， x ^ 1 = ~x
//    与运算：x & 0 = 0 ， x & 1 = x
//    DFA

    /**
     * 有限状态自动机
     * 状态在 00 01 10    00 01 10 间循环
     *
     * @param n 事件，本题中为对应的位是0还是1
     * @param a 二进制的第一位，即`01`的`1`
     * @param b 二进制的第二位，即`01`的`0`
     */
    public void autoMachine(int n, int a, int b) {
        // 00 01 10    00 01 10

        // 0|0|1|0|0|1
        // 0|1|0|0|1|0

        // 当前数为00或01
        if (b == 0)
            // 如果n=0，代表没变化
            if (n == 0) a = a;
                // b=0,n=1,代表有变化，要么从00->01，要么01->10，明显第一位a要变成取反的数
            else a = ~a;
            // 当前数为10. 此时要么不变，要么10->00，a都不变且等于0
        else
            a = 0;
    }


    //直接位数统计
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
//            >>是右移 和<<具有同样的道理
//            只不过右移过程中溢出时，低位会舍弃，高位补零
            res |= bits[31 - i] % m; //末尾0去 OR bit 就是bit 本身
        }
        return res;
    }
//    ut
//   3 1
//           1 1 1 1 1 1 1 1 1 1
//          1 1 1 1 1 1 1 1 1 1
//         1 1 1 1 1 1 1 1 1 1


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(2));


    }



// [2,-3,-3,-3]

    // [2,2,2,-3]

    //照搬的思想
//    public int singleNumber(int[] nums) {
//        int len = nums.length;
//        int[] bits = new int[32];
//        for(int num : nums){
//            for(int i = 0; i<32; i++){
//                int cur =  num & 1;
//                num >>= 1; //无所谓 因为只是照搬 bits 到 bits数组里
//                bits[i] += cur;
//            }
//        }
//        for(int i = 0; i<32; i++){
//            System.out.print(bits[31-i]+" ");
//        }
//
//        int res = 0;
//        for(int i = 0; i<32; i++){
//            res <<= 1;
//            int curDigit = bits[31-i];
//            curDigit %= 3;
//            res += curDigit;
//        }
//        return res;
//
//    }
}
