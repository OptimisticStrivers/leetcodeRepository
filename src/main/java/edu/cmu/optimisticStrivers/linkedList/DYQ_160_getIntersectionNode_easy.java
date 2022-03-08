package edu.cmu.optimisticStrivers.linkedList;

import java.util.Stack;

/**
 * @ClassName: DYQ_52jianzhi_getIntersectionNode_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/6 10:12 下午
 * @Version 1.0
 */
public class DYQ_160_getIntersectionNode_easy {

    //方法一：double pointer，先移到同相位的起点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode cur = headA;
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }
        int lenB = 0;
        cur = headB;
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }
        if (lenA < lenB) {
            int move = lenB - lenA;
            for (int i = 0; i < move; i++) {
                headB = headB.next;
            }
            // same starts
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        } else {
            int move = lenA - lenB;
            for (int i = 0; i < move; i++) {
                headA = headA.next;
            }
            // same starts
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    }

    //方式二，用stack，既然有intersection，那么尾部肯定相同
    //但是空间复杂度上去了 O(N)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode cur = stackA.pop();
            if (cur == stackB.pop()) {
                return cur;
            }
        }
        return null;
    }


    //轮着走，非常华丽的代码
    public ListNode get2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}