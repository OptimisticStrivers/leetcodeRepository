package edu.cmu.optimisticStrivers;

import java.util.Arrays;

/**
 * @ClassName: DYQ_lintcode_1219_heaters_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/4 3:59 PM
 * @Version 1.0
 */
public class DYQ_lintcode_1219_heaters_medium {


    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters); //先排序heaters 小->大
        int res = Integer.MIN_VALUE;
        for (int house : houses) {
//            index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1)
            int index = Arrays.binarySearch(heaters, house);
            if (index >= 0) { //能找到
                res = Math.max(0, res);
                System.out.println("找到 " + res);
            } else {
                //如果所有heater都比当前house大 返回的是 heater.length
                if (index == -1 * heaters.length - 1) {
                    res = Math.max(house - heaters[heaters.length - 1], res);
                } else {
                    //第一个比当前house大的heater
                    //但是我们要看 这个 heater 和 前面那个heater 到底谁 离当前house近
                    int heater1 = -1 * (index + 1);
                    int heater0 = -1 * (index + 1) - 1;
                    int nearestHeater = heaters[heater1];
                    if (heater0 != -1) { //如果当前house 前面 也有一个heater的话
                        res = Math.max(res, Math.min(heaters[heater1] - house, house - heaters[heater0]));
                    }else{
                        res = Math.max(res, nearestHeater - house);

                    }
                }
            }
        }
//        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        DYQ_lintcode_1219_heaters_medium dyq_lintcode_1219_heaters_medium = new DYQ_lintcode_1219_heaters_medium();
        dyq_lintcode_1219_heaters_medium.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
    }




    //简洁版
    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int leftdist = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int rightdist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(leftdist, rightdist));
        }

        return result;
    }
}
