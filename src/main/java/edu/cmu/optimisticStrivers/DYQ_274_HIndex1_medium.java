package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_274_HIndex1_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/5 11:50 AM
 * @Version 1.0
 */


//二分答案
public class DYQ_274_HIndex1_medium {

    public int hIndex(int[] citations) {
        int length = citations.length;
        int hIndex = Integer.MIN_VALUE;
        for (int i = 0; i <= length; i++) { //0也是一个 H Index 的值
            int numForOverOrEqualI = i;
//            int numForLessThanI = length - i;
            for (int citation : citations) {
//                if(numForOverOrEqualI < 0) break;
                if (citation == i || citation > i) numForOverOrEqualI--;
            }
            if (numForOverOrEqualI > 0) { //至少要消耗完i个
                continue;
            }
//            if(numForOverOrEqualI == 0){
            //即使这时候 numForOverOrEqualI < 0
            //并无大碍 因为 n-i 个剩下的citation 只要 小于等于 i 即可
            hIndex = Math.max(i, hIndex);
//            }
        }
        return hIndex;
    }


    //不用枚举n个值 直接二分答案
//    public int hIndex1(int[] cs) {
//        int n = cs.length;
//        int l = 0, r = n;
//        while (l < r) {
//            int mid = l + r + 1 >> 1;
//            if (check(cs, mid)) l = mid;
//            else r = mid - 1;
//        }
//        return r;
//    }
//
//    boolean check(int[] cs, int mid) {
//        int ans = 0;
//        for (int i : cs) if (i >= mid) ans++;
//        return ans >= mid;
//    }


    public int hIndex2(int[] cs) {
        int n = cs.length;
        int l = 0, r = n;
        while (l <= r) { //即使相等 也要 检查一下
            int mid = l + r >> 1; //
            System.out.println("l " + l + " r " + r + " mid " + mid);
            if (check(cs, mid)){ //mid可以的话 就继续往前探
                l = mid + 1;
            } else r = mid - 1;
        }
        //跳出循环的时候 一定是 r小于l了 那么 是从两个情况来的
        // l = mid + 1 mid满足的时候 往前探路 那么探路失败的话 就回到mid 那不就是 l-1  如果跳出循环了 说明 l比r 大1 那么mid就是r
        // r = mid - 1 如果跳出循环了 上一个mid 也不满足 那么mid-1是一定满足的 因为右边都不咋满足
        // 那上一个符合的一定是r
        System.out.println(r);
        return r;
    }

    boolean check(int[] cs, int mid) {
        int ans = 0;
        for (int i : cs) if (i >= mid) ans++;
//        {4, 0, 4, 1, 4, 4 }  虽然mid 为3的时候 check会为true 但是其实3并不能满足HIndex
//        但是因为 4 >= 3 说明 此时 4个数都大于等于3  确实都大于的时候 3并不能满足HIndex 但是我们会向右二分 去检查4可不可以
        return ans >= mid;
    }


    public static void main(String[] args) {

        DYQ_274_HIndex1_medium dyq_274_hIndex1_medium = new DYQ_274_HIndex1_medium();
        dyq_274_hIndex1_medium.hIndex2(new int[]{4, 0, 4, 1, 4, 4 });
//      dyq_274_hIndex1_medium.hIndex2(new int[]{3, 0, 6, 1, 5});


    }
}
