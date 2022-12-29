package edu.cmu.optimisticStrivers.OA.optiver;

/**
 * @ClassName: Q1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/29 7:00 PM
 * @Version 1.0
 */
public class Q1 {


    public int daysBetween(int yearFrom, int monthFrom, int dayFrom, int yearTo, int monthTo, int dayTo) {
        int resultDays = 0;
        if(yearFrom == yearTo){
            for (int curMonth = monthFrom; curMonth <= monthTo; curMonth++) {
                resultDays += DaysInMonth(yearFrom, curMonth);
            }
            resultDays -= dayFrom;
            resultDays -= DaysInMonth(yearTo, monthTo) - dayTo;
            return resultDays;
        }
        for (int curYear = yearFrom; curYear <= yearTo; curYear++) { //iterate every year
            if (curYear == yearFrom) {
                for (int curMonth = monthFrom; curMonth <= 12; curMonth++) {
                    resultDays += DaysInMonth(yearFrom, curMonth);
                }
                resultDays -= dayFrom;
                continue;
            }
            if (curYear == yearTo) {
                for (int curMonth = 1; curMonth <= monthTo; curMonth++) {
                    resultDays += DaysInMonth(yearTo, curMonth);
                }
                resultDays -= DaysInMonth(yearTo, monthTo) - dayTo;
                continue;
            }
            for (int curMonth = 1; curMonth <= 12; curMonth++) {
                resultDays += DaysInMonth(curYear, curMonth);
            }
        }
        return resultDays;
    }


    public int DaysInMonth(int year, int month) {
        return 30;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int i = q1.daysBetween(2022, 1, 20, 2022, 2, 3);
        System.out.println(i);
    }


//
//    static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {
//        int resultDays = 0;
//        if(year1 == year2){
//            for( int curMonth = month1; curMonth <= month2; curMonth++){
//                resultDays += DaysInMonth(curMonth,year1);
//            }
//            resultDays -= day1;
//            resultDays -= DaysInMonth(month2,year1) - day2;
//            return resultDays;
//        }
//        for(int curYear = year1; curYear <= year2; curYear++){
//            if(curYear == year1){
//                for(int curMonth = month1; curMonth <= 12; curMonth++){
//                    resultDays += DaysInMonth(curMonth,year1);
//                }
//                resultDays -= day1;
//                continue;
//            }
//            if(curYear == year2){
//                for(int curMonth = 1; curMonth <= month2; curMonth++){
//                    resultDays += DaysInMonth(curMonth, year2);
//                }
//                resultDays -= DaysInMonth(month2, year2) - day2;
//                continue;
//            }
//            for(int curMonth = 1; curMonth <= 12; curMonth++){
//                resultDays += DaysInMonth(curMonth, curYear);
//            }
//        }
//        return resultDays;
//    }



}
