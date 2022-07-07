package edu.cmu.optimisticStrivers.twoPointers;

public class DYQ_75_SortColors_medium {
//这个题 也叫做 荷兰国旗问题  三色旗问题
//    https://blog.csdn.net/weixin_43614026/article/details/104444811

//可以先做一个题   给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。要求额外空间复杂度O(1),时间复杂度 O(N)

// 类似于快排 找基准

//    Follow up: Could you come up with a one-pass algorithm using only constant extra space?


    //双指针记录大于区和小于区   再来一个i去遍历一次nums
    //注意 因为是从左到右，所以小于区需要交换且index++，但是大于区交换但是index不变
    public void sortColors(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        int index = 0; //遍历用的
        while (index < r) { //index和大于边界重合的时候，为结束
            while (nums[index] < target) {
                int swap = nums[l + 1]; //l+1 才是边界
                nums[l + 1] = nums[index];
                nums[index] = swap;
                index++;
                l++;
                System.out.print("<");
                pint(nums);

            }
            while (nums[index] > target) {  //这里有问题，收拢不住外面的大 while 的 (index < r) 条件
                int swap = nums[r - 1]; //r-1 才是边界
                nums[r - 1] = nums[index];
                nums[index] = swap;
                r--;
                System.out.print(">");
                pint(nums);
            }
            while (nums[index] == target) {
                index++;
                System.out.print("=");
                pint(nums);
            }
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void sortColors1(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        int index = 0; //遍历用的
        while (index < r) { //index和大于边界重合的时候，为结束
            if (nums[index] < target) {
                l++;//l+1 才是边界
                int swap = nums[l];
                nums[l] = nums[index];
                nums[index] = swap;
                index++;
                pint(nums);
            }// 靠，必须写多重if else ， 不能单写if的，因为这里 index 和 r会在别的if里面改掉，那么判断逻辑就收拢不到while了
            if (nums[index] > target) {
                r--; //r-1 才是边界
                int swap = nums[r];
                nums[r] = nums[index];
                nums[index] = swap;
                pint(nums);
            }
            if (nums[index] == target) {
                index++;
                pint(nums);
            }
            System.out.print(" index " + index + " r " + r);
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void sortColors_final(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        int index = 0; //遍历用的
        while (index < r) { //index和大于边界重合的时候，为结束
            if (nums[index] < target) {
                l++;//l+1 才是边界
                int swap = nums[l];
                nums[l] = nums[index];
                nums[index] = swap;
                index++;
                pint(nums);
            } else if (nums[index] > target) {
                r--; //r-1 才是边界
                int swap = nums[r];
                nums[r] = nums[index];
                nums[index] = swap;
                pint(nums);
            } else {
                index++;
                pint(nums);
            }
            System.out.print(" index " + index + " r " + r);
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }


    public void sortColors2(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        int index = 0; //遍历用的
        while (index < r) { //index和大于边界重合的时候，为结束
            while (nums[index] < target && index < r) {
                int swap = nums[l + 1]; //l+1 才是边界
                nums[l + 1] = nums[index];
                nums[index] = swap;
                index++;
                l++;
                System.out.print("<");
                pint(nums);

            }
            while (nums[index] > target && index < r) {  //这里有问题，收拢不住外面的大 while 的 (index < r) 条件
                int swap = nums[r - 1]; //r-1 才是边界
                nums[r - 1] = nums[index];
                nums[index] = swap;
                r--;
                System.out.print(">");
                pint(nums);
            }
            while (nums[index] == target && index < r) {
                index++;
                System.out.print("=");
                pint(nums);
            }
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void pint(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DYQ_75_SortColors_medium dyq_75_sortColors_medium = new DYQ_75_SortColors_medium();
//        int[] a = {2, 4, 3, 7, 1, 4, 6, 4};
//        dyq_75_sortColors_medium.sortColors(a, 4);
//        System.out.println();
//        dyq_75_sortColors_medium.sortColors1(a, 4);
//            dyq_75_sortColors_medium.sortColors2(a,4);

//        int[] b = {2, 0, 1};
//        dyq_75_sortColors_medium.sortColors1(b, 1);


        int[] nums1 = {1,0,2,0,1,2,1,1};
        dyq_75_sortColors_medium.sortColor_touji(nums1);
        dyq_75_sortColors_medium.pint(nums1);
    }



    //一种偷鸡的做法，就是要遍历两次

    public void sortColor_touji(int[] nums){
//        int[] nums1 = {1,0,2,0,1,2,1,1};
        partitionArray(nums,1);
        partitionArray(nums,2);
    }

    public void partitionArray(int[] nums, int partitionNum){
        int smallerElementPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<partitionNum){
                int swap = nums[i];
                nums[i] = nums[++smallerElementPos] ;
                nums[smallerElementPos] = swap;
            }
        }
    }

}
