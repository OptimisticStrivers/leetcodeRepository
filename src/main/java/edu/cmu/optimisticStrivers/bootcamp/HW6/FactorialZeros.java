package edu.cmu.optimisticStrivers.bootcamp.HW6;

/**
 * @ClassName: FactorialZeros
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/26 7:32 PM
 * @Version 1.0
 */
public class FactorialZeros {


//    Factorial Zeros: Write an algorithm which computes the number of trailing zeros in n factorial.
//19! = 1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17*18*19
//    Therefore, to count the number of zeros, we only need to count the pairs of multiples of 5 and 2. There will always be more multiples of 2 than 5, though, so simply counting the number of multiples of 5 is sufficient.
//    One "gotcha" here is 15 contributes a multiple of 5 (and therefore one trailing zero), while 25 contributes two(because25 = 5*5).

//    brainteaser


//    只有2和5相乘才会出现0，其中整十也可以看做是2和5相乘的结果，所以，可以在n之前看看有多少个2以及多少个5就行了，
//    又发现2的数量一定多于5的个数，于是我们只看n前面有多少个5就行了，于是n/5就得到了5的个数，还有一点要注意的就是25这种，
//            5和5相乘的结果，所以，还要看n/5里面有多少个5，也就相当于看n里面有多少个25，还有125，625.。。


    int trailingZeroes(int n) {
        int res = 0;
        while(n!=0){
            res += n/5;
            n /= 5;
        }
        return res;
    }

}


