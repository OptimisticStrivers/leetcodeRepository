package edu.cmu.optimisticStrivers.linkedList;

/**
 * @ClassName: CXY_21_mergeTwoSortedLists_easy
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/23/22 9:47 pm
 * @Version 1.0
 */
public class CXY_21_mergeTwoSortedLists_easy {
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

    //method1
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode curr = null;

        while (list1 != null || list2 != null) {
            ListNode temp = null;
            if (list1 != null && (list2 == null || list1.val <= list2.val)) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            if (head == null) {
                head = temp;
                curr = head;
            } else {
                curr.next = temp;
                curr = curr.next;
            }
        }
        return head;
    }

    //method2
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val > list2.val) {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }
    }


    //递归版
        public static ListNode merge2Lists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = merge2Lists(l1.next, l2);
                return l1;
            }
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }

    //迭代版
    private ListNode merge2Lists1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }

}

