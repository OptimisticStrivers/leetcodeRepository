package edu.cmu.optimisticStrivers.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_jianzhi49_sumNumbers_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/23 6:56 下午
 * @Version 1.0
 */
public class DYQ_jianzhi49_sumNumbers_medium {
    //剑指 Offer II 049. 从根节点到叶节点的路径数字之和

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        dfs(root, path);
        return sum;
    }


    public void dfs(TreeNode root, List<TreeNode> path) {
        if (root.left == null && root.right == null) {
            int base = 1;
            for (int i = path.size() - 1; i >= 0; i--) {
                sum += base * path.get(i).val;
                base *= 10;
            }
            return;
        }
        if (root.left != null) {
            path.add(root.left);
            dfs(root.left, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right);
            dfs(root.right, path);
            path.remove(path.size() - 1);
        }
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
