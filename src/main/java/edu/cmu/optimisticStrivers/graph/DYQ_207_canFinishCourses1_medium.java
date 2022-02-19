package edu.cmu.optimisticStrivers.graph;

import java.util.*;

/**
 * @ClassName: DYQ_207_canFinishCourses1_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/13 5:43 下午
 * @Version 1.0
 */
public class DYQ_207_canFinishCourses1_medium {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses]; //入度表
        Map<Integer, List<Integer>> map = new HashMap<>(); //邻接表，List可以用queue？bfs？
        for (int i = 0; i < prerequisites.length; i++) {
            inDegrees[prerequisites[i][0]]++;
            if(map.containsKey(prerequisites[i][1])) { //当前课已经存在于邻接表
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else{
                map.put(prerequisites[i][1],new ArrayList<Integer>());
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>(); //当前入度为0的所有节点
        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i]==0){
                queue.add(i);
            }
        }
        int count = 0;
        List<Integer> curList;
        while (!queue.isEmpty()){ //学期进行时
            int cur = queue.poll();
            count++;
            curList = map.get(cur);//获得后续课
            if(curList==null) continue; //当前课，没有后续课
            for (int i = 0; i < curList.size() ; i++) { //有后续课的话
                inDegrees[curList.get(i)]--; //入度减1
                if(inDegrees[curList.get(i)]==0){
                    queue.add(curList.get(i));
                }
            }
        }
        return count == numCourses;
    }
    public static void main(String[] args) {
        int[][] a = {{1,0}};
        System.out.println(canFinish(2, a));
    }
}
