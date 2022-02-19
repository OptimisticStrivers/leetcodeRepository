package edu.cmu.optimisticStrivers.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName: DYQ_155_MinStack_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/22 7:11 下午
 * @Version 1.0
 */
public class DYQ_155_MinStack_easy {

    // 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
    // 辅助栈的使用

    public class  MinStack{
        Stack<Integer> A, B;
        //B是辅助栈
        /** initialize your data structure here. */
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.push(x);
            if (B.empty() || B.peek() >= x) {
                // 短路效应
                // 这里的等号用的好：B.peek() >= x 避免了重复最小值被弹出
                B.add(x);
            }
        }

        public void pop() {
            if (A.pop().equals(B.peek())) {
                B.pop();
            }
        }


        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }




}
