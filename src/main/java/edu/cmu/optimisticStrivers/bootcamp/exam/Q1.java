package edu.cmu.optimisticStrivers.bootcamp.exam;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/6 11:51 AM
 * @Version 1.0
 */
public class Q1 {

    public static int inverter(int N, int k) {
        Integer a = N;
        String s = Integer.toBinaryString(a);
        StringBuilder realS = new StringBuilder();
        System.out.println(32 - s.length());
        if (s.length() < 32) {
            for (int i = 0; i < 32 - s.length(); i++) {
                realS.append("0");
            }
        }
        realS.append(s);
        System.out.println("real " + realS);
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        int count = 0;
        System.out.println("real leng "  + realS.length());
        for (int i = 0; i < realS.length(); i++) {
            if (realS.charAt(i) == '1' && !start) {
                start = true;
            }
            if (start) {
                count++;
                if (count % k == 0) {
                    sb.append(realS.charAt(i) == '0' ? '1' : '0');
                } else {
                    sb.append(realS.charAt(i));
                }
            }else{
                sb.append(realS.charAt(i));
            }
        }
        System.out.println("res len " + sb.length());
        System.out.println("res " + sb.toString());
        int res = Integer.parseInt(sb.toString(), 2);
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(65535));
//        System.out.println(inverter(65535, 4));
        System.out.println(Integer.toBinaryString(2147483647).length());
        System.out.println("bi " + Integer.toBinaryString(2147483647));
//        System.out.println(inverter(0, 3));
        System.out.println(inverter(2147483647, 4));


//        N 0 k 3
    }



}
