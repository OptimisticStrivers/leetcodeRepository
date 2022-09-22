package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_jianzhi61_LCA_BST_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/21 11:06 AM
 * @Version 1.0
 */
public class DYQ_jianzhi61_LCA_BST_easy {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
