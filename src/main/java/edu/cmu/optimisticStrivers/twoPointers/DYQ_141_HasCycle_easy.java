package edu.cmu.optimisticStrivers.twoPointers;

/**
 * @ClassName: DYQ_141_HasCycle_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/24 5:43 下午
 * @Version 1.0
 */
public class DYQ_141_HasCycle_easy {
    //方法一：hashTable

    //方法二：fast and slow pointers
    //为什么有环一定会相遇呢，因为快节点比慢节点每次多走一步，相当于在一步一步靠近慢节点
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            fast = fast.next;
            fast = fast==null? null:fast.next;
            slow = slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false; //没有环的话，fast一定会先到null
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
