package edu.cmu.optimisticStrivers.bootcamp.shuffle;

/**
 * @ClassName: BackKthNode
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/8 10:16 AM
 * @Version 1.0
 */
public class BackKthNode {

    //jianzhi2 021 和 19 和 jianzhi22

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

//两种方法


    //双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = dummy;
        int a = 0;
        while (p.next != null) {
            if (a >= n) {
                pre = pre.next;
            }
            p = p.next;
            a++;
        }
        pre.next = pre.next.next;
        return pre.next;
    }
}
