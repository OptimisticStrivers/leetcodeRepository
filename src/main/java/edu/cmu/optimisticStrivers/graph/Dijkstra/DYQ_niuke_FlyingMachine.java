package edu.cmu.optimisticStrivers.graph.Dijkstra;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName: DYQ_niuke_FlyingMachine
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/20 1:34 下午
 * @Version 1.0
 */
public class DYQ_niuke_FlyingMachine {

    //继 NC14572


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] nm = firstLine.split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        char[][] map = new char[n][m];
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        for (int i = 0; i < n; i++) {
            map[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                    continue;
                }
                if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                    map[i][j] = '.';
                }

            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY, 5, 0});
        int step = -1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int avaliableChance = cur[2];
            step = cur[3];
            if (x == endX && y==endY) {
                System.out.println(step);
                return;
            }
            if (x - 1 >= 0 && map[x - 1][y] == '.'){
                queue.offer(new int[]{x - 1, y, avaliableChance, step + 1});
                map[x-1][y] = '#'; //这样标记了以后，先到的地方，就不用再遍历了。
            }
            if (x + 1 < n && map[x + 1][y] == '.'){
                queue.offer(new int[]{x + 1, y, avaliableChance, step + 1});
                map[x+1][y] = '#';
            }
            if (y + 1 < m && map[x][y + 1] == '.') {
                queue.offer(new int[]{x, y + 1, avaliableChance, step + 1});
                map[x][y+1] = '#';
            }
            if (y - 1 >= 0 && map[x][y - 1] == '.'){
                queue.offer(new int[]{x, y - 1, avaliableChance, step + 1});
                map[x][y-1] = '#';
            }
            //能不用飞行次数，尽量还是别用
            if (avaliableChance >= 1 && map[n - 1 - x][m - 1 - y] == '.'){
                queue.offer(new int[]{n - 1 - x, m - 1 - y, avaliableChance - 1, step + 1});
                map[n - 1 - x][m - 1 - y]  = '#';
            }

        }

        System.out.println(-1);


    }


//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        String firstLine = scanner.nextLine();
//        String[] nm = firstLine.split(" ");
//        int n = Integer.parseInt(nm[0]);
//        int m = Integer.parseInt(nm[1]);
//        char[][] map = new char[n][m];
//        int startX = 0, startY = 0;
//        for (int i = 0; i < n; i++) {
//            map[i] = scanner.nextLine().toCharArray();
//            for (int j = 0; j < m; j++) {
//                if (map[i][j] == 'S') {
//                    startX = i;
//                    startY = j;
//                }
//            }
//        }
//
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{startX, startY, 5, 0});
//        int step = -1;
//        while (!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            int x = cur[0];
//            int y = cur[1];
//            int avaliableChance = cur[2];
//            step = cur[3];
//            if (map[x][y] == 'E') {
//                System.out.println(step);
//                return;
//            }
//            map[x][y] = '#';
//            if (x - 1 >= 0 && map[x - 1][y] != '#') queue.offer(new int[]{x - 1, y, avaliableChance, step + 1});
//            if (x + 1 < n && map[x + 1][y] != '#') queue.offer(new int[]{x + 1, y, avaliableChance, step + 1});
//            if (y + 1 < m && map[x][y + 1] != '#') queue.offer(new int[]{x, y + 1, avaliableChance, step + 1});
//            if (y - 1 >= 0 && map[x][y - 1] != '#') queue.offer(new int[]{x, y - 1, avaliableChance, step + 1});


//    这个做法不行，会栈溢出，有很多同一轮重复到的地方


//            //能不用飞行次数，尽量还是别用
//            if (avaliableChance >= 1 && map[n - 1 - x][m - 1 - y] != '#')
//                queue.offer(new int[]{n - 1 - x, m - 1 - y, avaliableChance - 1, step + 1});
//        }
//
//        System.out.println(-1);
//
//    }

}
