package edu.cmu.optimisticStrivers.hash.inPlaceHash;

/**
 * @ClassName: DYQ_jianzhi03_findRepeatNumber_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/30 5:06 AM
 * @Version 1.0
 */
public class DYQ_jianzhi03_findRepeatNumber_easy {

    //1 先排序 肯定可以做 O(nlogn)
    //2 直接hash表 也可以做 但是空间复杂度 不是 in-place

    //3 利用和 41 相同的原地hash  in-place hash的方法 一个一个放 最后无家可归的就是重复的
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
//            if (nums[nums[i]] == nums[i]) return nums[i]; 这行可有可无

            while (nums[i] != i && nums[i] != nums[nums[i]]) { //防止死循环
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        // hash 完成以后 没有对号入座的 肯定是重复的
        // 因为一共也就 一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return nums[i];
            }
        }
        return -1; //这一行是到不了的 因为一定有重复的
    }

    public static void main(String[] args) {
        DYQ_jianzhi03_findRepeatNumber_easy dyq_jianzhi03_findRepeatNumber_easy = new DYQ_jianzhi03_findRepeatNumber_easy();
        System.out.println(dyq_jianzhi03_findRepeatNumber_easy.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        ;
    }

    public int findRepeatNumber1(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == i) { //只有当前i归位 i才++  这种写法更晦涩一点
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];

            //当前i index不是 应该坐的同学 坐 那就不断换到别的地方去
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

}
