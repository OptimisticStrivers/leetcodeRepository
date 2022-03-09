package edu.cmu.optimisticStrivers.linkedList;

/**
 * @ClassName: CXY_142_getIntersectionInACycle_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/9 11:13 上午
 * @Version 1.0
 */
public class CXY_142_getIntersectionInACycle_medium {

        // 弗洛伊德环
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

     //借鉴 160 题
    public static ListNode detectCycle1(ListNode head) {
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
        ListNode intersection = slow; //fast
        ListNode head2 = intersection.next;
        ListNode pointer2 = intersection.next;
        intersection.next = null;
        ListNode head1 = head;
        ListNode pointer1 = head;
        while(pointer1 != pointer2){
            pointer1= pointer1==null?head2:pointer1.next;
            pointer2= pointer2==null?head1:pointer2.next;
        }
        return pointer1;
    }
}
