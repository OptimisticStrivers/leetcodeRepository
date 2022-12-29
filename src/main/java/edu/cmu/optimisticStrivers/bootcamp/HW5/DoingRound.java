package edu.cmu.optimisticStrivers.bootcamp.HW5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: DoingRound
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/1 12:50 PM
 * @Version 1.0
 */
public class DoingRound {


    //最短路径 bfs>dfs 除非dfs很好剪枝
//    static int minSteps1(int[][] grounds, int gb_x, int gb_y, int exit_x, int exit_y, int lock_count) {
//        if (grounds.length == 0 || grounds[0].length == 0) return -1; //纯纯的傻逼 题目里面给了吗 就让我们去test boundary？脸都不要了？
//        for (int i = 0; i < grounds.length; i++) {
//            for (int j = 0; j < grounds[0].length; j++) {
//                System.out.print(grounds[i][j] + " ");
//            }
//            System.out.println();
//        }
////        if(grounds[gb_x])
//
//        int step = 0;
//        //bfs 一步一步走 结束的条件就是
//        // 1：-1  下一步能到达的点 和 上一步 相同  就是动都动不了了
//        // 2：找到了 return
//        Set<String> pre = new HashSet<>();
//        Set<String> cur = new HashSet<>();
//        cur.add(gb_x + "," + gb_y);
////        Set<String> checkedLock = new HashSet<>(); //某一步 到所有点的 过锁数
//        int[][] checkLock = new int[grounds.length][grounds[0].length];
//        boolean[][] lock = new boolean[grounds.length][grounds[0].length];
//
////        HashMap<String, Integer> checkedLock = new HashMap<>();
////        int curLock = 0;
//        while (!checkIdentical(pre, cur)) {
////            if (step > 20) return -1;
//            System.out.println("step " + step);
//            System.out.println("pre " + pre);
//            System.out.println("cur " + cur);
//            printLock(checkLock);
//            Set<String> temp = new HashSet<>();
//            for (String position : cur) {
//                String[] split = position.split(",");
//                int x = Integer.parseInt(split[0]);
//                int y = Integer.parseInt(split[1]);
//                if (grounds[x][y] > 1 && !lock[x][y]) {
//                    checkLock[x][y]++; //加锁  但是 必须之前没有加过
//                    lock[x][y] = true;
//                }
////                String pos = x + "," + y;
//                if (x == exit_x && y == exit_y && checkLock[x][y] == lock_count) return step;
//                if (x + 1 < grounds.length && grounds[x + 1][y] != 1) { //down
//                    temp.add((x + 1) + "," + y);
//                    //不能让同一步 其他路线 反而更新值 变小
//                    //这里先不管 下一格是不是锁子 只要能到就行
//                    if (checkLock[x][y] > checkLock[x + 1][y]) checkLock[x + 1][y] = checkLock[x][y];
//                }
//                if (x - 1 >= 0 && grounds[x - 1][y] != 1) { //up
//                    temp.add((x - 1) + "," + y);
//                    if (checkLock[x][y] > checkLock[x - 1][y]) checkLock[x - 1][y] = checkLock[x][y];
//                }
//                if (y + 1 < grounds[0].length && grounds[x][y + 1] != 1) { //right
//                    temp.add(x + "," + (y + 1));
//                    if (checkLock[x][y] > checkLock[x][y + 1]) checkLock[x][y + 1] = checkLock[x][y];
//                }
//                if (y - 1 >= 0 && grounds[x][y - 1] != 1) { //left
//                    temp.add(x + "," + (y - 1));
//                    if (checkLock[x][y] > checkLock[x][y - 1]) checkLock[x][y - 1] = checkLock[x][y];
//                }
//            }
//            System.out.println("temp " + temp);
//            System.out.println();
//            pre = cur;
//            cur = temp;
//            step++;
//        }
//        return -1;
//    }


//    public static boolean checkIdentical(Set<String> pre, Set<String> cur) {
//        for (String s : cur) {
//            if (!pre.contains(s)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void printLock(int[][] locks) {
//        for (int i = 0; i < locks.length; i++) {
//            for (int j = 0; j < locks[0].length; j++) {
//                System.out.print(locks[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }


//    超时的原因就是
//    我们bfs 也应该剪一点 "枝"
//    走过的不要循环走

//    static int minSteps(int[][] grounds, int gb_x, int gb_y, int exit_x, int exit_y, int lock_count) {
//        if (grounds.length == 0 || grounds[0].length == 0) return -1; //纯纯的傻逼 题目里面给了吗 就让我们去test boundary？脸都不要了？
//        if (grounds[gb_x][gb_y] == 1) return -1;
//
//        int step = 0;
//        //bfs 一步一步走 结束的条件就是
//        // 1：-1  下一步能到达的点 和 上一步 相同  就是动都动不了了
//        // 2：找到了 return
//        Set<String> pre = new HashSet<>();
//        Set<String> cur = new HashSet<>();
//        cur.add(gb_x + "," + gb_y);
//        int[][] checkLock = new int[grounds.length][grounds[0].length];
//        boolean[][] hasAddLock = new boolean[grounds.length][grounds[0].length];
//        boolean[][] visited = new boolean[grounds.length][grounds[0].length];
//        visited[gb_x][gb_y] = true;
//        if (grounds[gb_x][gb_y] > 1) {
//            checkLock[gb_x][gb_y] = 1;
//            hasAddLock[gb_x][gb_y] = true;
//        }
//
//        while (!checkIdentical(pre, cur)) {
//            System.out.println("step " + step);
////            if (step > 40) return -1;
//            System.out.println("pre " + pre);
//            System.out.println("cur " + cur);
//            printLock(checkLock);
//            Set<String> temp = new HashSet<>();
//            for (String position : cur) {
//                String[] split = position.split(",");
//                int x = Integer.parseInt(split[0]);
//                int y = Integer.parseInt(split[1]);
//                System.out.println("x " + x + " y " + y);
//                if (x == exit_x && y == exit_y && checkLock[x][y] == lock_count) return step;
//                int temp1;
//                if (x + 1 < grounds.length && grounds[x + 1][y] != 1) { //down
//                    temp1 = checkLock[x][y];
//                    System.out.println(!visited[x + 1][y]);
//                    if (!visited[x + 1][y]) { //没有到过的话 直接到就行
//                        temp.add((x + 1) + "," + y);
//                        if(grounds[x + 1][y] > 1){
//                            hasAddLock
//                        }
//                        checkLock[x + 1][y] = temp1 + (grounds[x + 1][y] > 1 ? 1 : 0);
//                        visited[x + 1][y] = true;
//                    } else { //到过的话 需要收益更高 才能再到
//                        System.out.println("! " + (grounds[x + 1][y] > 1 && !hasAddLock[x + 1][y]));
//                        if (grounds[x + 1][y] > 1 && !hasAddLock[x + 1][y]) {
//                            temp1 += 1;
//                        }
//                        if (temp1 > checkLock[x + 1][y]) { //如果没有来过这个方向 或者 来过的话但目前收益高
//                            temp.add((x + 1) + "," + y);
//                            checkLock[x + 1][y] = temp1;
//                        }
//                    }
//                }
//                if (x - 1 >= 0 && grounds[x - 1][y] != 1) { //up
//                    temp1 = checkLock[x][y];
//                    if (!visited[x - 1][y]) { //没有到过的话 直接到就行
//                        temp.add((x - 1) + "," + y);
//                        checkLock[x - 1][y] = temp1 + (grounds[x - 1][y] > 1 ? 1 : 0);
//                        visited[x - 1][y] = true;
//                    } else { //到过的话 需要收益更高 才能再到
//                        if (grounds[x - 1][y] > 1 && !hasAddLock[x - 1][y]) { // 有锁 且 没有没加过的话
//                            temp1 += 1;
//                        }
//                        if (temp1 > checkLock[x - 1][y]) {
//                            temp.add((x - 1) + "," + y);
//                            checkLock[x - 1][y] = temp1;
//                        }
//                    }
//
//                }
//                if (y + 1 < grounds[0].length && grounds[x][y + 1] != 1) { //right
//                    temp1 = checkLock[x][y];
//                    if (!visited[x][y + 1]) { //没有到过的话 直接到就行
//                        temp.add(x + "," + (y + 1));
//                        checkLock[x][y + 1] = temp1 + (grounds[x][y + 1] > 1 ? 1 : 0);
//                        visited[x][y + 1] = true;
//
//                    } else { //到过的话 需要收益更高 才能再到
//                        if (grounds[x][y + 1] > 1 && !hasAddLock[x][y + 1]) { // 有锁 且 没有没加过的话
//                            temp1 += 1;
//                        }
//                        if (temp1 > checkLock[x][y + 1]) {
//                            temp.add(x + "," + (y + 1));
//                            checkLock[x][y + 1] = temp1;
//                        }
//                    }
//                }
//                if (y - 1 >= 0 && grounds[x][y - 1] != 1) { //left
//                    temp1 = checkLock[x][y];
//                    if (!visited[x][y - 1]) { //没有到过的话 直接到就行
//                        temp.add(x + "," + (y - 1));
//                        checkLock[x][y - 1] = temp1 + (grounds[x][y - 1] > 1 ? 1 : 0);
//                        visited[x][y - 1] = true;
//                    } else { //到过的话 需要收益更高 才能再到
//                        if (grounds[x][y - 1] > 1 && !hasAddLock[x][y - 1]) { // 有锁 且 没有没加过的话
//                            temp1 += 1;
//                        }
//                        //todo
//                        if (temp1 > checkLock[x][y - 1]) { //需要回去呀  不回去哪里可以呀 所以要加等号  但是加了等号 不就又有了循环了 就又超时了
//                            temp.add(x + "," + (y - 1));
//                            checkLock[x][y - 1] = temp1;
//                        }
//                    }
//                }
//            }
////            System.out.println("temp " + temp);
//            System.out.println();
//            pre = cur;
//            cur = temp;
//            step++;
//        }
//        return -1;
//    }


//    static int minSteps(int[][] grounds, int gb_x, int gb_y, int exit_x, int exit_y, int lock_count) {
//        if (grounds.length == 0 || grounds[0].length == 0) return -1; //纯纯的傻逼 题目里面给了吗 就让我们去test boundary？脸都不要了？
//        if (grounds[gb_x][gb_y] == 1) return -1;
//        int[][] ints = new int[grounds.length][grounds[0].length];
//        int initialCounter = 2;
//        for (int i = 0; i < ints.length; i++) {
//            for (int j = 0; j < ints[0].length; j++) {
//                if (grounds[i][j] >= 2) {
//                    ints[i][j] = initialCounter++;
//                } else {
//                    ints[i][j] = grounds[i][j];
//                }
//            }
//        }
//        int[][][] shortestPath = new int[grounds.length][grounds[0].length][Path.allLocks(lock_count)];
//        //我们最后要的 肯定是shortestPath 最后一个
//        grounds = ints;
////        System.out.println("bitmask representing all locks int:  " + totalMask);
////        System.out.println("bitmask representing all locks binary:  " + Integer.toBinaryString(totalMask));
//        Path initialPath = new Path(gb_x, gb_y);//起点的booth一定没有锁吗 不一定
//        initialPath.length = 0;
//        initialPath.checked = Path.addLock(0, grounds, gb_x, gb_y);
//        int[] directions = new int[]{0, 1, 2, 3}; //up left down right
//        List<Path> cur = new ArrayList<>();
//        cur.add(initialPath);
//        int step = 0;
//        while (cur.size() != 0) { //一步一步走
//            System.out.println("step " + step);
//            if (step > 4) return -1;
//            List<Path> temp = new ArrayList<>();
//            System.out.println("cur : " + cur.size());
//            System.out.println("cur : " + cur);
//            for (Path path : cur) {
////                System.out.println("X " + path.x + " Y " + path.y);
//                if (path.at(exit_x, exit_y) && path.checkedAll(lock_count)) {
//                    return path.length;
//                }
//                for (int direction : directions) { //四个方向
//                    Path newPath = path.move(grounds, direction);
//                    if (newPath != null && newPath.checked > path.checked) {
////                        newPath.checked >= path.checked
//                        //相等不可以走？相等应该可以啊 因为没有锁也要发展啊
//                        //等于是可以的 因为要发展 但是等于的话 会死循环啊
//                        temp.add(newPath); //这里需要剪啊
//                    }
//                }
//            }
//            System.out.println();
//            step++;
//            cur = temp;
//        }
//        return -1;
//    }


//    static int minSteps(int[][] grounds, int gb_x, int gb_y, int exit_x, int exit_y, int lock_count) {
//        if (grounds.length == 0 || grounds[0].length == 0) return -1;
//        if (grounds[gb_x][gb_y] == 1) return -1;
//        int[][] ints = new int[grounds.length][grounds[0].length];
//        int initialCounter = 2;
//        for (int i = 0; i < ints.length; i++) {
//            for (int j = 0; j < ints[0].length; j++) {
//                if (grounds[i][j] >= 2) {
//                    ints[i][j] = initialCounter++;
//                } else {
//                    ints[i][j] = grounds[i][j];
//                }
//            }
//        }
//        int[][][] shortestPath = new int[grounds.length][grounds[0].length][Path.combinations(lock_count)];
//        System.out.println("len "+ shortestPath[0][0].length);
////        Arrays.fill(shortestPath[], );
//        grounds = ints;
//        Path initialPath = new Path(gb_x, gb_y);//起点的booth一定没有锁吗 不一定
//        initialPath.length = 0;
//        initialPath.checked = Path.addLock(0, grounds, gb_x, gb_y);
//        initialPath.visited = Path.addVisited(grounds, gb_x, gb_y, 0);
//        shortestPath[gb_x][gb_y][initialPath.checked] = 0; //一开始如果是>=2 就直接有一个锁了
//
//        int[] directions = new int[]{0, 1, 2, 3}; //up left down right
//        List<Path> cur = new ArrayList<>();
//        cur.add(initialPath);
//        int step = 0;
//        while (cur.size() != 0) { //一步一步走
//            System.out.println("step " + step);
////            if (step > 4) return -1;
//            List<Path> temp = new ArrayList<>();
////            System.out.println("cur : " + cur.size());
//            System.out.println("cur : " + cur);
//            for (Path path : cur) {
////                System.out.println("X " + path.x + " Y " + path.y);
//                if (path.at(exit_x, exit_y) && path.checkedAll(lock_count)) {
//                    return path.length;
//                }
//                for (int direction : directions) { //四个方向
//                    System.out.println("direction " + direction);
//                    Path newPath = path.move(grounds, direction); //move的时候 这个新点 就已经 加入 newPath 的 visited mask了
//                    if (newPath != null && !Path.hasVisited(grounds, newPath.x, newPath.y, path.visited)) { //如果是可以到达的点 还必须是 这条路径之前没有遇到过才可以加入temp
//                        //如果是一个新的锁点的话 其 visited 应该重置  然后加入temp
//                        if (newPath.checked > path.checked) {
//                            newPath.visited = Path.addVisited(grounds, newPath.x, newPath.y, 0);
//                        }
//                        //如果只是一个普通点 加入temp即可
//                        shortestPath[newPath.x][newPath.y][newPath.checked] = Math.min(shortestPath[newPath.x][newPath.y][newPath.checked], newPath.length);
//                        temp.add(newPath);
//                    }
//                }
//            }
//            System.out.println();
//            step++;
//            cur = temp;
//
//        }
//        return -1;
//    }


