package edu.cmu.optimisticStrivers;

import java.util.Arrays;

/**
 * @ClassName: Test3
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/2/7 10:36 AM
 * @Version 1.0
 */
public class Test3 {

    public static void main(String[] args) {
//        int[] as = new int[]{2, 0, 10, 0, 6, 0, 1, 0, 12, 0, 0, 0, 9, 0, 3, 0};
//        String targetString = "abcdef";

        int[] as = new int[]{2,10,6,1,12,0,9,3,4,7,14,5,11,8,15,13};

//[5, 4, 9, 6, 8, 14]
//[11, 8, 6, 2, 13, 10]
        int[] indexes = new int[]{11, 8, 6, 2, 13, 10};
        int[] res = new int[6];
//那一个字符的ascii的低4位 为 [11, 8, 6, 2, 13, 10]
        for (int i = 0; i < 6; i++) {
            int goal = indexes[i];
            for (int j = 0; j < 128; j++) {
                int a = j & 0xf;
                if(a == goal){
                    res[i] = j;
                }
            }
        }
        //[123, 120, 118, 114, 125, 122]
        //{xvr}z
//        1111011
//        1011
//        11
        System.out.println(Arrays.toString(res));


//        int[] rdxs = new int[]{5, 4, 9, 6, 8, 14};
//        int[] index = new int[6];
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 16; j++) {
//                if(as[j] == rdxs[i]){
//                    index[i] = j;
//                    break;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(index));




//        int[] ints = new int[6];
//        //遍历 as 构造 6 个 字符
//        for (int i = 0; i <= 15; i++) {
//            for (int j = 0; j <= 15; j++) {
//                for (int k = 0; k <= 15; k++) {
//                    for (int l = 0; l <= 15; l++) {
//                        for (int m = 0; m <= 15; m++) {
//                            for (int n = 0; n <= 15; n++) {
//                                ints[0] = as[i];
//                                ints[1] = as[j];
//                                ints[2] = as[k];
//                                ints[3] = as[l];
//                                ints[4] = as[m];
//                                ints[5] = as[n];
////                                String targetString = new String(bytes);
////                                System.out.println(Arrays.toString(ints));
//                                int rdx = 0;
//                                int rax = 0;
//                                while (rax <= 5) {
//                                    rdx <<= 4;
//                                    rdx += ints[rax];
//                                    rax++;
//                                }
////                                if (rdx > 5000000)
////                                    System.out.println(rdx);
//                                if (rdx == 5543566) {
//                                    System.out.println(Arrays.toString(ints));
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }



//        int rdx = 0;
//        int rax = 0;
//        while (rax <= 5) {
//            rdx <<= 4;
//            byte ecx = (byte) targetString.charAt(rax);
//            System.out.println(ecx);
//            ecx &= 0xf; //其实就是 as 的 0-15个数字
//            //            用ecx去找到字符array 然后 ascii 加到 rax上
////                                    rdx += 0x402b80(,ecx,8)
//
//            System.out.println(ecx);
//            System.out.println();
//            rdx += as[ecx];
//            rax++;
//        }
//        System.out.println(rdx);
//        if (rdx == 5543566) {
//            System.out.println(targetString);
//        }
    }
}
