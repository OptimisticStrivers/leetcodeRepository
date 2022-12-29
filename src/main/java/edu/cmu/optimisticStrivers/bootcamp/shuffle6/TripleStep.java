package edu.cmu.optimisticStrivers.bootcamp.shuffle6;

/**
 * @ClassName: TripleStep
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/26 4:50 PM
 * @Version 1.0
 */
public class TripleStep {


    public static int climb(int target){
        if(target == 1) return 1;
        if(target == 2) return 2;
        if(target == 3) return 4;
        int pre1 = 1;
        int pre2 = 2;
        int pre3 = 4;
        for (int i = 4; i <= target; i++) {
            int temp = pre1 + pre2 + pre3;
            pre1 = pre2;
            pre2 = pre3;
            pre3 = temp;
        }
        return pre3;
    }

    public static void main(String[] args) {
        System.out.println(climb(4));
    }



}
