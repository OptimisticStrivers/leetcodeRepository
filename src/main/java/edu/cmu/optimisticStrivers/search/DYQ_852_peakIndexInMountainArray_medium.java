package edu.cmu.optimisticStrivers.search;

/**
 * @ClassName: DYQ_852_peakIndexInMountainArray_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/27 8:40 PM
 * @Version 1.0
 */
public class DYQ_852_peakIndexInMountainArray_medium {
    //一定有山峰 一定至少3个元素

    //和33一样

    //不好理解
//    public static int peakIndexInMountainArray(int[] arr) {
//        int l = 0;
//        int r = arr.length - 1;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            System.out.println(mid + " : " + arr[mid]);
//            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
//                return mid;
//            }
//            if (arr[mid] > arr[mid - 1]) { //右边比左边高 说明山峰在右边
//                l = mid; //虽然山峰一定不是mid了
//            } else {
//                r = mid;
//            }
//        }
//        return -1;
//    }
//

    //一定有山峰 所以不会越界
    public static int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
//        System.out.println(peakIndexInMountainArray(new int[]{98, 100, 99, 98, 90}));
//        必须有等号 否则在98和100的时候 就会丢掉 100
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.println(mid + " : " + arr[mid]);
//            if (arr[mid-1] < arr[mid]) 这个不能决定一定是上坡 有可能mid是山峰
//            但是
//            下面那个arr[mid] < arr[mid + 1]一定能决定mid不是山峰
            if (arr[mid] < arr[mid + 1]) { // 现在是上坡，封顶应在mid右侧找
                l = mid + 1;
            } else if (arr[mid - 1] > arr[mid]) { // 现在是下坡，封顶应在mid左侧找
                r = mid - 1;
            } else {
                return mid; // 满足题意，找到了封顶
            }
        }
        return -1;
    }


    //需要控制的条件太多
//    public static int peakIndexInMountainArray(int[] arr) {
//        int l = 0;
//        int r = arr.length - 1;
//        while (l <= r) { //必须有等于号 可能定位到一个中间元素 然后找左右
//            int mid = l + (r - l) / 2;
//            System.out.println(mid + " : " + arr[mid]);
//            if (mid - 1 >= 0 && mid + 1 < arr.length && arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
//                return mid;
//            }
//            if (mid - 1 < 0 || arr[mid] > arr[mid - 1]) { //右边比左边高 说明山峰在右边
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{98, 100, 99}));

//        System.out.println(peakIndexInMountainArray(new int[]{98, 100, 99, 98, 90}));

//        System.out.println(peakIndexInMountainArray(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90}));
//        System.out.println(peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0}));


    }
}
