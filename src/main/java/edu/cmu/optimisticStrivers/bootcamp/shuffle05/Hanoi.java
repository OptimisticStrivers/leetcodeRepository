package edu.cmu.optimisticStrivers.bootcamp.shuffle05;

import java.util.Scanner;

/**
 * @ClassName: Hanoi
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/8 5:45 PM
 * @Version 1.0
 */
public class Hanoi {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入盘数n：");
        int n = sc.nextInt();
        hanoi(n, 'A', 'B', 'C');
    }


    /**
     * 传入n个盘子，编号为1到n，按照汉诺r塔的规则，从目标A盘子移动到C，B是辅助盘子
     *
     * @param nDisks
     * @param A
     * @param B
     * @param C
     */
    public static void hanoi(int nDisks, char A, char B, char C) {
        if (nDisks == 1) {      //当只有一个盘子时，直接一步到位，把盘子从A移动到C
            move(nDisks, A, C);
            return;
        }
        hanoi(nDisks - 1, A, C, B);//当n>=2时，步骤1，先把最上面的一大堆n-1个小盘子从A移动到B
        move(nDisks, A, C);//步骤2，此时A上就剩下第你n个大盘子，只需要把它从A移动到C
        hanoi(nDisks - 1, B, A, C);//步骤3，此时需要将B上的n-1个小盘子从B移动到C
    }


    /**
     * 将编号为n的盘子从starPoint移动到targetPoint
     *
     * @param nDisks
     * @param sourceTower
     * @param destTower
     */
    private static void move(int nDisks, char sourceTower, char destTower) {
        System.out.println("编号为" + nDisks + "的盘子正在从" + sourceTower + "移动到" + destTower);
    }
}
