package edu.cmu.optimisticStrivers.twoPointers;

public class    DYQ_11_containerWithMostWater_medium {

//
//面积取决于短板。
//①因此即使长板往内移动时遇到更长的板，矩形的面积也不会改变；遇到更短的板时，面积会变小。
//②因此想要面积变大，只能让短板往内移动(因为移动方向固定了)，当然也有可能让面积变得更小，但只有这样才存在让面积变大的可能性
//所以只动短板 直到相遇即可


    //暴力 双层for循环

    //双指针
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            res = height[left] < height[right] ?
                    Math.max(res, (right - left) * height[left++]) : Math.max(res, (right - left) * height[right--]);
        }
        return res;
    }
}





