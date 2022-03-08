package edu.cmu.optimisticStrivers.tree;

import java.util.*;

public class WYC_94_Binary_Tree_Inorder_easy {

    // Recursive
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        // Recursive
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);

        return result;
    }
    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);

    }

    // Stack
    public List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

