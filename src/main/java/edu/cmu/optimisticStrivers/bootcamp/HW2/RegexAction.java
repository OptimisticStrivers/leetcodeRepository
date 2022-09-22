package edu.cmu.optimisticStrivers.bootcamp.HW2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RegexAction
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/10 12:52 PM
 * @Version 1.0
 */
public class RegexAction {
    public static void main(String[] args) {
        String s = "Hello 123 4567 World_This is a Regex Demo";
        System.out.println("s " + s);
        //match_1(s);
        //match_2(s);
        match_3(s);
        //match_4(s);
        //match_5(s);
//        match_6(s);
    }

    private static void match_1(String s) {
        Pattern pattern = Pattern.compile("^Hello\\s\\d\\d\\d\\s\\d{4}\\s\\w{10}");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    private static void match_2(String s) {
        Pattern pattern = Pattern.compile("Hello\\s(\\d+)\\s\\d{4}\\s\\w{10}");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
            System.out.println(matcher.group(0));  //匹配到的整个结果
            System.out.println(matcher.group(1));  //匹配到的第一个括号中的结果
        }
    }

    private static void match_3(String s) {
        Pattern pattern = Pattern.compile("Hello\\s(\\d*)\\s\\d{4}\\s\\w{10}");

        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
            System.out.println(matcher.group(0));  //匹配到的整个结果
            System.out.println(matcher.group(1));  //匹配到的第一个括号中的结果
        }
    }

    private static void match_4(String s) {
        Pattern pattern = Pattern.compile("Hello.*Demo");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
            System.out.println(matcher.group(0));  //匹配到的整个结果
        }
    }

    /**
     * 贪婪匹配
     * 匹配中间数字，只能得到7
     * .*会尽可能多的匹配数据
     * @param s
     */
    private static void match_5(String s) {
        Pattern pattern = Pattern.compile("Hello.*(\\d+).*Demo");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
            System.out.println(matcher.group(1));  //匹配到的整个结果

        }

    }

    /**
     * .*?非贪婪匹配
     * @param s
     */
    private static void match_6(String s) {
        Pattern pattern = Pattern.compile("Hello.*?(\\d+).*Demo");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find())  {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
    }

    /**
     * 正则表达式字符串也可以不编译直接使用
     * @param s
     */
    private static void match_7(String s) {
        String regex = "Hello.*?(\\d+).*Demo";
        boolean flag = s.matches(regex);
        System.out.println(flag);
    }

}

