package edu.cmu.optimisticStrivers.linkedList;

/**
 * @ClassName: DYQ_24_swapPairs_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/8 4:02 下午
 * @Version 1.0
 */
public class DYQ_24_swapPairs_medium {

    //三个指针，和链表反转类似
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode left = head;
        ListNode right = head.next;
        boolean firstSwitch = true;
        ListNode preNode = null;

        while (left != null && right != null) {
            left.next = right.next;
            right.next = left;
            ListNode cur = right;
            right = left;
            left = cur;
            if(preNode!=null) preNode.next = left;
            if(firstSwitch){
                head = left;
                firstSwitch = false;
            }
            preNode = right;
            left = left.next.next;
            if (left == null) return head;
            right = right.next.next;

        }
        return head;
    }


    //recursive
    //和链表反转类似
    public ListNode swapPairs1(ListNode head) {

        if(head==null||head.next==null) { //不换
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs1(head.next.next);
        next.next = head;
        return next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode head = swapPairs(listNode1);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }

    }

    static class ListNode {
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
}

