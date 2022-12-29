package edu.cmu.optimisticStrivers.math.moleElection;

/**
 * @ClassName: DYQ_majorityElement_169_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/11/29 7:02 PM
 * @Version 1.0
 */
public class DYQ_majorityElement_169_easy {

//    保证一定有一个满足 出现频率大于 n/2 的
//    那么就o(N) 走一遍 就好了
    public int majorityElement1(int[] nums) {
        int win = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == win) {
                count++;
            } else if (count == 0) {
                win = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        return win;
    }


//    如果要求如果没有 majority element 那么就是 返回-1
//    如果要时间o(N) 和 空间o(1)
    public static int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        //第一轮 我们可以知道 candidate 是谁
        //比如 1 2 3, 3是candidate 但是 并不是majority
        int win = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == win) {
                count++;
            } else if (count == 0) {
                win = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        //第二轮 我们检查 这个 candidate 出现次数是不是超过n/2
        count = 0;
        for (int num : nums) {
            if(num == win) {
                count++;
            }
        }
        return count>(nums.length/2) ? win : -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3};
        System.out.println(majorityElement(ints));

    }

}
