package edu.cmu.optimisticStrivers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: DYQ_1801_numbersOfOrdersInTheBacklog
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/2/1 2:06 PM
 * @Version 1.0
 */
public class DYQ_1801_numbersOfOrdersInTheBacklog_medium {

    //其实原则就是
    //1 如果要买入 就要买能买的起的最便宜的
    //2 如果要卖出 就要卖出价出的起里，出价最高的


    //eg
    // Input: orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
    // orders[i] = [pricei, amounti, orderTypei]
    // orderType 1->sell 0->buy
    //Output: 6

    public static int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> bigHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); //big heap 保存所有的 buys
        PriorityQueue<int[]> smallHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); //small heap 保存所有的 sells

        for (int[] order : orders) {
            int orderType = order[2];
            int price = order[0];
            if (orderType == 1) { //want to sell
                // buy的价格必须比sell >=
                while (order[1] != 0 && !bigHeap.isEmpty() && bigHeap.peek()[0] >= order[0]) {
                    int has = bigHeap.peek()[1];
                    if (order[1] > has) {
                        order[1] -= has;
                        bigHeap.poll();
                    } else if (order[1] < has) {
                        bigHeap.peek()[1] -= order[1];
                        order[1] = 0;
                    } else {
                        bigHeap.poll();
                        order[1] = 0;
                    }
                }
                if (order[1] != 0) {
                    smallHeap.add(order);
                }
            } else {
                while (order[1] != 0 && !smallHeap.isEmpty() && smallHeap.peek()[0] <= order[0]) {
                    int has = smallHeap.peek()[1];
                    if (order[1] > has) {
                        order[1] -= has;
                        smallHeap.poll();
                    } else if (order[1] < has) {
                        smallHeap.peek()[1] -= order[1];
                        order[1] = 0;
                    } else {
                        smallHeap.poll();
                        order[1] = 0;
                    }
                }
                if (order[1] != 0) {
                    bigHeap.add(order);
                }
            }
            System.out.println(bigHeap.size());
            System.out.println(smallHeap.size());
            System.out.println();
        }

        int res = 0;
        for (int[] ints : bigHeap) {
            res += ints[1];
//            res =  res % (1000000000 + 7);
        }
        for (int[] ints : smallHeap) {
            res += ints[1];
//            res =  res % (1000000000 + 7);
        }
        return res % (1000000000 + 7);
    }

    public static void main(String[] args) {

        int[][] ints = new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}};
        System.out.println(getNumberOfBacklogOrders(ints));

    }

    public int getNumberOfBacklogOrders1(int[][] orders) {
        PriorityQueue<Integer> buyQue = new PriorityQueue<>((i1, i2)->orders[i2][0] - orders[i1][0]);
        PriorityQueue<Integer> sellQue = new PriorityQueue<>((i1, i2)->orders[i1][0] - orders[i2][0]);
        for(int i = 0; i < orders.length; i++){
            int[] o = orders[i];
            int type = o[2], price = o[0];
            if(type == 0){ // o是采购订单buy
                while(!sellQue.isEmpty() && o[1] > 0){
                    int[] q = orders[sellQue.peek()];
                    if(q[0] > price)break;
                    int min = Math.min(o[1], q[1]);
                    o[1] -= min;
                    q[1] -= min;
                    if(q[1] == 0)sellQue.poll();
                }
                if(o[1] > 0)buyQue.offer(i);
            }else{ // o是销售订单 sell
                while(!buyQue.isEmpty() && o[1] > 0){
                    int[] q = orders[buyQue.peek()];
                    if(q[0] < price)break;
                    int min = Math.min(o[1], q[1]);
                    o[1] -= min;
                    q[1] -= min;
                    if(q[1] == 0) buyQue.poll();;
                }
                if(o[1] > 0)sellQue.offer(i);
            }
        }

        int ret = 0;
        for(int[] o: orders)ret = (ret + o[1]) % (1000000007);
        return ret;
    }
}
