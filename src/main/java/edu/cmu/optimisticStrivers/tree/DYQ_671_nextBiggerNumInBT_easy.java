package edu.cmu.optimisticStrivers.tree;

/**
 * @ClassName: DYQ_671_nextBiggerNumInBT_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/15 12:14 AM
 * @Version 1.0
 */
public class DYQ_671_nextBiggerNumInBT_easy {
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


    //左右递归 找第一个比root大的即可返回 因为下面一定都更大 然后比较两侧即可


    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) return -1;
        if (root.val > val) { //不会小于的 只会等于 等于继续往下
            return root.val;
        }
        int leftBigger = dfs(root.left, val);
        int rightBigger = dfs(root.right, val);
        if (leftBigger == -1) {
            return rightBigger;
        }
        if (rightBigger == -1) {
            return leftBigger;
        }
        return Math.min(rightBigger, leftBigger);
    }


    //方法二 但是没必要走到叶子节点的
    //最小的一定被传递到最上面
    //所有节点在叶子结点都存在
//    int diff = Integer.MAX_VALUE;
//    int target = -1;
//
//    public int findSecondMinimumValue(TreeNode root) {
//        dfs(root, root.val);
//        return target == -1 ? -1 : target;
//    }
//
//    public void dfs(TreeNode root, int minimum) {
//        if (root.left == null) { //叶子结点
//            if (root.val != minimum) {
//                if (root.val - minimum < diff) {
//                    diff = root.val - minimum;
//                    target = root.val;
//                }
//            }
//            return;
//        }
//        dfs(root.left, minimum);
//        dfs(root.right, minimum);
//    }
}
