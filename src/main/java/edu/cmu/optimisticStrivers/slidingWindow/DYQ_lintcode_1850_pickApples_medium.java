package edu.cmu.optimisticStrivers.slidingWindow;

/**
 * @ClassName: DYQ_lintcode_1850_pickApples_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/4 10:00 AM
 * @Version 1.0
 */
public class DYQ_lintcode_1850_pickApples_medium {


    //这种 先找 长 ， 再找短的 方法 会有问题
    // 比如 61463274
    // 长 463 短 74
    // 我们找到的是 长 274 短 46
    public int pickApples1(int[] a, int k, int l) {
        int length = a.length;
        if (k + l > length) return -1;
        int longer = Math.max(k, l);
        int shorter = Math.min(k, l);
        int applesFromLonger = 0;
        int leftOfLonger = -1;
        int rightOfLonger = -1;
        int maxApplesForLonger = 0;
        //先滑动窗口 找 长的
        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < length; rightPointer++) {
            applesFromLonger += a[rightPointer];
            if (rightPointer - leftPointer + 1 == longer) {
                maxApplesForLonger = Math.max(applesFromLonger, maxApplesForLonger);
                leftOfLonger = leftPointer;
                rightOfLonger = rightPointer;
                applesFromLonger -= a[leftPointer];
                leftPointer++;
            }
        }
        System.out.println("长 " + maxApplesForLonger);
        int applesFromShorter = 0;
        int leftOfShorter = -1;
        int rightOfShorter = -1;
        int maxApplesForShorter = 0;
        leftPointer = 0;
        for (int rightPointer = 0; rightPointer < length; rightPointer++) {
            if (rightPointer >= leftOfLonger && rightPointer <= rightOfLonger) {
                leftPointer = rightOfLonger + 1;
                rightPointer = rightOfLonger + 1;
                applesFromShorter = 0;
            }
            if (rightPointer == length) continue;
            applesFromShorter += a[rightPointer];
            if (rightPointer - leftPointer + 1 == shorter) {
                maxApplesForShorter = Math.max(applesFromShorter, maxApplesForShorter);
                leftOfShorter = leftPointer;
                rightOfShorter = rightPointer;
                applesFromShorter -= a[leftPointer];
                leftPointer++;
            }
        }
        System.out.println("短 " + maxApplesForShorter);

        return maxApplesForLonger + maxApplesForShorter;

    }


    //正确方法， n次隔板 + 滑动窗口
    //这个注释掉 完全是因为 不想给自己找麻烦，边界不用那么麻烦的
//    public int pickApples(int[] a, int k, int l) {
//
//        //默认规定k为短的 l为长的
//        //用于分隔板 但是其实就穷举n个隔板倒是也行
//        if(k>l) return pickApples(a,l,k);
//        int max = Integer.MAX_VALUE;
//        int length = a.length;
//
//
//        //隔板左边为 [0,i) 右边为 [i,n)
//        for (int i = k; i < length - k; i++) {
//            //从k开始即可 即一开始左边就能分出来一个短的
//            //如果从l开始隔板  那么左边就会 漏掉 一个 短的
//
//        }
//
//
//
//    }


    //正确方法， n次隔板 + 滑动窗口
    public int pickApples(int[] a, int k, int l) {
        int max = Integer.MIN_VALUE;
        int length = a.length;
        //隔板左边为 [0,i) 右边为 [i,n)
        for (int i = 0; i < length; i++) {
            //当前隔板 左边 先 找k   右边找l
            int maxLeft = getApples(0, i - 1, k, a);
            int maxRight = getApples(i, length - 1, l, a);
            if (maxLeft != -1 && maxRight != -1) { //同时找到才可以
                max = Math.max(max, maxLeft + maxRight);
            }
            //当前隔板 左边 先 找l   右边找k
            maxLeft = getApples(0, i - 1, l, a);
            maxRight = getApples(i, length - 1, k, a);
            if (maxLeft != -1 && maxRight != -1) { //同时找到才可以
                max = Math.max(max, maxLeft + maxRight);
            }
        }
        if(max == Integer.MIN_VALUE) return -1;
        return max;
    }

    //left 和 right 都是包含
    public int getApples(int left, int right, int len, int[] a) {
        if (right - left + 1 < len) return -1;
        int max = 0;
        int sum = 0;
        for (int i = left; i < left + len; i++) {
            sum += a[i];
            max += a[i];
        }
//        System.out.println("sum " + sum + " max " + max);
        //滑动窗口 找 最大
        int leftPointer = left;
        for (int rightPointer = left + len; rightPointer <= right; rightPointer++) {
            int cur = sum + a[rightPointer] - a[leftPointer];
//            System.out.println("cur " + cur);
            sum = sum + a[rightPointer] - a[leftPointer];
            max = Math.max(sum, max);

            leftPointer++;
        }
        return max;
    }


    public static void main(String[] args) {
        DYQ_lintcode_1850_pickApples_medium dyq_lintcode_1850_pickApples_medium = new DYQ_lintcode_1850_pickApples_medium();
//        dyq_lintcode_1850_pickApples_medium.pickApples(new int[]{6, 1, 4, 6, 3, 2, 7, 4}, 3, 2);

//        System.out.println(dyq_lintcode_1850_pickApples_medium.getApples(0, 7, 3, new int[]{6, 1, 4, 6, 3, 2, 7, 4}));
        System.out.println(dyq_lintcode_1850_pickApples_medium.getApples(0, 7, 2, new int[]{6, 1, 4, 6, 3, 2, 7, 4}));

//        System.out.println(dyq_lintcode_1850_pickApples_medium.pickApples(new int[]{6, 1, 4, 6, 3, 2, 7, 4}, 3, 2));
    }
}
