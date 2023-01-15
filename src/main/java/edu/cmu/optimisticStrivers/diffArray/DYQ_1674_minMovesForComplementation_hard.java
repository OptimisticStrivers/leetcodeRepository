package edu.cmu.optimisticStrivers.diffArray;

/**
 * @ClassName: DYQ_1674_minMovesForComplementation_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/7 12:04 PM
 * @Version 1.0
 */
public class DYQ_1674_minMovesForComplementation_hard {

//    https://leetcode.cn/problems/minimum-moves-to-make-array-complementary/solution/chai-fen-sao-miao-by-lucifer1004/
    public static int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            // [2, 2 * limit]
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;
            int x = nums[i];
            int y = nums[j];
            // [min(X,Y) + 1, max(X, Y) + limit]
            diff[Math.min(x, y) + 1]--;
            diff[Math.max(x, y) + limit + 1]++;
            // [X,Y]
            diff[x + y]--;
            diff[x + y + 1]++;
        }

        int ans = n;
        int cnt = 0;
        for (int i = 2; i <= 2 * limit; ++i) {
            cnt += diff[i];
            ans = Math.min(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 2, 1}, 2));
    }
}
