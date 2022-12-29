package edu.cmu.optimisticStrivers.bootcamp.HW4;

/**
 * @ClassName: P1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/24 9:35 PM
 * @Version 1.0
 */
public class Ladder {
    public static void main(String[] args) {
        try {
            System.out.println(doStuff(args));
        }
        catch (Exception e) {
            System.out.println("exc");
        }
        doStuff(args);
    }

    static int doStuff(String[] args) throws NumberFormatException {
        return Integer.parseInt(args[0]);
    }

//    javac Ladder.java
//    java -cp . Ladder x


    //“exc” is output, followed by an uncaught exception
}