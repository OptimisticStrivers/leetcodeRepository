package edu.cmu.optimisticStrivers.graph;

import java.util.*;

/**
 * @ClassName: DYQ_210_canFinishCourses2_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/2/13 6:07 下午
 * @Version 1.0
 */
public class DYQ_210_canFinishCourses2_medium {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>(); //邻接表，List可以用queue？bfs？
        for (int i = 0; i < prerequisites.length; i++) {
            inDegrees[prerequisites[i][0]]++;
            if(map.containsKey(prerequisites[i][1])) { //当前课已经存在于邻接表
            }else{
                map.put(prerequisites[i][1],new ArrayList<Integer>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i]==0){
                queue.add(i);
            }
        }
        int[] path = new int[numCourses];
        int count = 0;
        List<Integer> curList;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            path[count] = cur;
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
        if(count==numCourses){
            return path;
        }else {
            return new int[0];
        }
    }
}
