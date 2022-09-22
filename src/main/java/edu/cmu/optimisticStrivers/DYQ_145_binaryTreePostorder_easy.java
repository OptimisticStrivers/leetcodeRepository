package edu.cmu.optimisticStrivers;

import java.util.*;

/**
 * @ClassName: DYQ_145_binaryTreePostorder_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/5 5:59 PM
 * @Version 1.0
 */
public class DYQ_145_binaryTreePostorder_easy {

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


    //后序遍历=反转（根右左）  非递归
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
            TreeNode cur = stack.pop();
            root = cur.left;
        }
        Collections.reverse(res);
        return res;
    }




    //后序遍历，非递归  不用reverse的版本
    public static List<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;//用来记录上一节点
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) { //一定会进
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek(); //最左下角
            //这个cur.right==p 是避免 一直 遍历右子树
            // 就 ABC 左右 就能 看到这个例子
            if (cur.right == null || cur.right == pre) { //当该节点的右子树为空或者该节点的右节点是上次遍历过的节点，则直接弹出
                list.add(cur.val); //其实这里的意思就是 cur的右边都没了 或者右边走过了 就把当前cur加入结果 （这不就正是后序遍历的特点吗）
                stack.pop();
                pre = cur;
                cur = null; //当弹出一个节点时，说明该树已经遍历完了，那么就要把cur设置为NULL
            } else { //否则就遍历右子树
                cur = cur.right;
            }
        }
        return list;
    }


    //dfs
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        res.add(node.val);
    }
}


