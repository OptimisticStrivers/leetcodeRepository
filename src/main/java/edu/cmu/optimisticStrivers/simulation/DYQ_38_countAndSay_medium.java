package edu.cmu.optimisticStrivers.simulation;

/**
 * @ClassName: DYQ_38_countAndSay_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/28 11:01 AM
 * @Version 1.0
 */
public class DYQ_38_countAndSay_medium {

    //38 外观数列
//    1.     1
//    2.     11
//    3.     21
//    4.     1211
//    5.     111221
//    第一项是数字 1
//    描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//    描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//    描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//    描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"


    public String countAndSay(int n) {
        String[] arr = new String[]{"1", "11", "21", "1211", "111221"};
        if (n <= 5) {
            return arr[n - 1];
        }
        String beginStr = arr[4];
        for (int i = 5; i < n; i++) {
            beginStr = getStr(beginStr);
        }
        return beginStr;
    }

    public String getStr(String numStr) {
        int len = numStr.length();
        StringBuilder builder = new StringBuilder();
        char temp = numStr.charAt(0);
        int count = 1;
        for (int i = 1; i < len; i++) {
            char a = numStr.charAt(i);
            if (a == temp) {
                count++;
            } else {
                builder.append(count).append(temp);
                temp = a;
                count = 1;
            }
        }
        builder.append(count).append(temp);
        return builder.toString();
    }


//  普通模拟
    public String countAndSay2(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            String cur = "";
            int m = ans.length();
            for (int j = 0; j < m; ) {
                int k = j + 1;
                while (k < m && ans.charAt(j) == ans.charAt(k)) k++;
                int cnt = k - j;
                cur += cnt + "" + ans.charAt(j);
                j = k;
            }
            ans = cur;
        }
        return ans;
    }


//    打表
//    利用数据范围只有 3030，我们可以使用 static 进行打表操作，从而节省掉不同样例之间的「重复」部分的计算量。
//    例如对于 n = 5n=5 和 n = 6n=6 都存在先计算前五项的公共部分，打表可以确保这部分只会被计算一次，同时能够应用到后面项中。
    static String[] f = new String[35];

    static {
        f[1] = "1";
        for (int i = 2; i < 35; i++) {
            String prev = f[i - 1], cur = "";
            int m = prev.length();
            for (int j = 0; j < m; ) {
                int k = j + 1;
                while (k < m && prev.charAt(j) == prev.charAt(k)) k++;
                int cnt = k - j;
                cur += cnt + "" + prev.charAt(j);
                j = k;
            }
            f[i] = cur;
        }
    }

    public String countAndSay1(int n) {
        return f[n];
    }


}
