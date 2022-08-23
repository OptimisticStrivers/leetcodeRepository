package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_275_HIndex2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/5 5:00 PM
 * @Version 1.0
 */
public class DYQ_275_HIndex2_medium {


//    这道题是「274. H 指数」的延伸，和第 274 题相比，这道题中的输入数组 citations 已经按照升序排序。
//    除了使用第 274 题的方法以外（见「274. H 指数的官方题解」），这道题可以利用数组 citations 有序的特点，
//    使用二分查找的方法求解，时间复杂度为 O(logn)，其中 nn 为数组 citations 的长度。

//    According to the definition of h-index on Wikipedia:
//    A scientist has an index h if h of their n papers have at least h citations each,
//    and the other n − h papers have no more than h citations each.

    //还是要充分了解 h-index 其实就是找 「引用次数至少为 xx 次的 xx 篇论文」中的最大 xx 值。
//    我理解的就是让你求最大的h，使数组中有h个元素不小于h。

    //直接二分 而且不用check了
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) { //本来 此时 n-mid 篇论文 就已经都是一体的了
                // 如果 mid位置这个论文的 citation 就 大于等于 n-mid 说明
                // 这 n-mid 篇论文 就已经满足了
                // 比如 1 3 4 5 6   （0+4）/2 = 2   4 >= 5-2 = 3  那么 就是 说 这后三篇论文都citation>=3
                // 那么 Hindex 就 至少是 为 3了
                // 这时候就要 看看 Hindex 能不能更大 所以 往左走
                right = mid - 1; //再
            } else {
                left = mid + 1;
            }
        }
        //我们直接 算 右边 有多少个元素即可 left是由mid+1来的 因为left越界了 所以 原来的mid就是mid？？？？
        return n - left;
    }

    //https://leetcode.cn/problems/h-index-ii/solution/h-zhi-shu-ii-by-leetcode-solution-si7h/

}
