package edu.cmu.optimisticStrivers.OA.optiver;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/29 7:21 PM
 * @Version 1.0
 */
public class Q2 {

//    The Giving Tree of Errors 3.0
    public class Node {
        Node left;
        Node right;
        boolean isRoot;
        String value;

        public Node(boolean isRoot, String value) {
            this.isRoot = isRoot;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        String solve = q2.solve("(A,B) (B,D) (D,E) (A,C) (C,F) (E,G)");
//        String solve = q2.solve("(A,B) (B,D) (A,C) ");
//        String solve = q2.solve("(A,B) (A,C)"); //!
//        String solve = q2.solve("(A,B) (B,D) (A,C) (F,E)");
        System.out.println(solve);
    }


    public String solve(String input) {
        String[] allPairs = input.split(" ");
        Map<String, Node> map = new HashMap<>();
//        System.out.println("pair " + allPairs.length);
        for (String pair : allPairs) {
            String[] parentAndSon = checkPairStringValidity(pair);
            if (parentAndSon == null) return "E1";
            String parent = parentAndSon[0];
            String son = parentAndSon[1];
//            System.out.println("parent " + parent + "  son  " + son);
            Node parentNode = map.get(parent);
            if (parentNode == null) { //first time encounter this node
                parentNode = new Node(true, parent);
                map.put(parent, parentNode);
            }
            Node leftNode = parentNode.left;
            Node rightNode = parentNode.right;
            if (leftNode != null && leftNode.value.equals(son)) return "E2"; //duplicate pair
            if (rightNode != null && rightNode.value.equals(son)) return "E2"; //duplicate pair
            if (leftNode != null && rightNode != null) return "E3"; //parent has more than two children
            if (map.containsKey(son) && !map.get(son).isRoot) { //input contains cycle
                return "E5";
            }

            Node sonNode = map.get(son);
            if (sonNode != null) { //son exists and also is a root
                sonNode.isRoot = false;
                if (parentNode.left == null) {
                    parentNode.left = sonNode;
                } else {
                    parentNode.right = sonNode;
                }
            } else {
                Node newSon = new Node(false, son);
                if (parentNode.left == null) {
                    parentNode.left = newSon;
                } else {
                    parentNode.right = newSon;
                }
                map.put(son, newSon);
            }
        }

        int rootCount = 1; //has to be only one root
        Node root = null;
        for (Map.Entry<String, Node> stringNodeEntry : map.entrySet()) {
//            System.out.println(stringNodeEntry.getKey() + "   " + stringNodeEntry.getValue().isRoot);
            if (stringNodeEntry.getValue().isRoot) {
                root = stringNodeEntry.getValue();
                rootCount--;
            }
            if (rootCount == -1) return "E4";//multiple roots
        }

        return printLexico(root);
    }


    //    String solve = q2.solve("(A,B) (B,D) (D,E) (A,C) (C,F) (E,G");
    public String[] checkPairStringValidity(String pair) {
        int stringLen = pair.length();
        if (stringLen < 5) return null; //minimum pattern length is (A,B), check length
        char leftParenthesis = pair.charAt(0);
        char rightParenthesis = pair.charAt(stringLen - 1);
        if (leftParenthesis != '(' || rightParenthesis != ')') return null; //check parenthesis
        String valueSeparatedByComma = pair.substring(1, stringLen - 1);
        String[] parentAndSon = valueSeparatedByComma.split(",");
        if (parentAndSon.length != 2) return null; //check comma split
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < parentAndSon[i].length(); j++) {
                if (parentAndSon[i].charAt(j) < 65 || parentAndSon[i].charAt(j) > 90) {
                    return null; //check value is uppercase letter
                }
            }
        }
        if(parentAndSon[0].equals(parentAndSon[1])) return null; //(A,A)
        return parentAndSon;
    }


    public String printLexico(Node root) { //root一定不为空？
        String res = "(" + root.value;
        if (root.left != null) {
            res += printLexico(root.left);
        }
        if (root.right != null) {
            res += printLexico(root.right);
        }
        res += ")";
        return res;
    }
}
