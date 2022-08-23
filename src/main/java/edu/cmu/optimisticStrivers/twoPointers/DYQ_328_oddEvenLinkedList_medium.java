package edu.cmu.optimisticStrivers.twoPointers;

/**
 * @ClassName: DYQ_328_oddEvenLinkedList_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/4 5:45 PM
 * @Version 1.0
 */
public class DYQ_328_oddEvenLinkedList_medium {

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


    //even 都放在后面
    //要求 时间 o(n) 空间 o(1)
    public ListNode oddEvenList(ListNode head) {
        //单趟
        //双指针
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p2.next != null) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = evenHead;
        return oddHead;

    }


    //网友的
    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点，o 为奇链表尾节点
        ListNode o = head;
        // p 为偶链表头结点
        ListNode p = head.next;
        // e 为偶链表尾节点
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }

}
