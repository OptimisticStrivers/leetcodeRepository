package edu.cmu.optimisticStrivers;

import java.util.Stack;

/**
 * @ClassName: DYQ_114_flattenBT2linkedList_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/11 10:41 PM
 * @Version 1.0
 */
public class DYQ_114_flattenBT2linkedList_medium {

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

    //递归 先左后右的 后序遍历
    //先拿到左边和右边 当然好合并
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        //上面两行完成以后 left 和 right 都已经是 右孩子 单链表形式了
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = tmp;
    }


    //递归
//    先右后左的后序遍历相当于先左后右的前序遍历的逆序。也就是这种后序遍历的第一个节点是前序遍历的最后一个节点，然后第二个节点是前序遍历的倒数第二个节点.....
//    先序遍历等价于逆后序遍历
//    这种先右后左的 好处 就直接把 右边 作为 pre 然后往后接就可以


    TreeNode pre = null;
    public void flatten1(TreeNode root) {
        traverse(root);
    }
    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        traverse(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

//    非递归
    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            TreeNode tmp = node.right;
            node.right = node.left;
            node.left = null;

            while (node.right != null) node = node.right;
            node.right = tmp;
            root = tmp;
        }
    }


    //O1 空间  Morris Traverse


}
