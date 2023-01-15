package edu.cmu.optimisticStrivers.linkedList;

/**
 * @ClassName: DYQ_237_deleteNodeWithoutHead_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/15 12:25 AM
 * @Version 1.0
 */
public class DYQ_237_deleteNodeWithoutHead_medium {

//    这道题细思极恐：如何让自己在世界上消失，但又不死？ —— 将自己完全变成另一个人，再杀了那个人就行了。

    // 这道题是有点属于急转弯了，存粹为了做题而出题了。 node这个节点就是需要删除的节点；之前我们可以用head->next->val去判断下一个是否是删除的节点，然后head->next=head->next->next，这题可以用把 node下一节点复制到node，把下一节点跳过！变通，这道题出的挺有意思的！

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next; //一定有 题目说了 删除的节点一定不是最后一个
        node.val = nextNode.val;
        node.next = nextNode.next;

    }
}
