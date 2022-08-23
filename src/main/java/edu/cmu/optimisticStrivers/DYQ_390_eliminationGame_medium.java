package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_390_eliminationGame_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/7 3:58 PM
 * @Version 1.0
 */
public class DYQ_390_eliminationGame_medium {


//    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//    arr = [2, 4, 6, 8]
//    arr = [2, 6]
//    arr = [6]
//
//    无论从左到右， 还是从右到左，每次都要消除 一半的数
//    但是，从左到右，每次都要消除第一个
//    而从右到左，只要数组为奇数个，才会消除第一个。


    public int lastRemaining(int n) {

        //n 奇数/偶数 remove 开根号 n 趟

        int remain = n; //还剩n个数字
        boolean left2Right = true;
        int res = 1; //剩余元素的首部
        int step = 1; //跨越的步数
        while (remain > 1) {
            if (left2Right || remain % 2 == 1) { //从左到右 或者 剩余个数是奇数
                res += step;
            }
            left2Right = !left2Right;
            step *= 2; //step每轮都要*2的 因为每轮少掉一半元素
            remain /= 2;
        }
        return res;
    }

}
