package edu.cmu.optimisticStrivers.bootcamp.shuffle3;

/**
 * @ClassName: commonAncestor
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/21 10:54 AM
 * @Version 1.0
 */
public class CommonAncestor {

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


    public TreeNode get(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = get(root.left, p, q);
        TreeNode right = get(root.right, p, q);
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
