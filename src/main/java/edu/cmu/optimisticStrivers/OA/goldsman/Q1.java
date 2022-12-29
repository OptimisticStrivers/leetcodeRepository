package edu.cmu.optimisticStrivers.OA.goldsman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/16 9:29 PM
 * @Version 1.0
 */
public class Q1 {
    public static List<String> computeParameterValue(List<List<String>> sources) {
        // Write your code here
        List<String> res = new ArrayList<>();
        // Map<String,Integer> parameterToSource = new HashMap<>();
        Map<String,Integer> parameterToResindex = new HashMap<>();
        for(int sourceIndex = 0; sourceIndex < sources.size(); sourceIndex++){
            List<String> sourceContentList = sources.get(sourceIndex);
            for (int i = 0; i < sourceContentList.size(); i++) {
                String parameterKeyValue = sourceContentList.get(i);
                String[] keyValue = parameterKeyValue.split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                if(parameterToResindex.containsKey(key)){
                    res.set(parameterToResindex.get(key),value);
                    // parameterToResindex.set(key,res.size()-1);
                }else{
                    res.add(value);
                    parameterToResindex.put(key,res.size()-1);
                }
                // parameterToResindex.set(key,)
            }
        }
        return res;
    }


}
