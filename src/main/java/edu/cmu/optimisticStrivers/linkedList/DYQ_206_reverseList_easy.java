package edu.cmu.optimisticStrivers.linkedList;

/**
 * @ClassName: DYQ_24_reverseList_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/8 4:52 下午
 * @Version 1.0
 */
public class DYQ_206_reverseList_easy {


    //recursive
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        return recur(head);

    }
    public ListNode recur(ListNode head){
        if(head.next == null) {
            return head;
        }
        ListNode node = recur(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }



    //iteration
    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