    static int minSteps(int[][] grounds, int gb_x, int gb_y, int exit_x, int exit_y, int lock_count) {
        if (grounds.length == 0 || grounds[0].length == 0) return -1;
        if (grounds[gb_x][gb_y] == 1) return -1;
        int[][] ints = new int[grounds.length][grounds[0].length];
        int initialCounter = 2;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                if (grounds[i][j] >= 2) {
                    ints[i][j] = initialCounter++;
                } else {
                    ints[i][j] = grounds[i][j];
                }
            }
        }
        grounds = ints;

        int combinationNum = Path.combinations(lock_count);
//        4*4*8
        boolean[][][] visited = new boolean[grounds.length][grounds[0].length][combinationNum];
        Queue<Path> queue = new LinkedList<>();
        Path initialPath = new Path(gb_x, gb_y);//起点的booth一定没有锁吗 不一定
        initialPath.length = 0;
        initialPath.checked = Path.addLock(0, grounds, gb_x, gb_y);
        queue.add(initialPath);
        visited[gb_x][gb_y][Path.lockMask(grounds, gb_x, gb_y)] = true; //意思是  这个路径mask 在这个点已经 取到过了 //todo

        if (initialPath.checkedAll(lock_count)) {
            return 0;
        }
        int[] directions = new int[]{0, 1, 2, 3}; //up left down right
        // 记录BFS的层数，当访问满了所有节点，返回这个层数即可
