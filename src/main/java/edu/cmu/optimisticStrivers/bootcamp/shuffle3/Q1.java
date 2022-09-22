package edu.cmu.optimisticStrivers.bootcamp.shuffle3;

import java.util.*;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/21 11:43 AM
 * @Version 1.0
 */
public class Q1 {

    //anagram 相同字母异序词，易位构词，变位词

    //把所有 anagram 找到
    //并以 anagram 相邻顺序返回
    public String[] sort_all(String[] target) {
        int len = target.length;
        String[] copy = new String[len];
        for (int i = 0; i < len; i++) {
            char[] chars = target[i].toCharArray();
            Arrays.sort(chars);
            copy[i] = String.valueOf(chars);
        }

        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(copy[i])) {
                map.get(copy[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(copy[i], list);
            }
        }

        int counter = 0;
        String[] res = new String[len];
        for (Map.Entry<String, List<Integer>> stringListEntry : map.entrySet()) {
            for (Integer index : stringListEntry.getValue()) {
                res[counter++] = target[index];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Q1 q1 = new Q1();

        String[] strings = {"apple", "eat", "ate", "pplea"};
        String[] strings1 = q1.sort_all(strings);
        for (String s : strings1) {
            System.out.print(s + " ");
        }

    }
}
