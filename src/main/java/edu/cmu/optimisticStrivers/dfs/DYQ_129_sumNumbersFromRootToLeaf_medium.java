package edu.cmu.optimisticStrivers.dfs;

/**
 * @ClassName: DYQ_129_sumNumbersFromRootToLeaf_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/13 10:52 AM
 * @Version 1.0
 */
public class DYQ_129_sumNumbersFromRootToLeaf_medium {
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

    int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int curVal) {
        if (root == null) {
            return;
        }
        curVal = curVal * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += curVal;
        }
        dfs(root.left,curVal);
        dfs(root.right,curVal);
    }


//    回溯
//    public int sumNumbers(TreeNode root) {
//        dfs(root, new StringBuilder());
//        return res;
//    }
//
//    int res = 0;
//
//    public void dfs(TreeNode root, StringBuilder sb) {
//        if(root == null){
//            return;
//        }
//        sb.append(root.val);
//        if (root.left == null && root.right == null) {
//            System.out.println(Integer.valueOf(sb.toString()));
//            res += Integer.valueOf(sb.toString());
//            return;
//        }
//        if(root.left!=null){
//            dfs(root.left, sb);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        if(root.right!=null){
//            dfs(root.right, sb);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//
//    }
}
