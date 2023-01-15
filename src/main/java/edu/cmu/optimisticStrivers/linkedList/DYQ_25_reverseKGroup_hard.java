package edu.cmu.optimisticStrivers.linkedList;

import java.util.Stack;

/**
 * @ClassName: DYQ_25_reverseKGroup_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/16 8:10 上午
 * @Version 1.0
 */
public class DYQ_25_reverseKGroup_hard {


    //https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/

    public static class ListNode {
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

        // 借助栈来一段一段的翻转
        public ListNode reverseKGroup(ListNode head, int k) {
            Stack<ListNode> stack = new Stack<>();
            ListNode dummy = new ListNode();
            ListNode pre = dummy; //一开始pre当然等于dummy
            while (true) {
                int curNum = 0;
                ListNode temp = head;//把head留住
                while (temp != null) {
                    curNum++;
                    stack.push(temp);
                    temp = temp.next;
                    if (curNum == k) break;
                }
                if (curNum < k) { //如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
                    pre.next = head;
                    break;
                }
                while (!stack.isEmpty()) {
                    pre.next = stack.pop();
                    pre = pre.next;
                }
//                pre.next = temp; //temp是下一次的第一个，当然也可能是null
                head = temp;
            }
            return dummy.next;
        }


        // 尾插法，指针
//        pre
//        tail  head
//        dummy    1     2     3     4     5
//         我们用tail 移到要翻转的部分最后一个元素
//        pre     head       tail
//        dummy    1     2     3     4     5
//        cur
//         我们尾插法的意思就是,依次把cur移到tail后面
//        pre          tail  head
//        dummy    2     3    1     4     5

        public ListNode reverseKGroup1(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode tail = dummy;
            while (true) {
                int count = 0;
                while (tail != null && count != k) {
                    count++;
                    tail = tail.next;
                }
                if (tail == null) break;
                ListNode head1 = pre.next;
                while (pre.next != tail) {  //很关键，用1 2 3来模拟，其实就是把1放在3后面，但是pre的链子还不能断
                    ListNode cur = pre.next;
                    pre.next = cur.next;
                    cur.next = tail.next;
                    tail.next = cur;
                }
                pre = head1;
                tail = head1;
            }
            return dummy.next;
        }


//        public static void main(String[] args) {
//
//            ListNode a = new ListNode(1);
//            ListNode b = new ListNode(2);
//            ListNode c = new ListNode(3);
//            a.next = b;
//            b.next = c;
//            ListNode res = reverseKGroup1(a, 2);
//
//            while (res != null) {
//                System.out.println(res.val);
//                res = res.next;
//            }
//        }


    }
}
