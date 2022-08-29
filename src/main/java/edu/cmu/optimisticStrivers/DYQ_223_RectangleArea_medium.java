package edu.cmu.optimisticStrivers;

/**
 * @ClassName: DYQ_223_RectangleArea_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/24 2:31 AM
 * @Version 1.0
 */
public class DYQ_223_RectangleArea_medium {


    //容斥原理
//    求交集矩形面积，可以转换为求两矩形在坐标轴上的重合长度，
//    若两矩形在 XX 轴上的重合长度为 xx，在 YY 轴上的重合长度为 yy，
//    则有重合面积为 C = x * yC=x∗y。同时考虑两矩形在任一坐标轴上没有重合长度，
//    则不存在重合面积，因此需要将重合长度与 00 取 \maxmax。
//    最终答案为 A + B - C


    //4个坐标 找出两个矩形覆盖的面积
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));   //右上角最小的x - 左下角最大的x
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1) - x * y;
    }
}
