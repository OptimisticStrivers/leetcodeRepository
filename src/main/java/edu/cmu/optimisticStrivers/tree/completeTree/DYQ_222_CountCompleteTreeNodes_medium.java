package edu.cmu.optimisticStrivers.tree.completeTree;

/**
 * @ClassName: DYQ_222_CountCompleteTreeNodes_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/31 8:35 PM
 * @Version 1.0
 */
public class DYQ_222_CountCompleteTreeNodes_medium {


    //注意左移 右移 无符号右移的 区别
//    https://blog.csdn.net/qq_16097005/article/details/83577554?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-83577554-blog-125514246.topnsimilarv1&spm=1001.2101.3001.4242.1&utm_relevant_index=3

    //注意左移的运算级很低 记得加括号
    //不知道运算级的时候 记得用括号 解决


    //普通算二叉树的递归方法
    public int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }

    //题目要求 On 所以 我们需要利用完全二叉树的特性
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftLevel = getLevel(root.left);
        int rightLevel = getLevel(root.right);

        if (leftLevel == rightLevel) { //如果左边level等于右边level 说明左边是满二叉树
            //回顾满二叉树的性质 节点个数 = 2^level - 1
            //加上当前的节点就是 2^level
            return countNodes(root.right) + (1 << leftLevel) - 1 + 1; //比如level为1的完全二叉树 就是 1 左移
        }
        if (leftLevel > rightLevel) {
            return countNodes(root.left) + (1 << rightLevel) - 1 + 1;
            //注意左移的运算级很低 记得加括号
        }
        //不可能右边level大
        return -1;
    }

    public int getLevel(TreeNode root) { //因为这是完全二叉树 所以level可以一直往左下角算
        int res = 0;
        while (root != null) {
            res++;
            root = root.left;
        }
        return res;
    }

    //常规的算level的方法是
    private int countLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(countLevel(root.left), countLevel(root.right)) + 1;
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

    public static void main(String[] args) {
        System.out.println(1 << 1);

        System.out.println(1 << 2);
    }
}
