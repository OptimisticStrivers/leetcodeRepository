package edu.cmu.optimisticStrivers.twoPointers;

/**
 * @ClassName: DYQ_142_HasCycle2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/24 6:31 下午
 * @Version 1.0
 */
public class DYQ_142_HasCycle2_medium {

    public static ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        boolean hasCycle = false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            fast = fast.next;
            fast = fast==null? null:fast.next;
            slow = slow.next;
            if(slow==fast){
               hasCycle = true;
               break;
            }
        }
        if(!hasCycle) return null;
        ListNode fast1 = head;
        while(fast1!=slow){
            fast1 = fast1.next;
            slow = slow.next;
        }
        return fast1;
    }


    //还有一种方法，类160


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode2;
        listNode2.next = listNode0;
        listNode0.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(detectCycle(listNode3));
    }
}
