package edu.cmu.optimisticStrivers.dfs;

/**
 * @ClassName: DYQ_230_KthSmallestElementInBST_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/24 2:56 AM
 * @Version 1.0
 */
public class DYQ_230_KthSmallestElementInBST_medium {


    public int kthSmallest(TreeNode root, int k) {
        int left = countChildNUm(root.left);
        if (left + 1 == k) return root.val; //就是本身
        if (left >= k) return kthSmallest(root.left, k); //在左边 找倒数第k小即可
        return kthSmallest(root.right,k-left-1); //在右边找倒数第 k-left-1 因为现在左边的left个和root都不行
    }

    public int countChildNUm(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return countChildNUm(node.left) + countChildNUm(node.right) + 1;
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
