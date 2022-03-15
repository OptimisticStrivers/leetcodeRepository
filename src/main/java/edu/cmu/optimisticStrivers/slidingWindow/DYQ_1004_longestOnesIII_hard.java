package edu.cmu.optimisticStrivers.slidingWindow;

/**
 * @ClassName: DYQ_magicOf01_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/14 7:32 下午
 * @Version 1.0
 */
public class DYQ_1004_longestOnesIII_hard {

//    1004. 最大连续1的个数 III

    //dp做法，遍历每种长度的子串，记录他们的含0数（状态转移），然后又符合的就Max比一下
    //你会发现，此处用dp相当于还是3层for，枚举了，效率太低
    static int[][] dp;
    public static void f() {
        int[] nums = {1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1};
        int n = 10, k = 2;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i] == 0 ? 1 : 0;
        }
        int maxDiff = 0;
        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i + diff < n; i++) {
                int j = i + diff;
                dp[i][j] = dp[i][j-1] + dp[j][j];
//                dp[i][j] = dp[i][i] + dp[i+1][j]; 都可以

                if (dp[i][j] <= k) {
                    maxDiff = diff + 1;
                }
            }
        }
        System.out.println(maxDiff);
    }



    //滑动窗口
    public int longestOnes(int[] A, int K) {
        int left = 0;//窗口左边的位置
        int maxWindow = 0;//窗口的最大值
        int zeroCount = 0;//窗口中0的个数
        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                zeroCount++;
            }
            //如果窗口中0的个数超过了K，要缩小窗口的大小，直到0的个数
            //不大于K位置
            while (zeroCount > K) {
                if (A[left] == 0)
                    zeroCount--;
                left++;
            }
            //记录最大的窗口
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return maxWindow;
    }


    //简化版 滑动窗口
    public int longestOnes2(int[] A, int K) {
        int left = 0;//窗口左边的位置
        int maxWindow = 0;//窗口的最大值
        int zeroCount = 0;//窗口中0的个数
        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                zeroCount++;
            }
            //1 1 1 0 1 k = 0
            //1 1 1 0 1 0 k =1
            if (zeroCount > K) { //平移
                if (A[left++] == 0)
                    zeroCount--;
            }
            //记录最大的窗口
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return maxWindow;
    }
    public int longestOnes3(int[] nums, int k) {
        int left = 0;//窗口左边的位置
        int zeroCount = 0;//窗口中0的个数
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            //1 1 1 0 1 k = 0
            //1 1 1 0 1 0 k =1
            if (zeroCount > k) { //平移
                if (nums[left++] == 0)
                    zeroCount--;
            }
        }
        return nums.length-left;
    }

    //滑动窗口，超级简化版
    public int longestOnes1(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int zeros = 0; //当前0的数量
        for(int i = 0; i<len; i++){
            zeros += 1-nums[i];
            if(zeros > k){
                zeros -= 1-nums[left]; //zeros可能并没有减少
                left++;
            }
        }
        return right-left+1;
    }


//    public static void main(String[] args) {
//        f();
//    }

}
