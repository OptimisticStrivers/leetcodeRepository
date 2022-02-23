package edu.cmu.optimisticStrivers.linkedList;

import java.util.List;

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

        while(list1 != null || list2 != null){
            ListNode temp = null;
            if (list1 != null && (list2 == null || list1.val <= list2.val)){
                temp = list1;
                list1 = list1.next;
            }else {
                temp = list2;
                list2 = list2.next;
            }
            if(head == null){
                head = temp;
                curr = head;
            }else {
                curr.next = temp;
                curr = curr.next;
            }
        }
        return head;
    }
    //method2
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val > list2.val){
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }else {
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }
    }

}

