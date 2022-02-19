package edu.cmu.optimisticStrivers.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DYQ_22_GenerateParentheses_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/1/24 12:55 下午
 * @Version 1.0
 */
public class DYQ_22_GenerateParentheses_medium {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("",n,n,n,res);
        return res;
    }

    public void dfs(String cur, int left, int right, int n, List<String> res){
        if(left == 0 && right == 0 ){
            res.add(cur);
            return;
        }
        if(left>0){
            dfs(cur+"(",left-1,right,n,res);
        }
        //right不需要判断大于0，因为肯定是right先到0。
        if(right>left) { //右括号剩下的更多的话，此时才可以添右括号
            dfs(cur + ")", left, right - 1, n, res);
        }
    }
}
