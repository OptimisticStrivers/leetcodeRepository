package edu.cmu.optimisticStrivers.linkedList;

/**
 * @ClassName: DYQ_2_addingTwoNumbers_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/26 5:56 PM
 * @Version 1.0
 */
public class DYQ_2_addingTwoNumbers_easy {

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


//    Input: l1 = [2,4,3], l2 = [5,6,4]
//    Output: [7,0,8]
//    Explanation: 342 + 465 = 807.
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int carrier = 0;
        while (l1 != null && l2 != null) {
            cur.val = (carrier + l1.val + l2.val) % 10;
            carrier = (carrier + l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null && l2 != null) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        ListNode remain = l1 != null ? l1 : l2;
        while (remain != null) {
            cur.next = new ListNode((carrier + remain.val) % 10);
            carrier = (carrier + remain.val) / 10;
            remain = remain.next;
            cur = cur.next;
        }
        if (carrier != 0) {
            cur.next = new ListNode(carrier);
        }
        return head;
    }


    //指针顺序反了的版本
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur = new ListNode();
        int carrier = 0;
        while (l1 != null && l2 != null) {
            cur.val = (carrier + l1.val + l2.val) % 10;
            carrier = (carrier + l1.val + l2.val) / 10;
            cur = new ListNode(0, cur);
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 != null ? l1 : l2;
        while (remain != null) {
            cur.val = (carrier + remain.val) % 10;
            carrier = (carrier + remain.val) / 10;
            cur = new ListNode(0, cur);
            remain = remain.next;
        }
        if (carrier != 0) {
            cur.val = carrier;
            return cur;
        }
        return cur.next;
    }
}
