package edu.cmu.optimisticStrivers.tree;

/**
 * @ClassName: DYQ_101_isSymmetric_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 5:30 PM
 * @Version 1.0
 */
public class DYQ_101_isSymmetric_easy {
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

    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
