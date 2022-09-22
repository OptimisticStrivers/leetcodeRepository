package edu.cmu.optimisticStrivers.bootcamp.HW3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: TreeTraversal
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/17 6:55 PM
 * @Version 1.0
 */
public class TreeTraversal {


    // Traverse the implicit binary tree in 'treeArr' starting at 'rootIndex'
    // in the order specified by 'order'.  Print each node's content to
    // standard output as it is processed by the traversal.
    static void traverse1(String order, int rootIndex, int[] treeArr) {
        int len = treeArr.length;
        Stack<Integer> stack = new Stack<>();
        if (order.equals("pre")) { //pre order
            while (!stack.isEmpty() || rootIndex <= len - 1) {
                while (rootIndex <= len - 1) {
                    System.out.println(treeArr[rootIndex]);
                    stack.push(rootIndex);
                    rootIndex = 2 * rootIndex;
                }
                Integer index = stack.pop();
                rootIndex = index * 2 + 1; //right
            }
            //if we reach to the leaf, go back to the parent right, and repeat the go left down.
        } else { //post order
            List<Integer> res = new ArrayList<>();
            while (rootIndex <= len - 1 || !stack.isEmpty()) {
                while (rootIndex <= len - 1) {
                    res.add(treeArr[rootIndex]);
                    stack.push(rootIndex);
                    rootIndex = rootIndex * 2 + 1;
                }
                Integer index = stack.pop();
                rootIndex = index * 2;
            }
            Collections.reverse(res);
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }


    static void traverse(String order, int rootIndex, int[] treeArr) {
        if (rootIndex < 1 || rootIndex > treeArr.length - 1) {
            System.out.println("Invalid");
            return;
        }
        if (order.equals("pre")) {
            preOrder(treeArr, rootIndex);
        } else {
            postOrder(treeArr, rootIndex);
        }
    }

    static void preOrder(int[] treeArr, int rootIndex) {
        if (rootIndex >= treeArr.length) {
            return;
        }
        System.out.println(treeArr[rootIndex]);
        preOrder(treeArr, 2 * rootIndex);
        preOrder(treeArr, 2 * rootIndex + 1);
    }

    static void postOrder(int[] treeArr, int rootIndex) {
        if (rootIndex >= treeArr.length) {
            return;
        }
        postOrder(treeArr, 2 * rootIndex);
        postOrder(treeArr, 2 * rootIndex + 1);
        System.out.println(treeArr[rootIndex]);
    }


    public static void main(String[] args) {
        int[] tree = {0, 1, 2, 3, 4, 5, 6};
//        traverse("post", 1, tree);
//        traverse("pre", 1, tree);
        traverse("post", 1, tree);

    }
}