//        int level = 0;
        while (!queue.isEmpty()) {
//            System.out.println("level " + level);
//            System.out.println(queue);
//            level++;
            // 一层一层遍历
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 当前节点
                Path path = queue.poll();
                for (int direction : directions) { //四个方向
                    Path newPath = path.move(grounds, direction);
                    if (newPath != null) {
//                        System.out.println("direction " + direction);
//                        System.out.println("old " + path);
//                        System.out.println("new " + newPath);
                        int check = newPath.checked;
                        if (newPath.at(exit_x, exit_y) && newPath.checkedAll(lock_count)) {
                            return newPath.length;
                        }
                        // 下一个节点下一个状态未访问过，下探
                        if (!visited[newPath.x][newPath.y][check]) {
                            queue.offer(newPath);
                            visited[newPath.x][newPath.y][check] = true;
                        }
                    }
                }
            }
//            System.out.println();
        }
        return -1;
    }

//
//
////    https://leetcode.cn/problems/shortest-path-visiting-all-nodes/solution/tong-ge-lai-shua-ti-la-bfs-si-lu-zhuan-h-jl3s/
//    static int minSteps(int[][] grounds, int gb_x, int gb_y, int exit_x, int exit_y, int lock_count) {
//        if (grounds.length == 0 || grounds[0].length == 0) return -1;
//        if (grounds[gb_x][gb_y] == 1) return -1;
//        int[][] ints = new int[grounds.length][grounds[0].length];
//        int initialCounter = 2;
//        for (int i = 0; i < ints.length; i++) {
//            for (int j = 0; j < ints[0].length; j++) {
//                if (grounds[i][j] >= 2) {
//                    ints[i][j] = initialCounter++;
//                } else {
//                    ints[i][j] = grounds[i][j];
//                }
//            }
//        }
//        grounds = ints;
//        int combinationNum1 = Path.combinations(lock_count);
//        boolean[][][] visited = new boolean[grounds.length][grounds[0].length][combinationNum1];
//        Queue<Path> queue = new LinkedList<>();
//        Path initialPath = new Path(gb_x, gb_y);
//        initialPath.length = 0;
//        initialPath.checked = Path.addLock(0, grounds, gb_x, gb_y);
//        queue.add(initialPath);
//        visited[gb_x][gb_y][Path.lockMask(grounds, gb_x, gb_y)] = true;
//        if (initialPath.checkedAll(lock_count)) {
//            return 0;
//        }
//        int[] directions = new int[]{0, 1, 2, 3};
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Path path1 = queue.poll();
//                for (int d : directions) {
//                    Path newPath = path1.move(grounds, d);
//                    if (newPath != null) {
//                        int check = newPath.checked;
//                        if (newPath.at(exit_x, exit_y) && newPath.checkedAll(lock_count)) {
//                            return newPath.length;
//                        }
//                        if (!visited[newPath.x][newPath.y][check]) {
//                            queue.offer(newPath);
//                            visited[newPath.x][newPath.y][check] = true;
//                        }
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
//        int[][] ints = new int[][]{{0, 2, 0}, {1, 1, 2}, {1, 0, 0}};
//        System.out.println("res " + minSteps(ints, 0, 1, 0, 0, 2));

