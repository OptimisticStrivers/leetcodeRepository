package edu.cmu.optimisticStrivers;

import java.util.Stack;

/**
 * @ClassName: DYQ_402_removeKDigits_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/23 11:25 下午
 * @Version 1.0
 */
public class DYQ_402_removeKDigits_medium {

//    这道题和1673是完全类似的，移除k个元素 == 挑选 n-k个元素！！！！！！！记住这种思想！标记一下

    //单调栈
    public static  String removeKdigits(String num, int k) {
        int len = num.length();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = num.charAt(i) - '0';
        }
        int curDelete = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]); //一定不止一个数
        for(int i = 1; i < len; i++){
            while(!stack.isEmpty() && stack.peek()>nums[i] && curDelete < k){
                stack.pop();
                curDelete++;
            }
            stack.push(nums[i]); //每个元素都会进栈，但是一旦次数用完，就不保证后面的进站是有序了
        }
        //最后，如果还有次数，再把栈里的这么多次数弹走，还是弹大的
        for(int i = curDelete; i < k; i++){
            stack.pop();
        }
        //不能这样，会越界。还是要字符串拼接，虽然不需要消除前缀的0，不合法的数字嘛，如果02000，其实是2000
//        Integer res = 0;
//        int base = 1;
//        while(!stack.isEmpty()){
//            int pop = stack.pop();
//            res += pop*base;
//            base *= 10;
//        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();


        //最后如果字符串开头是0，需要清除开头的0(可能是全零，所以记得留一个别删完了)
        while( stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            //    stringBuilder.delete(0, 1); //删除开头的0，前开后闭z
            stringBuilder.deleteCharAt(0);
        }
        //可能是""，返回必须是"0"2
        return stringBuilder.toString().equals("")?"0":stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
    }
}
