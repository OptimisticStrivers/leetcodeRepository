package edu.cmu.optimisticStrivers.bootcamp.HW2;

/**
 * @ClassName: ReorderList
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/11 4:18 PM
 * @Version 1.0
 */
public class ReorderList {
//    inplace
//    1-2-3-4-5-6
//    1-6-2-5-3-4

    public static class LinkedListNode {
        int val;
        LinkedListNode next;

        public LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

    //递归法 好难写

    //    https://zhuanlan.zhihu.com/p/85610479
    //迭代法 先找中点 然后逆转中点后链表 然后合并两链表
    LinkedListNode reorderList(LinkedListNode head) {
        if (head == null) return null;
        //快慢双指针 找中点
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //中点在slow 但是我们下一个节点的开头是slow.next
        LinkedListNode newHead = reverseList(slow.next);
        slow.next = null;

        //合并 head1 和 newHead
        LinkedListNode head1 = head;
        while (newHead != null) { //因为偶数个节点的话 newHead和head一样长
            //奇数个的话 newHead短一些
            LinkedListNode temp = newHead.next;
            newHead.next = head1.next;
            head1.next = newHead;

            head1 = head1.next.next; //newHead.next
            newHead = temp;
        }
        return head;
    }

    LinkedListNode reverseList(LinkedListNode head) {
        if (head == null) return null;
        // 用 4-5-6 模拟
        LinkedListNode tail = head;
        head = head.next;
        tail.next = null;
//        head.next = tail;

        while (head != null) {
            LinkedListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        LinkedListNode linkedListNode1 = new LinkedListNode(1);
        LinkedListNode linkedListNode2 = new LinkedListNode(2);
        LinkedListNode linkedListNode3 = new LinkedListNode(3);
        LinkedListNode linkedListNode4 = new LinkedListNode(4);
        linkedListNode1.next = linkedListNode2;
        linkedListNode2.next = linkedListNode3;
        linkedListNode3.next = linkedListNode4;
        LinkedListNode linkedListNode = reorderList.reorderList(linkedListNode1);
        System.out.println(linkedListNode.val);
        while (linkedListNode!=null){
            System.out.print(linkedListNode.val+ " ");
            linkedListNode = linkedListNode.next;
        }
    }

}
