package edu.cmu.optimisticStrivers.tree.binarySearchTree;

/**
 * @ClassName: DYQ_669_trimBST_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/8 6:54 PM
 * @Version 1.0
 */
public class DYQ_669_trimBST_medium {
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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if (root.val < low || root.val > high) {
            if (root.right != null) {
                return root.right;
            }else if(root.left!=null){
                return root.left;
            }
            return null;
        }
        return root;
    }

}
