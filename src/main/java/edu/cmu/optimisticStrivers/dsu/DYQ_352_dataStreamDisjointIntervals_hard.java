package edu.cmu.optimisticStrivers.dsu;

import java.util.*;

/**
 * @ClassName: DYQ_352_dataStreamDisjointIntervals_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/7 4:21 PM
 * @Version 1.0
 */
public class DYQ_352_dataStreamDisjointIntervals_hard {


    //区间合并的问题




    public DYQ_352_dataStreamDisjointIntervals_hard() {
    }

    Set<Integer> set = new HashSet<>();
    List<int[]> list = new ArrayList<>();


    public void addNum(int val) {
        if (set.contains(val)) {
            return;
        }
        set.add(val);
        //需要合并 [..., val - 1] 和 [val + 1, ...] 两个区间
        if (set.contains(val - 1) && set.contains(val + 1)) {
            int left = binarySearch(val - 1, 1);
            int right = binarySearch(val + 1, 0);
            list.get(left)[1] = list.get(right)[1]; //合并区间
            list.remove(right);
        } else if (set.contains(val + 1)) { //说明右区间存在
            // val + 1 出现过，说明有以 val + 1 为左端点的区间
            int ans = binarySearch(val + 1, 0);
            list.get(ans)[0] = val;
        } else if (set.contains(val - 1)) {
            // 有以 val - 1 为右端点的区间
            int ans = binarySearch(val - 1, 1);
            list.get(ans)[1] = val;
        } else {
            // 左右都未出现，val 形成一个独立区间
            list.add(new int[]{val, val});
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]); //随便用 左 右 做comparator都可以的 因为就是想把 区间排序下
        //这个题的一大点 就是 区间永不相交


    //这里o1表示位于前面的对象，o2表示后面的对象
    //返回-1（或负数），表示不需要交换01和02的位置，o1排在o2前面，asc
    //返回1（或正数），表示需要交换01和02的位置，o1排在o2后面，desc
    //① 把o1当作小元素、把o2当作大元素
    //② 如果是o1 - o2、 o1.value - o2.value 、 o1.compareTo().o2 这样的(小 -> 大)形式，就可以直接看作升序。
    //③ 如果是o2 - o1、 o2.value - o1.value、 o2.compareTo().o1 这样的(大 -> 小)形式，就可以直接看作降序。
    }

    public int[][] getIntervals() {
        int lenN = list.size();
        int[][] ans = new int[lenN][2];
        for (int i = 0; i < lenN; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    //pos 指明要找的是左端点还是右端点 0左1右
    public int binarySearch(int target, int pos) { //现在要找的target这个数字所在的区间 而且我们知道数字在此区间的左边
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tempVal = list.get(mid)[pos];
            //因为 binarysearch 都是 +1 -1 （紧挨着） 得到的target 且必须是存在的
            if (tempVal == target) {
                return mid;
            } else if (tempVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
