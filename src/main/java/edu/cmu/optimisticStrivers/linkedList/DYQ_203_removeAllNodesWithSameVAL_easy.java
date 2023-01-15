package edu.cmu.optimisticStrivers.linkedList;

/**
 * @ClassName: DYQ_203_removeAllNodesWithSameVAL_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/15 12:26 AM
 * @Version 1.0
 */
public class DYQ_203_removeAllNodesWithSameVAL_easy {
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

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            ListNode temp = head.next;
            if (head.val == val) {
                pre.next = temp; //pre不变
            } else {
                pre = head;
            }
            head = temp;
        }
        return dummy.next;
    }


}
