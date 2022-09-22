package edu.cmu.optimisticStrivers.OA.SIG;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/22 9:42 AM
 * @Version 1.0
 */
public class Q1 {

    long solution(String[] queryType, int[][] query) {
        long res = 0;

        int len = queryType.length;
        for (int i = 0; i < len; i++) {
            String type = queryType[i];
            int[] q = query[i];

            if(type.equals("insert")){
                insert(q[0],q[1]);
            }else if(type.equals("addToValue")){
                addToValue(q[0]);
            }else if(type.equals("addToKey")){
                addToKey(q[0]);
            }else{
                res += map.get((long)q[0]);
                System.out.println(map.get((long)q[0]));
                // for(Map.Entry<Long, Long> entry : map.entrySet()){
                //     res += entry.getValue();
                //     return res;
                // }
            }

        }
        return 0L;

    }

    static HashMap<Long,Long> map = new HashMap<>();

// long[] list = new long[(long)Math.pow(10, 10)];
// int addValue = 0;
// int addToKey = 0;

    public void insert(int key, int value){
        System.out.println(123);
        map.put((long)key, (long)value);
    }


    public void addToValue(int value){
        for(Map.Entry<Long, Long> entry : map.entrySet()){
            map.put(entry.getKey(),entry.getValue()+value);
        }
    }


    public void addToKey(int key){
        HashMap<Long,Long> newMap = new HashMap<>();
        for(Map.Entry<Long, Long> entry : map.entrySet()){
            newMap.put(entry.getKey()+key,entry.getValue());
        }
        map = newMap;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        String[] strings = {"insert",
                "insert",
                "addToValue",
                "addToKey",
                "get"};
        int[][] ints = {{1, 2}, {2, 3}, {2}, {1}, {3}};

        System.out.println(q1.solution(strings, ints));

//        System.out.println(map.get((long)3));
    }


    
}
