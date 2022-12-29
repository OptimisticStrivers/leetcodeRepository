package edu.cmu.optimisticStrivers.bitManipulation;

/**
 * @ClassName: Byte
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/4 2:00 PM
 * @Version 1.0
 */
public class ByteTest {

    public static void main(String[] args) {

        System.out.println("0".getBytes().length);
        System.out.println("%".getBytes().length);
        System.out.println("s".getBytes().length);

        System.out.println("哈".getBytes().length); //中文占3个byte
        byte[] bytes = new byte[10];
//        bytes[0] = "0".getBytes();
        for (Byte aByte : bytes) {
            System.out.println(aByte);
        }
    }
}
