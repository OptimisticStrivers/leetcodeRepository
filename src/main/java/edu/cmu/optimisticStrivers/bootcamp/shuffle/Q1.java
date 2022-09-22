package edu.cmu.optimisticStrivers.bootcamp.shuffle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/10 2:41 PM
 * @Version 1.0
 */
public class Q1 {


    public class Node {
        int val;
        Node next;
    }


    public Node reverseSum(Node node1, Node node2) {
        int num1 = 0;
        List<Integer> list1 = new ArrayList<>();
        while (node1 != null) {
            list1.add(node1.val);
        }
        for (int i = list1.size()-1; i >= 0 ; i--) {
            num1 *= 10;
            num1 += list1.get(i);
        }

        int num2 = 0;
        List<Integer> list2 = new ArrayList<>();
        while (node2 != null) {
            list2.add(node2.val);
        }
        for (int i = list2.size()-1; i >= 0 ; i--) {
            num2 *= 10;
            num2 += list2.get(i);
        }

        int num3 = num1 + num2;
        int length = String.valueOf(num3).length();

        Node dummy = new Node();
        Node temp = dummy;
        while(length >= 0){
            Node node = new Node();
            node.val = (int) (num3/Math.pow(10,length-1));
            length--;
            temp.next = node;
            temp = node;
        }
        return dummy.next;
    }
}
