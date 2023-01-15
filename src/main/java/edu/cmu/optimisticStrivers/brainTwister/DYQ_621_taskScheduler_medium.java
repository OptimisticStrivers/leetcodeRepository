package edu.cmu.optimisticStrivers.brainTwister;

/**
 * @ClassName: DYQ_621_taskScheduler_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/11 1:03 PM
 * @Version 1.0
 */
public class DYQ_621_taskScheduler_medium {

    //    https://leetcode.cn/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
    public int leastInterval(char[] tasks, int n) {

        int maxAppearance = 0;
        int[] ints = new int[26];
        for (char task : tasks) {
            ints[task - 'A']++;
            maxAppearance = Math.max(ints[task - 'A'], maxAppearance);
        }

        int countForMaxappearance = 0;
        for (int anInt : ints) {
            if (anInt == maxAppearance) {
                countForMaxappearance++;
            }
        }
//        由于这种情况时再用上述公式计算会得到一个不正确且偏小的结果，因此，我们只需把公式计算的结果和tasks的长度取最大即为最终结果。
        return Math.max(tasks.length, (n + 1) * (maxAppearance - 1) + countForMaxappearance);

    }
}
