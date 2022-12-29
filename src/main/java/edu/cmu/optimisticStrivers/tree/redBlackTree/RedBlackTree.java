package edu.cmu.optimisticStrivers.tree.redBlackTree;

/**
 * @ClassName: RedBlackTree
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/12 10:21 AM
 * @Version 1.0
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 红黑树
 */
public class RedBlackTree {
    //根节点
    private RedBlackTreeNode root;

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(12);
        tree.insert(1);
        tree.insert(9);
        tree.insert(2);
        tree.insert(0);
        tree.insert(11);
        tree.insert(7);
        tree.insert(19);
        tree.insert(4);
        tree.insert(15);
        tree.insert(18);
        tree.insert(5);
        tree.insert(14);
        tree.insert(13);
        tree.insert(10);
        tree.insert(16);
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(17);

        tree.delete(12);
        tree.delete(1);
        tree.delete(9);
        tree.delete(2);
        tree.delete(0);
        tree.delete(11);
        tree.delete(7);
        tree.delete(19);
        tree.delete(4);
        tree.delete(15);
        tree.delete(18);
        tree.delete(5);
        tree.delete(14);
        tree.delete(13);
        tree.delete(10);
        tree.delete(16);
        //tree.delete(6);
        //tree.delete(3);
        //tree.delete(8);
        //tree.delete(17);

