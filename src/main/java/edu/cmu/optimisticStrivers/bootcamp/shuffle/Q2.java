package edu.cmu.optimisticStrivers.bootcamp.shuffle;

/**
 * @ClassName: Q2
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/10 2:59 PM
 * @Version 1.0
 */
public class Q2 {



    public boolean check(String s1, String s2){

        int len1 = s1.length();
        int len2 = s2.length();
        if(Math.abs(len1 - len2) > 1) {
            return false;
        }

        if(len1 == len2){
            int count = 1;
            for (int i = 0; i < len1; i++) {
                if(s1.charAt(i)!=s2.charAt(i)){
                    if(count!=1){
                        return false;// can not replace
                    }
                    count--;
                }
            }
            return true;
        }

        String longer = "";
        String shorter = "";
        longer = len1>len2?s1:s2;
        shorter = len1<len2?s1:s2;
        for (int i = 0; i < longer.length(); i++) {
//            if(/) check
            String newString = longer.substring(0,i) + longer.substring(i+1);
            if(newString.equals(shorter)){
                return true;
            }
        }
        return false;

    }
}
