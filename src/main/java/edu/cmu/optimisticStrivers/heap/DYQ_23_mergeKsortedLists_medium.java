package edu.cmu.optimisticStrivers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName: DYQ_23_mergeKsortedLists_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/20 12:45 PM
 * @Version 1.0
 */
public class DYQ_23_mergeKsortedLists_medium {

//    https://leetcode.cn/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }


    //一共四种方法

    //k个指针 O(kn)
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (true) {
            ListNode minNode = null; //这种起始点 选取的很棒
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) continue; //当前链表已经消耗完全
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minPointer == -1) { //全部消耗结束
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummy.next;
    }


    //因为上面的方法 k个node 选一个 最小的 需要O(K)
    //其实可以用小根堆 优先队列 去优化为 O(logK)
    public ListNode mergeKLists1(ListNode[] lists) {
//        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }


    //方法3
    //可以借鉴21 合并两个已排序链表  然后合并k-1次  O(nK)
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode res = null;
            for (ListNode list : lists) {
                res = merge2Lists(res, list);
            }
            return res;
        }
    }



    //方法4 还是对方法3进行优化 O(NlogK)

    //这个nlogk 的 时间复杂度 可以好好分析下  和方法三的异同  在题解网站上有



    public static ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }

}
