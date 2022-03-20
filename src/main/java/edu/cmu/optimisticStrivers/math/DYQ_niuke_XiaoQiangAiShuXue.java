package edu.cmu.optimisticStrivers.math;

/**
 * @ClassName: DYQ_niuke_XiaoQiangAiShuXue
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/20 9:35 上午
 * @Version 1.0
 */

import java.util.*;

public class DYQ_niuke_XiaoQiangAiShuXue {


//    https://www.nowcoder.com/questionTerminal/3b6dc1447d6d4ac4b9c2d45f1d4637ea

//    小强爱数学
        public static void main(String[] args){
            long mod =  1000000007;
            Scanner scanner  = new Scanner(System.in);
            int lines =  scanner.nextInt();
            scanner.nextLine();
            int maxExpo = 0;
            for(int i = 0; i<lines; i++){
                String[] line = scanner.nextLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                int n = Integer.parseInt(line[2]);

                long prepre = 2;
                long pre = a;
                long cur = 0;
                if(n == 1){
                    System.out.println(pre);
                    continue;
                }
                for(int j = 2; j<= n; j++){
                    cur = (a*pre %mod-b*prepre %mod)%mod;;
                    //cur = a*pre %mod-b*prepre %mod +mod;
                    //     cur = (a*pre %mod-b*prepre % mod + mod)%mod;
                    prepre = pre;
                    pre = cur;
                }
                System.out.println(cur);

        }
    }



}





