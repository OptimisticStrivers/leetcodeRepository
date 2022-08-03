package edu.cmu.optimisticStrivers.priorityQueue;

import java.util.PriorityQueue;

/**
 * @ClassName: DYQ_jianzhi41_MedianFinder_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/4/1 10:55 下午
 * @Version 1.0
 */
public class DYQ_jianzhi41_MedianFinder_hard {


    //和两个栈实现队列有点像
    //美团的 3。26的第4题
    //两个堆

    PriorityQueue<Integer> left  = new PriorityQueue<>((a,b)-> b-a);
    PriorityQueue<Integer> right = new PriorityQueue<>(); //默认是小顶堆


    // 时间复杂度
    //添了，再排序 n * nlogn
    //找位置，后移元素 n * (search logn + insert n)
    //对顶堆 n * (search 1 + insert logn ) 当然如果一直一边一个的话就是这样，但是不是一边一个的话，可能会涉及到两次logn

    public void addNum(int num) {
        if (left.size()==0||num<=left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }
        if (left.size() - right.size()>1){
            right.offer(left.poll());
        }else if (right.size() > left.size()){
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()){
            return ((double) (left.peek() + right.peek()))/2;
        }else{
            return (double)left.peek();
        }
    }

}
