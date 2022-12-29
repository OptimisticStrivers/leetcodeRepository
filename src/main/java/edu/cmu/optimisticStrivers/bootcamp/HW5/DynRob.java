package edu.cmu.optimisticStrivers.bootcamp.HW5;

/**
 * @ClassName: DynRob
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/30 9:12 PM
 * @Version 1.0
 */
public class DynRob {


    static int maximumLoot(byte[] loot) {
        if (loot == null) return 0;
        if (loot.length == 0) return 0;
        int pre0 = loot[0];
        if (loot.length == 1) return pre0;
        int pre1 = Math.max(loot[0], loot[1]);
        if (loot.length == 2) return pre1;
        int pre2 = Math.max(pre1, loot[2]);
        if (loot.length == 3) return pre2;
        for (int i = 3; i < loot.length; i++) {
            pre0 = Math.max(Math.max(pre0 + loot[i], pre1), pre2);
            int swap = pre0;
            pre0 = pre1;
            pre1 = pre2;
            pre2 = swap;
        }
        return pre2;
    }

}
