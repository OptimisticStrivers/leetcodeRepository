package edu.cmu.optimisticStrivers.OA.CITADEL;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/20 2:08 PM
 * @Version 1.0
 */
public class Q2 {


    public static List<Long> minimumCost(List<Integer> red, List<Integer> blue, int blueCost) {
        List<Long> res = new ArrayList<>();
        res.add(0L);
        int len = red.size();
        //先初始化最开始的 站台
        if (red.get(0) < blue.get(0) + blueCost) {
            res.add((long) red.get(0));
        } else {
//            System.out.println("???");
            res.add((long) (blue.get(0) + blueCost)); //相等的话 也是先紧着 blue这边
        }
//        System.out.println("len " + len);
        if (len == 1) return res;
        long preOnRed = red.get(0);
        long preOnBlue = blue.get(0) + blueCost;

        for (int i = 1; i < len; i++) {
            long currentRedCost = red.get(i);
            long currentBlueCost = blue.get(i);
            long r1 = preOnRed + currentRedCost;
            long r2 = preOnRed + currentBlueCost + blueCost;
            long r3 = preOnBlue + currentRedCost;
            long r4 = preOnBlue + currentBlueCost;
            res.add( Math.min(Math.min(r1, r2), Math.min(r3, r4)));
            preOnRed = Math.min(r1,r3);
            preOnBlue = Math.min(r2,r4);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(5);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(3);
        List<Long> longs = minimumCost(a1, a2, 1);
        System.out.println(longs.size() + "   sdad");
        for (Long aLong : longs) {
            System.out.println(aLong);
        }
    }
}
