package edu.cmu.optimisticStrivers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: DYQ_145_binayTreePreorder_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/5 6:18 PM
 * @Version 1.0
 */
public class DYQ_145_binayTreePreorder_easy {

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

    //对比代码， 前序遍历，唯一区别就是， 一个一直向左， 一个一直向右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            //go left down to the ground
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //if we reach to the leaf, go back to the parent right, and repeat the go left down.
            TreeNode cur = stack.pop();
            root = cur.right;
        }
        return res;
    }


}
