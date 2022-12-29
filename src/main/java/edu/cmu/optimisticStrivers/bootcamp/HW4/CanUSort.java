package edu.cmu.optimisticStrivers.bootcamp.HW4;

import java.util.*;

/**
 * @ClassName: CanUSort
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/24 9:49 PM
 * @Version 1.0
 */
public class CanUSort {

//    Complete the customSort function declared in your editor. It must take an array of integers arr of length N as a parameter and sort its elements in order of ascending frequency of occurrence, using numeric order as a secondary sort key. You may use any library functions you wish.
//Your customSort function should print the sorted (in order of non-decreasing frequency) elements of array arr. If two or more elements have the same frequency, this subset of elements should be sorted in non-decreasing numeric order. Each element must be printed on a new line.


    //每个元素打印一行
    static void customSort(int[] arr) {
        Arrays.sort(arr);
//        Map<Integer, List<Integer>> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int pre = arr[0];
        int preIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != pre) {
                if (!map.containsKey(i - preIndex)) {
                    map.put(i - preIndex, new ArrayList<>());
                }
                map.get(i - preIndex).add(pre);
                pre = arr[i];
                preIndex = i;
            }
        }
        if (!map.containsKey(arr.length - preIndex)) {
            map.put(arr.length - preIndex, new ArrayList<>());
        }
        map.get(arr.length - preIndex).add(arr[arr.length - 1]);
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            for (int i = 0; i < integerListEntry.getValue().size(); i++) {
                for (int j = 0; j < integerListEntry.getKey(); j++) {
                    System.out.println(integerListEntry.getValue().get(i));
                }
            }
        }
    }

    // for Code Visualizer
    public static void main(String[] args) {
        int[] values = {8,5,5,5,5,1,1,1,4,4};
        customSort(values);
    }


    //默认 key 升序

    //创建 TreeMap 集合，设置Key降序方法一：
    //TreeMap<Integer,UserInfo> userTreeMap = new TreeMap<>(Collections.reverseOrder());

    //创建 TreeMap 集合，设置Key降序方法二：
//    TreeMap<Integer, UserInfo> userTreeMap = new TreeMap<Integer, UserInfo>(new Comparator<Integer>() {
//        public int compare(Integer key1, Integer key2) {
//            //降序排序
//            return key2.compareTo(key1);
//        }
//    });

}
