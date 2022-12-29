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


    public static boolean areAnagrams(String A, String B) {

        HashMap<Character, Integer> objectObjectHashMap = new HashMap<>();
        for (char c : A.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                if (objectObjectHashMap.containsKey(c)) {
                    int val = objectObjectHashMap.get(c);
                    objectObjectHashMap.put(c, val + 1);
                } else {
                    objectObjectHashMap.put(c, 1);
                }
            }
        }


        for (char c : B.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                if(!objectObjectHashMap.containsKey(c)){
                    return false;
                }else{
                    Integer integer = objectObjectHashMap.get(c);
                    objectObjectHashMap.put(c,integer-1);
                }
            }
        }
        for (Character character : objectObjectHashMap.keySet()) {
            if(objectObjectHashMap.get(character) != 0){
                return false;
            }
        }
        return true;
    }

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
