package edu.cmu.optimisticStrivers.tree;
import java.util.*;

public class WYC_652_Find_Duplicate_Subtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String s = dfs(root, res, map);

        return res;
    }

    public String dfs(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) return "N";

        // use either pre-order or post-order would work, but NOT in-order
        String serial = dfs(root.left, res, map) + "," + dfs(root.right, res, map)+ "," + root.val;
        //String serial = root.val + "," + dfs(root.left, res, map) + "," + dfs(root.right, res, map);

        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            res.add(root);
        }
        return serial;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
