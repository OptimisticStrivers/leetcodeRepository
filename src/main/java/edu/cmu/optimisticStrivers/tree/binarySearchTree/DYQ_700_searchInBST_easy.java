package edu.cmu.optimisticStrivers.tree.binarySearchTree;

/**
 * @ClassName: DYQ_700_searchInBST_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/8 7:10 PM
 * @Version 1.0
 */
public class DYQ_700_searchInBST_easy {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val < val){
            return searchBST(root.right,val);
        }else if (root.val > val){
            return searchBST(root.left,val) ;
        }else {
            return root;
        }
    }
}
