package edu.cmu.optimisticStrivers.tree.binarySearchTree;

/**
 * @ClassName: DYQ_98_isValidBST_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/8 6:20 PM
 * @Version 1.0
 */
public class DYQ_98_isValidBST_medium {


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

    //中序遍历 验证
    long pre = Long.MIN_VALUE; //必须要long 因为有integer最小值 那个用例

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
