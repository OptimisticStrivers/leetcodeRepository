package edu.cmu.optimisticStrivers.dfs;

/**
 * @ClassName: DYQ_lintcode_BTDiameter_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/4 12:00 PM
 * @Version 1.0
 */
public class DYQ_lintcode_BTDiameter_easy {


    //二叉树 直径 无非两种情况
    // 1 两个节点 有一个是另一个的祖先
    // 2 两个节点 share 一个 公共祖先

    //第一种情况的话 其实也能分到第二种情况里


    //dfs
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    //dfs 自底向上 求 最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        //左右 各自最大深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //更新全局变量
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;//加上本身节点
    }


    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
