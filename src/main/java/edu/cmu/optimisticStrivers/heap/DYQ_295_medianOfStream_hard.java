package edu.cmu.optimisticStrivers.heap;

import java.util.PriorityQueue;

/**
 * @ClassName: DYQ_295_medianOfStream_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 9:59 PM
 * @Version 1.0
 */
public class DYQ_295_medianOfStream_hard {
    class MedianFinder {
        //始终保持 maxHeap比minHeap多0或者1个
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {return  b - a ;}); //存小的
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //存大的

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.offer(num);
                return;
            }
            if (maxHeap.size() > minHeap.size()) { //要往minHeap里面加
                if (num < maxHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }
            } else {
                if (num > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                } else {
                    maxHeap.offer(num);
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() != minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }

}
