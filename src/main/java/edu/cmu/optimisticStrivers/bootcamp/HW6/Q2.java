package edu.cmu.optimisticStrivers.bootcamp.HW6;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/22 6:42 PM
 * @Version 1.0
 */
public class Q2 {

    //    https://blog.csdn.net/weixin_36073392/article/details/114205201
    static int reverseBitField1(int N, int l, int h) {
        if (l >= h) return N;
        StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(N));
        System.out.println(binaryString.length());
        int counter = 32;
        int trimLen = binaryString.length();
        while (counter != trimLen) {
            binaryString.insert(0, "0");
            counter--;
        }
        System.out.println(binaryString.length());
        System.out.println(binaryString);
//        if (l > (binaryString.length() - 1)) return N;
//        if (h > (binaryString.length() - 1)) return N;
        StringBuilder sb = new StringBuilder();
        sb.append(binaryString.toString(), 31 - h, 32 - l);
        sb.reverse();
//        System.out.println(sb);
        int count = 0;
        for (int i = 31 - h; i < 32 - l; i++) {
            binaryString.setCharAt(i, sb.charAt(count++));
        }
//        try {
//            int a = Integer.valueOf(binaryString.toString(), 2);
//        } catch (Exception e) {
//            return Integer.MAX_VALUE;
////            System.out.println(e);
////            return N;
//        }
//        return Integer.valueOf(binaryString.toString(), 2);
        return Integer.valueOf(binaryString.substring(1), 2);

    }


    static int reverseBitField(int N, int l, int h) {
        System.out.println("N " + Integer.toBinaryString(N));
        if (l >= h || l >= 32 || h >= 32) return N;
        int mask1 = (1 << l) - 1;
        int mask2 = (1 << (h + 1)) - 1;
        //1 << 6  1000000 - 1 = 111111
        if (h == 31) {
            mask2 = ~0;
        }
        System.out.println(Integer.toBinaryString(mask1));
        System.out.println(Integer.toBinaryString(mask2));

        int reverseMask = mask1 ^ mask2;
        System.out.println(Integer.toBinaryString(reverseMask));

        int noReverseBit = (reverseMask & N) >> l;
        System.out.println(Integer.toBinaryString(noReverseBit));

        int reverseBit = 0;
        for (int i = 0; i < (h - l + 1); i++) {
            reverseBit <<= 1;
            if ((int) (noReverseBit & 1) == 1) {
                reverseBit ^= 1;
            }
            noReverseBit >>>= 1;
        }
        reverseBit <<= 1;
        int nonReverseMask = ~reverseMask;
        int nonReverseBit = nonReverseMask & N;
        return nonReverseBit + reverseBit;
    }


    static int method(int N, int l, int h){
        while(l < h){
            int a = (N & (1<<l)) >>> l;
            int b = (N & (1<<h)) >>> h;
            N &= ~(1<<l);
            N &= ~(1<<h);
            N |= b << l;
            N |= a << h;
            l++;
            h--;
        }
        return N;
    }

    // for Code Visualizer
    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(165));
//        System.out.println(reverseBitField1(165, 1, 5));
//        System.out.println(reverseBitField1(-1, 0,20 ));

//        System.out.println(Integer.valueOf("10",2));
//        System.out.println(reverseBitField(165, 1, 5));

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));


//        System.out.println(Integer.valueOf("-8",2));

        int a = -8;
        System.out.println(Integer.toBinaryString(a));
    }

}
