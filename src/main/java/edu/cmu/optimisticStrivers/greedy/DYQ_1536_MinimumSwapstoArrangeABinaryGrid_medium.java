package edu.cmu.optimisticStrivers.greedy;

/**
 * @ClassName: DYQ_1536_MinimumSwapstoArrangeABinaryGrid_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/9 5:38 PM
 * @Version 1.0
 */
public class DYQ_1536_MinimumSwapstoArrangeABinaryGrid_medium {

//    https://leetcode.cn/problems/minimum-swaps-to-arrange-a-binary-grid/solution/pai-bu-er-jin-zhi-wang-ge-de-zui-shao-jiao-huan-ci/

//    public int minSwaps(int[][] grid) {
//        int len = grid.length;
//        int[] behindZerosCount = new int[len];
//        for (int i = 0; i < grid.length; i++) {
//            behindZerosCount[i] = getBehindContinuousZero(grid, i);
//        }
//        int res = 0;
//        for (int i = 0; i < grid.length; i++) {
//            if (behindZerosCount[i] >= len - 1 - i) {
//                continue; //这一行就可以了
//            }
//            boolean canSwap = false;
//            int j = i + 1;
//            for (; j < len; j++) {
//                if (behindZerosCount[j] >= len - 1 - i) {
//                    canSwap = true;
//                    break;
//                }
//            }
//            if (!canSwap) {
//                return -1;
//            }
//
//            for (int k = j; k > i; k--) {
//                swap(behindZerosCount, k, k - 1); //这里下面都要swap下
//            }
//            System.out.println("** " + (j - i));
//            res += j - i;
//        }
//        return res;
//    }
//
//    public void swap(int[] behindZerosCount, int i, int j) {
//        int temp = behindZerosCount[i];
//        behindZerosCount[i] = behindZerosCount[j];
//        behindZerosCount[j] = temp;
//    }
//
//    public int getBehindContinuousZero(int[][] grid, int i) {
//        int count = 0;
//        for (int j = grid.length - 1; j > 0; j--) {
//            if (grid[i][j] != 0) {
//                break;
//            }
//            count++;
//        }
//        System.out.println(count);
//        return count;
//
//    }


    public int minSwaps(int[][] grid) {
        int[] zerosOnTheRightSide = new int[grid.length];
        findZeros(zerosOnTheRightSide, grid);
        int len = grid.length;
        int res = 0;
//        System.out.println(zerosOnTheRightSide[2]);
        for (int i = 0; i < grid.length; i++) {
            if (zerosOnTheRightSide[i] >= len - 1 - i) {
                continue;
            }
            boolean canMakeIt = false;
            for (int j = i + 1; j < len; j++) {
                System.out.println();
                if (zerosOnTheRightSide[j] >= len - 1 - i) {
                    for (int k = j; k > i; k--) {
                        swap(zerosOnTheRightSide, k, k-1);
                    }
                    res += j - i;
                    canMakeIt = true;
                    break;
                }
            }
            if (!canMakeIt) {
                return -1;
            }
        }
        return res;
    }

    private void swap(int[] zerosOnTheRightSide, int i, int j) {
        int temp = zerosOnTheRightSide[i];
        zerosOnTheRightSide[i] = zerosOnTheRightSide[j];
        zerosOnTheRightSide[j] = temp;
    }


    public void findZeros(int[] ints, int[][] grid) {
        for (int i = 0; i < ints.length; i++) {
            int count = 0;
            for (int j = ints.length - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }
                count++;
            }
            ints[i] = count;
//            System.out.println(count);
        }
    }


    public static void main(String[] args) {
        DYQ_1536_MinimumSwapstoArrangeABinaryGrid_medium dyq_1536_minimumSwapstoArrangeABinaryGrid_medium = new DYQ_1536_MinimumSwapstoArrangeABinaryGrid_medium();
        System.out.println(dyq_1536_minimumSwapstoArrangeABinaryGrid_medium.minSwaps(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}));
    }

}
