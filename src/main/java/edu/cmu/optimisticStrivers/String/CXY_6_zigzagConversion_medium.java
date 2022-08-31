package edu.cmu.optimisticStrivers.String;

public class CXY_6_zigzagConversion_medium {
    public String convert(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        int row = 0;
        int step = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        for(char c : chars){
            stringBuilders[row].append(c);
            row += step;
            if(row == numRows){
                row = numRows - 2;
                step = -1;
            }
            if(row < 0){
                row = 0;
                step = 1;
            }
        }
        for (int i = 1; i < numRows; i++) {
            stringBuilders[0].append(stringBuilders[i]);
        }
        return stringBuilders[0].toString();
    }
}
