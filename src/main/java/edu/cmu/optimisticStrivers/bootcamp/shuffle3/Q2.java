package edu.cmu.optimisticStrivers.bootcamp.shuffle3;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/21 11:43 AM
 * @Version 1.0
 */
public class Q2 {


    public class Node {
        Node left;
        Node right;
        Node parent;
    }



    //给定一个BST 节点 返回其 successor of inorder traverse
    public Node findSuccessorOfBST(Node givenNode) {
        if (givenNode.right != null) {
            Node right = givenNode.right;
            while(right.left!=null){
                right = right.left;
            }
            return right;
        } else if (givenNode.parent!=null){
            return givenNode.parent;
        }else{
            return givenNode;
        }
    }


    public static void main(String[] args) {


    }
}
