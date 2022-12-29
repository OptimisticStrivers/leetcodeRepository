package edu.cmu.optimisticStrivers.math.moleElection;

import java.util.*;

/**
 * @ClassName: DYQ_majorityElement_229_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/11/29 11:23 PM
 * @Version 1.0
 */
public class DYQ_majorityElement_229_medium {

    //    给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//    摩尔投票 通用版 https://leetcode.cn/problems/majority-element-ii/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-ws0rj/、
//    求超过n/k的 majorityElement 最多有 k-1 个候选者
//    若存在出现次数超过 n / k 的数，最后必然会成为这 k - 1 个候选者之一，但是并不一定是，所以要二轮检查
    public List<Integer> majorityElement1(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        for (int i : nums) {
            if (c1 != 0 && a == i) c1++;
            else if (c2 != 0 && b == i) c2++;
            else if (c1 == 0 && ++c1 >= 0) a = i;
            else if (c2 == 0 && ++c2 >= 0) b = i;
            else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (a == i) c1++;
            else if (b == i) c2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (c1 > n / 3) ans.add(a);
        if (c2 > n / 3) ans.add(b);
        return ans;
    }


//    重温一下摩尔投票 -- “大混战” 算法！
//    摩尔投票 + 哈希表
//    扩展：求所有出现次数超过 n / k 次的元素。 对于本题，k = 3
//    时间：O(n)
//    空间：O(1)

    public List<Integer> majorityElement(int[] nums) {
        return majorityElement(nums, 3);
    }

    // 求所有出现次数超过 n / k 次的元素
    private List<Integer> majorityElement(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        // candidates ： 候选人-> 候选人的有效票数
        HashMap<Integer, Integer> candidates = new HashMap<>();
        // 1）摩尔投票：
        for (int num : nums) {
            if (candidates.size() < k-1 || candidates.containsKey(num)) {
                candidates.put(num, candidates.getOrDefault(num, 0)+1);
            } else { // 候选人已满，又来1个新人，大混战，所有人牺牲1点血量
                for (Iterator<Map.Entry<Integer, Integer>> it = candidates.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    if (entry.getValue() == 1) it.remove();
                    else entry.setValue(entry.getValue()-1);
                }
            }
        }
        // 2）摩尔投票结束，验票：检查每个候选人是否真正有效当选！
        for (int candidate : candidates.keySet()) {
            int count = 0;
            for (int num : nums) if (num == candidate) count++;
            if (count > nums.length / k) ans.add(candidate);
        }
        return ans;
    }
}
