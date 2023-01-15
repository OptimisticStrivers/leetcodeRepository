package edu.cmu.optimisticStrivers.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DYQ_297_serializeAndDeserializeBT_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/11 10:41 AM
 * @Version 1.0
 */
public class DYQ_297_serializeAndDeserializeBT_hard {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        return serializeHelper(root, new StringBuilder()).toString();
    }

    private StringBuilder serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(","); //多余的逗号 在deserialize的时候 split不会出问题的
            return sb;
        }
        sb.append(root.val).append(",");
        sb = serializeHelper(root.left, sb);
        sb = serializeHelper(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList(Arrays.asList(data.split(",")));
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserializeHelper(list);
        root.right = deserializeHelper(list);
        return root;
    }
    public static void main(String[] args) {

//        String a = "a,b,c,";
//        System.out.println(Arrays.toString(a.split(","))); //[a, b, c]
    }
}
