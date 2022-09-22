package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_236_LCA_binaryTree_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/21 11:05 AM
 * @Version 1.0
 */
public class DYQ_236_LCA_binaryTree_easy {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