        System.out.println("层级");
        levelTraversal(tree.root);
        System.out.println();
        System.out.println("前序");
        recursivelyPreTraversal(tree.root);
        System.out.println();
        System.out.println("中序");
        recursivelyInTraversal(tree.root);
        System.out.println();
        System.out.println("后序");
        recursivelyPostTraversal(tree.root);
    }

    /**
     * 插入节点
     *
     * @param data
     * @return
     */
    public RedBlackTreeNode insert(int data) {
        RedBlackTreeNode insert = new RedBlackTreeNode(data);
        if (root == null) {
            root = insert;
            setBlack(insert);
        } else {
            RedBlackTreeNode parent = null;
            RedBlackTreeNode node = root;
            while (node != null) {
                parent = node;
                if (node.getData() >= data) {
                    //左子树
                    node = node.getLeft();
                } else {
                    //右子树
                    node = node.getRight();
                }
            }

            //跳出循环则说明找到插入位置
            if (parent.getData() >= data) {
                parent.setLeft(insert);
            } else {
                parent.setRight(insert);
            }
            insert.setParent(parent);

            //旋转和调整节点颜色保持红黑树平衡
            insertFix(insert);
        }
        return insert;
    }



    /**
     * 旋转和调整节点颜色保持红黑树平衡
     *
     * @param node 插入节点
     */
    private void insertFix(RedBlackTreeNode node) {
        while (node.getParent() != null && isRed(node.getParent())) {
            RedBlackTreeNode parent = node.getParent();
            RedBlackTreeNode grandFather = parent.getParent();
            if (grandFather.getLeft() == parent) {
                //F为G左儿子的情况
                RedBlackTreeNode uncle = grandFather.getRight();
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (parent.getRight() == node) {
                    //插入节点为父节点的右子树

                    //左旋
                    leftRotate(parent);

                    //将旋转后的parent看作插入节点
                    RedBlackTreeNode tmp = node;
                    node = parent;
                    parent = tmp;
                }
                setBlack(parent);
                setRed(grandFather);
                rightRotate(grandFather);
                break;
            } else {
                //F为G的右儿子的情况，对称操作
                RedBlackTreeNode uncle = grandFather.getLeft();
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (parent.getLeft() == node) {
                    //插入位置为父节点的左子树

                    //右旋
                    rightRotate(parent);

                    RedBlackTreeNode tmp = node;
                    node = parent;
                    parent = tmp;
                }
                setBlack(parent);
                setRed(grandFather);
                leftRotate(grandFather);
                break;
            }
        }
        setBlack(root);
    }

    /**
     * 删除节点
     *
     * @param data
     * @return
     */
    public RedBlackTreeNode delete(int data) {
        RedBlackTreeNode node = query(data);
        if (node == null) {
            return null;
        }
        deleteNode(node);
        return node;
    }

    /**
     * 查询节点
     *
     * @param data
     * @return
     */
    public RedBlackTreeNode query(int data) {
        if (root == null) {
            return null;
        }
        RedBlackTreeNode node = root;
        while (node != null) {
            if (node.getData() == data) {
                return node;
            } else if (node.getData() >= data) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return null;
    }

    private void deleteNode(RedBlackTreeNode node) {
        if (node == null) {
            return;
        }
        //替换节点
        RedBlackTreeNode replaceNode = null;
        if (node.getLeft() != null && node.getRight() != null) {
            //存在左右子树
            RedBlackTreeNode tmp = node.getRight();
            while (tmp != null) {
                replaceNode = tmp;
                tmp = tmp.getLeft();
            }
            //将替换节点的值放到原本需要删除的节点
            node.setData(replaceNode.getData());
            //删除替换节点
            node = replaceNode;
        }

        if (node.getLeft() != null) {
            replaceNode = node.getLeft();
        } else {
            replaceNode = node.getRight();
        }
        RedBlackTreeNode parent = node.getParent();
        if (parent == null) {
            root = replaceNode;
            if (replaceNode != null) {
                replaceNode.setParent(null);
            }
        } else {
            if (parent.getLeft() == node) {
                parent.setLeft(replaceNode);
            } else {
                parent.setRight(replaceNode);
            }
            if (replaceNode != null) {
                replaceNode.setParent(parent);
            }
        }
        if (isBlack(node)) {
            //replaceNode为了保持平衡，多了一个黑色，需修复
            removeFix(parent, replaceNode);
        }
    }

    /**
     * 修复
     *
     * @param parent
     * @param node   多了一个黑色
     */
    private void removeFix(RedBlackTreeNode parent, RedBlackTreeNode node) {
        while (isBlack(node) && node != root) {
            if (parent.getLeft() == node) {
                //S是P的左儿子
                RedBlackTreeNode brother = parent.getRight();
                if (isRed(brother)) {
                    setBlack(brother);
                    setRed(parent);
                    leftRotate(parent);
                    brother = parent.getRight();
                }
                if (brother == null || (isBlack(brother.getLeft()) && isBlack(brother.getRight()))) {
                    setRed(brother);
                    node = parent;
                    parent = node.getParent();
                    continue;
                }
                if (isRed(brother.getLeft()) && isBlack(brother.getRight())) {
                    setRed(brother);
                    setBlack(brother.getLeft());
                    rightRotate(brother);
                    brother = parent.getRight();
                }
                brother.setColor(parent.isColor());
                setBlack(parent);
                setBlack(brother.getRight());
                leftRotate(parent);
                node = root;
            } else {
                //S是P的右儿子
                RedBlackTreeNode brother = parent.getLeft();
                if (isRed(brother)) {
                    setBlack(brother);
                    setRed(parent);
                    rightRotate(parent);
                    brother = parent.getLeft();
                }
                if (brother == null || (isBlack(brother.getLeft()) && isBlack(brother.getRight()))) {
                    setRed(brother);
                    node = parent;
                    parent = node.getParent();
                    continue;
                }
                if (isRed(brother.getRight()) && isBlack(brother.getLeft())) {
                    setBlack(brother.getRight());
                    setRed(brother);
                    leftRotate(brother);
                    brother = parent.getLeft();
                }
                brother.setColor(parent.isColor());
                setBlack(parent);
                setBlack(brother.getLeft());
                rightRotate(parent);
                node = root;
            }
        }
        if (node != null) {
            setBlack(node);
        }
    }

    /**
     * 左旋
     *
     * @param node
     */
    private void leftRotate(RedBlackTreeNode node) {
        RedBlackTreeNode right = node.getRight();
        RedBlackTreeNode parent = node.getParent();

        node.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        node.setParent(right);

        right.setLeft(node);
        if (parent == null) {
            root = right;
            right.setParent(null);
        } else {
            right.setParent(parent);
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
        }
    }

    /**
     * 右旋
     *
     * @param node
     */
    private void rightRotate(RedBlackTreeNode node) {
        RedBlackTreeNode left = node.getLeft();
        RedBlackTreeNode parent = node.getParent();

        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        node.setParent(left);

        left.setRight(node);
        if (parent == null) {
            root = left;
            left.setParent(null);
        } else {
            left.setParent(parent);
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
        }
    }

    /**
     * 设置颜色为黑
     *
     * @param node
     */
    public static void setBlack(RedBlackTreeNode node) {
        if (node == null) {
            return;
        } else {
            node.setColor(RedBlackTreeNode.Black);
        }
    }

    /**
     * 设置颜色为红
     *
     * @param node
     */
    public static void setRed(RedBlackTreeNode node) {
        if (node == null) {
            return;
        } else {
            node.setColor(RedBlackTreeNode.Red);
        }
    }

    /**
     * 是否是黑色节点
     *
     * @param node
     * @return
     */
    public static boolean isBlack(RedBlackTreeNode node) {
        if (node == null) {
            return true;
        } else {
            return node.isColor() == RedBlackTreeNode.Black;
        }
    }

    /**
     * 是否是红色节点
     *
     * @param node
     * @return
     */
    public static boolean isRed(RedBlackTreeNode node) {
        if (node == null) {
            return false;
        } else {
            return node.isColor() == RedBlackTreeNode.Red;
        }
    }

    /**
     * 层级遍历
     *
     * @param root
     */
    public static void levelTraversal(RedBlackTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<RedBlackTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            RedBlackTreeNode poll = queue.poll();
            String color = "Black";
            if (isRed(poll)) {
                color = "Red";
            }
            System.out.print(poll.getData() + "(" + color + ") ");
            if (poll.getLeft() != null) {
                queue.offer(poll.getLeft());
            }
            if (poll.getRight() != null) {
                queue.offer(poll.getRight());
            }
        }
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public static void recursivelyPreTraversal(RedBlackTreeNode node) {
        if (node == null) {
            return;
        }
        String color = "Black";
        if (isRed(node)) {
            color = "Red";
        }
        System.out.print(node.getData() + "(" + color + ") ");
        recursivelyPreTraversal(node.getLeft());
        recursivelyPreTraversal(node.getRight());
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void recursivelyInTraversal(RedBlackTreeNode node) {
        if (node == null) {
            return;
        }
        recursivelyInTraversal(node.getLeft());
        String color = "Black";
        if (isRed(node)) {
            color = "Red";
        }
        System.out.print(node.getData() + "(" + color + ") ");
        recursivelyInTraversal(node.getRight());
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public static void recursivelyPostTraversal(RedBlackTreeNode node) {
        if (node == null) {
            return;
        }
        recursivelyPostTraversal(node.getLeft());
        recursivelyPostTraversal(node.getRight());
        String color = "Black";
        if (isRed(node)) {
            color = "Red";
        }
        System.out.print(node.getData() + "(" + color + ") ");
    }
}