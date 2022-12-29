package edu.cmu.optimisticStrivers.bootcamp.shuffle7;

/**
 * @ClassName: NextBiggestNumber
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/11/2 7:40 PM
 * @Version 1.0
 */
public class NextBiggestNumber {


//    大数 先0->1 先放大再shrink
//    小数 先1->0 先缩小再expand
//
//
//
//            放大
//0000100100 flip 0 -> 1   0000101100
//    flip the first（从右向左数） non-trailing 0 to 1   （即保证右边有1可以变0 且 变大但不要变太多）
//            0000101100  -> 0000101001 -> 00001011000
//    flipped 1 右边的 1全部右移到不能再右移 然后翻转最右边的1为0
//
//    缩小
//00011001101 flip 1 -> 0  00011001001
//    flip the first（从右向左数） non-trailing 1 to 0  (即保证右边有0可以变1 且 变小但不要小太多）
//            00011001001 -> 00011001010 -> 00011001011
//    flipped 0 右边的 1全部左移到不能再左移 然后翻转最左边的0为1
//
//00011001100 flip 1 -> 0  00011001000
//            00011001000 -> 00011001000 -> 00011001010
}
