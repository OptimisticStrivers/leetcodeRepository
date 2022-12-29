package edu.cmu.optimisticStrivers.format;

/**
 * @ClassName: Hex
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/25 11:45 PM
 * @Version 1.0
 */
public class Hex {


//%02x x 表示以十六进制形式输出
//02 表示不足两位,，前面补0输出，如果超过两位，则以实际输出
        public static void main(String[] args) {
            System.out.println(String.format("%02X",12 ));     // 0c
            System.out.println(String.format("%02X",2 ));      // 02

            System.out.println(String.format("%2X",12 ));      // c
            System.out.println(String.format("%2X",2 ));       // 2
        }
}
