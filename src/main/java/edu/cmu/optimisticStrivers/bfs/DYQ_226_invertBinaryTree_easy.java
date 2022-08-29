package edu.cmu.optimisticStrivers.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName: DYQ_226_invertBinaryTree_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/27 2:03 AM
 * @Version 1.0
 */
public class DYQ_226_invertBinaryTree_easy {

    //这个题 就是 典型的 dfs 和 bfs 都无所谓的
    //只要保证每个节点都被处理过就行


    //前序遍历 递归 root最先被处理
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //后序遍历 递归 root最后被处理
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    //前序遍历 迭代 这个不太好写成后续 因为迭代stack模拟递归 没办法先处理子节点
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            swapChildren(cur);
            if (cur.right != null) stack.push(cur.right); //这一行和下一行的顺序是无所谓的
            if (cur.left != null) stack.push(cur.left);
        }
        return root;
    }

    public void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //层序遍历
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>(); //先进先出
        treeNodeDeque.add(root);
        while (!treeNodeDeque.isEmpty()) {
            int len = treeNodeDeque.size();
            while(len > 0){
                len--;
                TreeNode cur = treeNodeDeque.pop();
                if (cur.right != null) treeNodeDeque.push(cur.right); //这一行和下一行的顺序是无所谓的
                if (cur.left != null) treeNodeDeque.push(cur.left);
            }
        }
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
