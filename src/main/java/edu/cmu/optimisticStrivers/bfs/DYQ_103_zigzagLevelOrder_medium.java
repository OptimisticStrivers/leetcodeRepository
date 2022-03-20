package edu.cmu.optimisticStrivers.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: DYQ_103_zigzagLevelOrder_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/20 6:42 下午
 * @Version 1.0
 */
public class DYQ_103_zigzagLevelOrder_medium {
    class TreeNode {
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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            boolean leftToRight = false;
            ;
            ArrayList<Integer> curList;
            while (!queue.isEmpty()) {
                int size = queue.size();
                leftToRight = !leftToRight;
                curList = new ArrayList<>();
                while (size > 0) {
                    TreeNode cur = queue.poll();
                    if (leftToRight) {
                        curList.add(cur.val);
                    } else {
                        curList.add(0, cur.val);
                    }
                    size--;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                res.add(curList);
            }
            return res;
        }
    }
}
