package edu.cmu.optimisticStrivers.tree.binarySearchTree;

/**
 * @ClassName: DYQ_108_sortedArrayToBST_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/8 7:12 PM
 * @Version 1.0
 */
public class DYQ_108_sortedArrayToBST_easy {
    public static class TreeNode {
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
//        System.out.println(left + " " + right);

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).val);
    }
}
