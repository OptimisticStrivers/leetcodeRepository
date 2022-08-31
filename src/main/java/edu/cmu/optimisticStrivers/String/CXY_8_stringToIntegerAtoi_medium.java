package edu.cmu.optimisticStrivers.String;

public class CXY_8_stringToIntegerAtoi_medium {
    public int myAtoi(String _s) {
        char[] s = _s.toCharArray();
        int i = 0;
        int sign = 1;
        long ans = 0;
        while (i < s.length && s[i] == ' ') {
            i++;
        }
        if (i < s.length && (s[i] == '-' || s[i] == '+')) {
            if (s[i] == '-') {
                sign = -1;
            }
            i++;
        }
        while (i < s.length && s[i] <= '0' && s[i] >= '9') {
            ans = ans * 10 + s[i];
            i++;
            if (ans > 2147483647) {
                if (sign == 1) {
                    return 2147483647;
                } else {
                    return -2147483648;
                }
            }
        }
        return sign * (int) ans;
    }
}
