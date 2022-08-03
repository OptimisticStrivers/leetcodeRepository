package edu.cmu.optimisticStrivers.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DYQ_jianzhi_050_pathSum_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/23 6:58 下午
 * @Version 1.0
 */
public class DYQ_jianzhi_050_pathSum_medium {
    //剑指 Offer II 050. 向下的路径节点之和


    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    int cur = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        map.put(0, 1);
        dfs(root, targetSum);
        return res;
    }


    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        cur += root.val;
        if (map.containsKey(cur - targetSum)) {
            res += map.get(cur - targetSum);
        }
        if (map.containsKey(cur)) {
            map.put(cur, map.get(cur) + 1);
        } else {
            map.put(cur, 1);
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        map.put(cur, map.get(cur) - 1); //肯定有，但是无所谓删不删，减1就行
        cur -= root.val; //把自己减掉，回溯
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
}