//        int[][] ints = new int[][]{{0, 0}, {1, 0}};
//        System.out.println("res " + minSteps(ints, 1, 1, 1, 1, 0));

//        0 0
//        1 0
//        gb = (1, 1),exit = (1, 1)

//
//        int[][] ints = new int[][]{{0, 1}, {1, 2}};
//        System.out.println("res " + minSteps(ints, 0, 0, 1, 1, 1));

//        3 2 0
//        1 1 4
//        0 0 0
        int[][] ints = new int[][]{{3, 2, 0}, {1, 1, 4}, {0, 0, 0}};
        System.out.println("res " + minSteps(ints, 0, 1, 0, 1, 3));

//        int[][] ints = new int[][]{{2, 2, 0}, {1, 1, 2}, {1, 0, 0}};


//        System.out.println(Path.allLocks(10));
//        System.out.println(Integer.toBinaryString(Path.allLocks(10)));

//        System.out.println("res " + minSteps(ints, 0, 0, 0, 0, 1));
//        0 2 0
//        1 1 2
//        1 0 0
//
//        int[][] ints = new int[][]
//                {{0, 0, 2, 0, 0, 0, 2, 0},
//                        {0, 2, 0, 0, 0, 0, 2, 0},
//                        {0, 0, 0, 2, 0, 0, 0, 0},
//                        {0, 0, 2, 1, 1, 0, 0, 1},
//                        {0, 2, 2, 0, 2, 2, 0, 1},
//                        {0, 0, 0, 0, 0, 0, 0, 0},
//                        {1, 0, 1, 0, 0, 0, 0, 0},
//                        {0, 1, 0, 0, 0, 0, 0, 0}};
//        System.out.println("res " + minSteps(ints, 0, 0, 0, 0, 10));
    }


}
