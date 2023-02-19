package edu.cmu.optimisticStrivers;

/**
 * @ClassName: Test2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/2/7 10:18 AM
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        int[] as = new int[]{2, 0, 10, 0, 6, 0, 1, 0, 12, 0, 0, 0, 9, 0, 3, 0,
                4, 0, 7, 0, 14, 0, 5, 0, 11, 0, 8, 0, 15, 0};
        char[] chars = new char[6];
        for (int i = 90; i <= 127; i++) {
            for (int j = 0; j < 128; j++) {
                for (int k = 0; k < 128; k++) {
                    for (int l = 0; l < 128; l++) {
                        for (int m = 0; m < 128; m++) {
                            for (int n = 0; n < 128; n++) {
                                chars[0] = (char) i;
                                chars[1] = (char) j;
                                chars[2] = (char) k;
                                chars[3] = (char) l;
                                chars[4] = (char) m;
                                chars[5] = (char) n;
                                String targetString = new String(chars);
//                                System.out.println(targetString);
                                int rdx = 0;
                                int rax = 0;
                                while (rax <= 5) {
                                    rdx <<= 4;
                                    byte ecx = (byte) targetString.charAt(rax);
                                    ecx &= 0xf;
                                    //            用ecx去找到字符array 然后 ascii 加到 rax上
//                                    rdx += 0x402b80(,ecx,8)

                                    rdx += as[ecx];
                                    rax++;
                                }
                                System.out.println(rdx);
                                if (rdx == 5543566) {
                                    System.out.println(targetString);
                                }
                            }
                        }
                    }
                }
            }
        }


//        最后rax 要等于 5543566

    }
}
