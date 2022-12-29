package edu.cmu.optimisticStrivers.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: LRUHashMap
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/12 3:38 PM
 * @Version 1.0
 */
public class LRUHashMap<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_CACHE_SIZE;

    public LRUHashMap(int cacheSize) {
        super(cacheSize, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CACHE_SIZE;
    }


    public static void main(String[] args) {
        LRUHashMap<Integer, Integer> map = new LRUHashMap(3);
        map.put(1, 3);
        map.put(2, 2);
        map.put(9, 10);
        map.put(3, 6);
        map.put(4, 9);
//        map.put(5, 10);
//        map.put(6, 11);

        System.out.println("size  map.size()   " + map.size());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            System.out.println(integerIntegerEntry.getValue());
        }
    }
}
