package edu.cmu.optimisticStrivers.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: DYQ_226_mirrorTree_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/13 12:20 下午
 * @Version 1.0
 */
public class DYQ_226_mirrorTree_easy {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //普通dfs
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        TreeNode swap = left;
        root.left = right;
        root.right = swap;
        return root;
    }

    //stack 迭代
    public TreeNode mirrorTree1(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            if(cur==null) continue;
            TreeNode swap = cur.left;
            cur.left = cur.right;
            cur.right = swap;

            stack.push(cur.left);
            stack.push(cur.right);
        }
        return root;
    }
}
