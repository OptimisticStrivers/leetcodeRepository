package edu.cmu.optimisticStrivers.math;

/**
 * @ClassName: DYQ_258_AddDigits_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/27 12:42 AM
 * @Version 1.0
 */
public class DYQ_258_AddDigits_easy {


//    在数学中，数根(又称位数根或数字根Digital root)是自然数的一种性质，换句话说，每个自然数都有一个数根。
//
//    数根是将一正整数的各个位数相加（即横向相加），若加完后的值大于10的话，则继续将各位数进行横向相加直到其值小于十为止[1]，
//    或是，将一数字重复做数字和，直到其值小于十为止，则所得的值为该数的数根。
//
//    例如54817的数根为7，因为5+4+8+1+7=25，25大于10则再加一次，2+5=7，7小于十，则7为54817的数根。


    //递归
    public int addDigits(int num) {
        if (num < 10) return num;
        //加起来
        int cur = 0;
        while (num != 0) {
            cur += num % 10;
            num /= 10;
        }
        return addDigits(cur);
    }


    //迭代
    public int addDigits1(int num) {
        int next = num;
        while (num >= 10) {
            next = 0;
            while (num != 0) {
                next += num % 10;
                num /= 10;
            }
            num = next;
        }
        return next;
    }


    //数根推导
    public int addDigits2(int num) {
        if (num <= 9) return num;
        if (num % 9 == 0) return 9;
        return num % 9;
    }


}
