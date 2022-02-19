package edu.cmu.optimisticStrivers.tree;

import java.util.Stack;

/**
 * @ClassName: DYQ_114_FlattenTreeToLinkedList_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/14 6:01 下午
 * @Version 1.0
 */
public class DYQ_114_FlattenTreeToLinkedList_medium {
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

    public void flatten0(TreeNode root) { //普通迭代
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }



    private TreeNode pre = null;

    public void flatten(TreeNode root) { //先序遍历的逆序  -  递归
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }



    public void flatten1(TreeNode root) {  //先序遍历的迭代 -
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.right; // 递归添加右节点
            }
            cur = toVisit.peek(); // 已经访问到最右的节点了
            // 在不存在左节点或者右节点已经访问过的情况下，访问根节点
            if (cur.left == null || cur.left == pre) {  //！！！！！！！！这里是关键中的关键！！！！！！！！
                toVisit.pop();
                /**************修改的地方***************/
                cur.right = pre;
                cur.left = null;
                /*************************************/
                pre = cur;
                cur = null;
            } else {
                cur = cur.left; // 左节点还没有访问过就先访问左节点
            }
        }
    }


}
