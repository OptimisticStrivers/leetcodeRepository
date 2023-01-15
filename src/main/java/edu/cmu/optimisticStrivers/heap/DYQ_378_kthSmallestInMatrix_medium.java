package edu.cmu.optimisticStrivers.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName: DYQ_378_kthSmallestInMatrix_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/10 10:35 PM
 * @Version 1.0
 */
public class DYQ_378_kthSmallestInMatrix_medium {

    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> (v2-v1)); //用大根堆 找倒数第k小
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(queue.size() < k){
                    queue.add(matrix[i][j]);
                }else if(matrix[i][j] < queue.peek()){
                    queue.poll();
                    queue.add(matrix[i][j]);
                }
            }
        }
        return queue.poll();
    }
}
