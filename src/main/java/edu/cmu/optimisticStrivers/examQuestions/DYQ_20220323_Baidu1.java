package edu.cmu.optimisticStrivers.examQuestions;

import java.util.List;

/**
 * @ClassName: DYQ_20220323_Baidu1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/23 11:19 上午
 * @Version 1.0
 */
public class DYQ_20220323_Baidu1 {


    //给一个字符串，全是01，然后你要返回的是四个位置，两两组成的区间大小相同，且01数量相同


    public static void test(String a){

        char[] chars = a.toCharArray();
        int len = a.length()-1;

        int i = 0;
        int j = 0;
        int p = len-1;
        int q = len-1;

        for (int k = 0; k < len; k++) {
            if(chars[k] == '0') {
                i = k;
                break;
            }
        }
        for (int k = 0; k < len; k++) {
            if(chars[k]=='1'){
                j = k;
                break;
            }
        }

        for (int k = len-1; k >= 0 ; k--) {
            if(chars[k] =='0'){
                p = k;
                break;
            }
        }

        for (int k = len-1; k >= 0 ; k++) {
            if(chars[k] =='1'){
                q = k;
                break;
            }
        }

        if(p-i>=q-j) { //0的范围大
            System.out.printf("%d %d %d %d \n",i+1, p, i+2, p+1 );
        }else{
            System.out.printf("%d %d %d %d \n",j+1, q, j+2, q+1);

        }
    }

    public static void main(String[] args) {
        String target = "0010011";
        test(target);
    }


}
