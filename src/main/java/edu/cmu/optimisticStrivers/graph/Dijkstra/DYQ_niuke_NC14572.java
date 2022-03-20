package edu.cmu.optimisticStrivers.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName: DYQ_niuke_NC14572
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/20 11:48 上午
 * @Version 1.0
 */
public class DYQ_niuke_NC14572 {


//    https://ac.nowcoder.com/acm/problem/14572

    //这个题是 阿里20笔试，对称飞行棋的前置
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String[] scale = scanner.nextLine().split(" ");
            int n = Integer.parseInt(scale[0]);
            int m = Integer.parseInt(scale[1]);
            char[][] map = new char[n][m];
            int startX = 0, startY = 0;
            int endX = 0, endY = 0;
            for(int i = 0; i<n; i++){
                map[i] = scanner.nextLine().toCharArray();
                for(int j = 0; j<m; j++){
                    if(map[i][j]=='S'){
                        startX = i;
                        startY = j;
                    }
                    if(map[i][j]=='E'){
                        endX = i;
                        endY = j;
                    }
                }
            }


            Queue<int[]> queue = new ArrayDeque();
            queue.offer(new int[]{startX,startY});
            int count=0;
            boolean canReach = false;
            while(!queue.isEmpty()){
                int size = queue.size();
//                 System.out.println("size "+size);
                while(size>0){
                    int[] cur = queue.poll();
                    size--;
                    int x = cur[0];
                    int y = cur[1];
                    if(map[x][y] == '!' || map[x][y] == '#') continue;
                    //没有来过的话
                    if(map[x][y]=='E') {
                        canReach = true;
                        break;
                    }
                    //没有结束，标记此处为到过
                    map[x][y] = '!';
                    if(x-1>=0) queue.offer(new int[]{x-1,y});
                    if(x+1<n) queue.offer(new int[]{x+1,y});
                    if(y+1<m ) queue.offer(new int[]{x,y+1});
                    if(y-1>=0) queue.offer(new int[]{x,y-1});
                }

                if(canReach) break;
                if(queue.size()>0){ //大于0才说明，下一步能到达别的地方
                    count++;
                }
            }

            System.out.println(canReach?"Yes":"No");
//             System.out.println(count);






        }




    }


}


