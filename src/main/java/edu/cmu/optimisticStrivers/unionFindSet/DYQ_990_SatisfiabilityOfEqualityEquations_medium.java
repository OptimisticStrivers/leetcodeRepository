package edu.cmu.optimisticStrivers.unionFindSet;

/**
 * @ClassName: DYQ_990_SatisfiabilityOfEqualityEquations_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 11:59 PM
 * @Version 1.0
 */
public class DYQ_990_SatisfiabilityOfEqualityEquations_medium {

//    https://labuladong.github.io/algo/di-yi-zhan-da78c/shou-ba-sh-03a72/bing-cha-j-323f3/
//    这个问题用 Union-Find 算法就显得十分优美了。题目是这样：
//
//    给你一个数组 equations，装着若干字符串表示的算式。每个算式 equations[i] 长度都是 4，而且只有这两种情况：a==b 或者 a!=b，其中 a,b 可以是任意小写字母。你写一个算法，如果 equations 中所有算式都不会互相冲突，返回 true，否则返回 false。
//
//    比如说，输入 ["a==b","b!=c","c==a"]，算法返回 false，因为这三个算式不可能同时正确。
//
//    再比如，输入 ["c==c","b==d","x!=z"]，算法返回 true，因为这三个算式并不会造成逻辑冲突。
//    !!!!!!!!!!!!!!
//    我们前文说过，动态连通性其实就是一种等价关系，具有「自反性」「传递性」和「对称性」，其实 == 关系也是一种等价关系，具有这些性质。所以这个问题用 Union-Find 算法就很自然。
//
//    核心思想是，将 equations 中的算式根据 == 和 != 分成两部分，先处理 == 算式，使得他们通过相等关系各自勾结成门派；然后处理 != 算式，检查不等关系是否破坏了相等关系的连通性。


    static int[] p;
    static int count;

    private static int find(int x) {
        return p[x] != x ? (p[x] = find(p[x])) : x;
    }

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
            count--;
        }
    }

    private static boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public boolean equationsPossible(String[] equations) {
        //因为都是小写字母 所以我们也可以转化为数字索引
        p = new int[26];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < equations.length; i++) {
            String cur = equations[i];
            char[] chars = cur.toCharArray();
            if (chars[1] == '=') {
                union(chars[0]-'a',chars[3]-'a');
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String cur = equations[i];
            char[] chars = cur.toCharArray();
            if (chars[1] == '!') {
                if(connected(chars[0]-'a',chars[3]-'a')){
                    return false;
                }
            }
        }
        return true;
    }
}
