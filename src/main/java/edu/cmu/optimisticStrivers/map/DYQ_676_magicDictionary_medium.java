package edu.cmu.optimisticStrivers.map;

import java.util.*;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName: DYQ_676_magicDictionary_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/13 1:29 下午
 * @Version 1.0
 */
public class DYQ_676_magicDictionary_medium {

    Map<Integer, List<String>> map;
    //key为字符串长度，value为所有符合长度的字符串
    /** Initialize your data structure here. */
    public DYQ_676_magicDictionary_medium() {
        map = new HashMap<>();

    }

    public void buildDict(String[] dictionary) {
        List<String> cur = null;
        for(String str: dictionary){
            map.putIfAbsent(str.length(),new ArrayList<>());
            cur = map.get(str.length());
            cur.add(str);
        }
    }

    public boolean search(String searchWord) {
        int size = searchWord.length();
        List<String> cur = null;

        if(map.containsKey(size)){
            cur = map.get(size);
            for(String str : cur){
                int numOfDifference = 0;
                for(int i = 0; i<size; i++){
                    if(searchWord.charAt(i) == str.charAt(i)){
                        continue;
                    }
                    numOfDifference++;
                }
                if(numOfDifference == 1){
                    return true;
                }
            }
        }
        return false;
    }
}
