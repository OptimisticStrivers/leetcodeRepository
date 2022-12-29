package edu.cmu.optimisticStrivers.bitManipulation;

/**
 * @ClassName: DYQ_136_singleNumber_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/1 2:46 PM
 * @Version 1.0
 */
public class DYQ_136_singleNumber_easy {


    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res  ^= num;
        }
        return  res;
    }

    public static void main(String[] args) {

        int a = 2;
        int b = 8;
        System.out.println(a ^ b); //不是pow


        int d  = (int) Math.pow(10,6);
//
//        final String c= "123";
//        c = "2";

        String apple = "apple";
        System.out.println(apple.substring(4));
    }


}
