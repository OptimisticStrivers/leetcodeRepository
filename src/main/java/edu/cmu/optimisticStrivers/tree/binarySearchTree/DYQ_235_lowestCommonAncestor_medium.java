package edu.cmu.optimisticStrivers.tree.binarySearchTree;

/**
 * @ClassName: DYQ_235_lowestCommonAncestor_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/8 6:35 PM
 * @Version 1.0
 */
public class DYQ_235_lowestCommonAncestor_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //bst
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == p || root == q){  这个其实可以包含在下面
//            return root;
//        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }


}
