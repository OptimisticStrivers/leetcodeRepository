package edu.cmu.optimisticStrivers;

public class DYQ_fastPow {


    //有点像二分  二分指数  然后再区分下计数指数和偶数指数
//    https://blog.csdn.net/JixTlhh/article/details/114492326?spm=1001.2101.3001.6650.6&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-6-114492326-blog-97730645.pc_relevant_multi_platform_whitelistv1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-6-114492326-blog-97730645.pc_relevant_multi_platform_whitelistv1&utm_relevant_index=13
//    https://szh-forever-young.blog.csdn.net/article/details/104017671?spm=1001.2101.3001.6650.9&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-9-104017671-blog-107357990.pc_relevant_multi_platform_whitelistv2&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-9-104017671-blog-107357990.pc_relevant_multi_platform_whitelistv2&utm_relevant_index=16
    public static void main(String[] args) {
        DYQ_fastPow dyq_fastPow = new DYQ_fastPow();
        System.out.println(dyq_fastPow.quickPow_recursive(3, 10));
        System.out.println(dyq_fastPow.quickPow_iterate(3, 10));
    }

    public int quickPow_recursive(int a, int n) {
        int res;
        if (n == 0) {
            res = 1;
        } else {
            res = quickPow_recursive(a * a, n / 2);
            if (n % 2 == 1) {
                res *= a;  //抽出一个底
            }
        }
        return res;
    }


    public int quickPow_iterate(int a, int n) {
        int res = 1;
        while (n >= 1) {
            if (n % 2 == 1) { //奇数
                res *= a;  //抽出一个底数 使得当前的指数为偶数 可以继续除2
            }
            a *= a;
            n = n / 2;
        }
        return res;
    }
}
