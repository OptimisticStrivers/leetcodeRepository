package edu.cmu.optimisticStrivers.LRU_LFU;

import java.util.LinkedHashMap;

/**
 * @ClassName: DYQ_146_LRU_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/14 2:41 PM
 * @Version 1.0
 */
public class DYQ_146_LRU_medium {


    //linkedHashMap 是由双向链表 和 hashmap构成的

    int cap = 0;
    LinkedHashMap<Integer, Integer> cache;

    public DYQ_146_LRU_medium(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.cap = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            markedRecentUsed(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value); //覆盖一下 但是没有移到链表尾部
            markedRecentUsed(key);
        }else{
            if (cache.size() >= cap) {
                Integer keyPop = cache.keySet().iterator().next();
                cache.remove(keyPop);
            }
            cache.put(key,value);
        }
    }

    //有 才能 mark
    public void markedRecentUsed(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
}
