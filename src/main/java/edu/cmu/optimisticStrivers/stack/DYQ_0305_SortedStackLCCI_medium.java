package edu.cmu.optimisticStrivers.stack;

import java.util.Stack;

/**
 * @ClassName: DYQ_0305_SortedStackLCCI_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/22 7:16 下午
 * @Version 1.0
 */
public class DYQ_0305_SortedStackLCCI_medium {

    public Stack<Integer> A; //main stack
    public Stack<Integer> B; //help stack，每次push A都会清空


    public class SortedStack{

        public SortedStack() {
            A = new Stack();
            B = new Stack();
        }

        public void push(int val) {
            while(!A.isEmpty()&&A.peek()<val){
                B.push(A.pop());
            }
            A.push(val);
            //给回来
            while(!B.isEmpty()){
                A.push(B.pop());
            }
        }

        public void pop() {
            if(!A.isEmpty()) A.pop();
        }

        public int peek() {
            return A.isEmpty() ? -1 : A.peek();
        }

        public boolean isEmpty() {
            return A.isEmpty();
        }
    }

}
