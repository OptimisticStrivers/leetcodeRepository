package edu.cmu.optimisticStrivers.tree.redBlackTree;

/**
 * @ClassName: RedBlackTreeNode
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/12 10:21 AM
 * @Version 1.0
 */

/**
 * 红黑树节点
 */
public class RedBlackTreeNode {
    public static boolean Red = false;
    public static boolean Black = true;
    //节点颜色
    private boolean color;
    private int data;
    private RedBlackTreeNode left;
    private RedBlackTreeNode right;
    private RedBlackTreeNode parent;

    public RedBlackTreeNode(int data){
        this.data = data;
        color = Red;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public RedBlackTreeNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackTreeNode left) {
        this.left = left;
    }

    public RedBlackTreeNode getRight() {
        return right;
    }

    public void setRight(RedBlackTreeNode right) {
        this.right = right;
    }

    public RedBlackTreeNode getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode parent) {
        this.parent = parent;
    }
}
