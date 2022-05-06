package edu.cmu.optimisticStrivers.linkedList;

public class CXY_2_addTwoNumbers_medium {
    // Definition for singly-linked list.
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        int ans = 0;
        boolean carryDigit = false;
        while(l1 != null || l2 != null){
            ans = ((l1==null)?0:l1.val) + ((l2==null)?0:l2.val) + ((carryDigit)?1:0);
            if(ans>=10){
                ans = ans%10;
                carryDigit = true;
            }else {
                carryDigit=false;
            }
            if(head==null){
                head = new ListNode(ans);
                curr = head;
            }else {
                curr.next = new ListNode(ans);
                curr = curr.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carryDigit){
            curr.next = new ListNode(1);
        }
        return head;
    }
}
