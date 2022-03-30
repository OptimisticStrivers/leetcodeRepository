package edu.cmu.optimisticStrivers.bfs;

import java.util.ArrayList;
import java.util.List;

public class CXY_102_BinaryTreeLevelOrderTraversal_medium {
    // Definition for a binary tree node.
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        List<TreeNode> currentLayer = new ArrayList<>(1);
        currentLayer.add(root);
        while(!currentLayer.isEmpty()){
            List<Integer> currentLayerValue = new ArrayList<>(currentLayer.size());
            List<TreeNode> nextLayer = new ArrayList<>(currentLayer.size() * 2);
            for(TreeNode node : currentLayer){
                currentLayerValue.add(node.val);
                if(node.left != null){
                    nextLayer.add(node.left);
                }
                if(node.right != null){
                    nextLayer.add(node.right);
                }
            }
            ans.add(currentLayerValue);
            currentLayer = nextLayer;
        }
        return ans;
    }
}
