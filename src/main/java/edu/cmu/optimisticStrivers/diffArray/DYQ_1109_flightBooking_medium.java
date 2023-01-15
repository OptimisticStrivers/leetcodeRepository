package edu.cmu.optimisticStrivers.diffArray;

/**
 * @ClassName: DYQ_1109_flightBooking_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2023/1/7 11:16 AM
 * @Version 1.0
 */
public class DYQ_1109_flightBooking_medium {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];
        for(int[] a : bookings){
            diff[a[0]-1] += a[2];
            diff[a[1]] -= a[2];
        }
        int[] res = new int[n];
        int sum = 0;
        for(int i =0; i<n; i++){
            sum+=diff[i];
            res[i] = sum;
        }
        return res;
    }
}
