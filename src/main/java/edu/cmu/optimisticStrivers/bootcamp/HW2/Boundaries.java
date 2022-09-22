package edu.cmu.optimisticStrivers.bootcamp.HW2;

import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName: Boundaries
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/11 5:26 PM
 * @Version 1.0
 */
public class Boundaries {


    //    public static float runningAverage(int[] values) throws IOException{
    public static float runningAverage(int[] values) {
        if (values == null || values.length == 0) return -1.0f;

        int total = 0;
        int count = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 0) {
                total += values[i];
                count++;
            }
        }
        if(count == 0){
            return 0f;
        }
        float totalF = (float) total;
        return totalF / count;
    }

    // for Code Visualizer
//    public static void main(String[] args) throws IOException {
//        int[] values = {1, 2, 3, -4, -5};
//        System.out.println(runningAverage(values));
//    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _values_size = Integer.parseInt(in.nextLine().trim());
        int[] _values = new int[_values_size];
        for (int _values_i = 0; _values_i < _values_size; _values_i++) {
            int _values_item = Integer.parseInt(in.nextLine().trim());
            _values[_values_i] = _values_item;
        }
        System.err.close();
        float res = Boundaries.runningAverage(_values);
        System.out.println(String.valueOf(res));
    }


}