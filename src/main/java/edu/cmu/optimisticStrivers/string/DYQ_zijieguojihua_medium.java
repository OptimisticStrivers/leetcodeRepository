package edu.cmu.optimisticStrivers.string;

/**
 * @ClassName: DYQ_zijieguojihua_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/31 5:21 下午
 * @Version 1.0
 */
public class DYQ_zijieguojihua_medium {

    // 解码字符串 3[a2[ab]] ->  aababaababaabab

    public static void main(String[] args) {
        String test = "2[abc]3[cd]ef";
        System.out.println(recur(test));
    }

    static int nextIndex = 0;

    public static String recur(String target) {
        String pre = "";
        int len = target.length();
        for (int i = 0; i < len; i++) {
            char curChar = target.charAt(i);
            if ('a' <= curChar && curChar <= 'z') { //有问题
                pre += curChar;
            } else if (curChar == ']') {
                System.out.println("index " + i);
                nextIndex = i + 1;
                break;
            } else { //数字
//                int curNum = Integer.parseInt(String.valueOf(curChar));
                int curNum = Integer.parseInt(String.valueOf(curChar));
                String res = recur(target.substring(i + 2, target.length()));
                for (int j = 0; j < curNum; j++) {
                    pre += res;
                }
                // pre += res;
                i = i + 1 + nextIndex;
            }
        }
        return pre;
    }


//// 64 马
//// 8 个位置
//
//        // 前四名
//// 9
//        a1 b1 c1 d1
//        a2 b2 c2
//        a3 b3
//        a4
//
//        a2 a3 a4 b2 b3 c1 c2 d1 +1
//        b2 c1 任意一个出现前2  10
//        b2 c1 都不出现在前2  b3 c2  --》a2 a3 a4 b1 c1
//


}

