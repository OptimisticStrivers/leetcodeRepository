package edu.cmu.optimisticStrivers.bootcamp;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: E1P2_CommandLine
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/4 7:36 PM
 * @Version 1.0
 */
public class E1P2_CommandLine {


    static class ParsedCommand {
        ArrayList<String> argv;
        Set<String> switches;

        ParsedCommand() {
            argv = new ArrayList<String>();
            switches = new TreeSet<String>();
        }
    }

    ;

    /*
     * Complete the function below.
     */


    static ParsedCommand parseCommand(String cmdline) {
        ParsedCommand parsedCommand = new ParsedCommand();
        int len = cmdline.length();
        //先剔除所有的非 switch 那就是 command
        //注意处理空格
        //先找到所有的switch
        for (int i = 0; i < len; i++) {
            if (cmdline.charAt(i) == '/') {
                if (i + 1 == len) break; //这种情况应该发生不了
                i++;
                char nextChar = cmdline.charAt(i);
                boolean remove = false;
                if (nextChar == '-') {
                    remove = true;
                    i++;
                }
                while (i < len && Character.isLetter(cmdline.charAt(i))) {
//                while (i < len && Character.toUpperCase(cmdline.charAt(i)) >= 'A' && Character.toUpperCase(cmdline.charAt(i)) <= 'Z') {
//                    String s = "/" + Character.toUpperCase(cmdline.charAt(i));
                    String s = String.valueOf(Character.toUpperCase(cmdline.charAt(i)));
                    if (remove) {
                        parsedCommand.switches.remove(s);
                    } else {
                        parsedCommand.switches.add(s);
                    }
                    //直到 空格 或者 结尾 或者 下一个/ 才会结束

                    //这里有一个遗留问题 如果不是字母的话 可以 toUpperCase吗 貌似可以
//                    if (i + 1 < len && Character.toUpperCase(cmdline.charAt(i+1)) < 'A' && Character.toUpperCase(cmdline.charAt(i+1)) > 'Z') {
                    if (i + 1 < len && !Character.isLetter(cmdline.charAt(i + 1))) {
//                        cmdline.charAt(i + 1) == ' ' && cmdline.charAt(i + 1) == '/'
                        break;
                    }
                    i++;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < len && cmdline.charAt(i) != '/' && cmdline.charAt(i) != ' ') {
                    sb.append(cmdline.charAt(i));
                    i++;
                }
//                System.out.println("*");
                if (sb.length() != 0) {
                    parsedCommand.argv.add(sb.toString());
                    i--; //等于空才能-- 不然现在是一个空格 你也i减减 就无限循环
                }
            }
        }
        //没有command
        if (parsedCommand.argv.size() == 0) return null;
        return parsedCommand;
    }

    public static void main(String[] args) {

//        ParsedCommand ab11601_rulez = parseCommand("/Ab11601 rulez");
//        ParsedCommand ab11601_rulez = parseCommand("COMMAND/A");
//        ParsedCommand ab11601_rulez = parseCommand("/Ab11601 rulez");
//        ParsedCommand ab11601_rulez = parseCommand("cmd+A");
//        ParsedCommand ab11601_rulez = parseCommand("cmd+A");
//        ParsedCommand ab11601_rulez = parseCommand(".");
        ParsedCommand ab11601_rulez = parseCommand("/Call-me Ishmael");

//        Call-me Ishmael
//        "."

        System.out.println(ab11601_rulez.argv);
        System.out.println(ab11601_rulez.switches);

    }


}
//
//    private static void writeCommand(BufferedWriter bw, ParsedCommand pc) throws IOException {
//        if (pc == null) {
//            bw.write("Invalid Command Line");
//            bw.newLine();
//            return;
//        }
//        if (pc.argv == null || pc.argv.size() == 0) {
//            bw.write("Invalid ParsedCommand - empty argv");
//            bw.newLine();
//            return;
//        }
//        for (int i = 0; i < pc.argv.size(); i++) {
//            bw.write("argv[" + String.valueOf(i) + "]=\"" + pc.argv.get(i) + "\"");
//            bw.newLine();
//        }
//        for (String sw : pc.switches) {
//            bw.write("/" + sw);
//            bw.newLine();
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = null;
//        if (fileName != null) {
//            bw = new BufferedWriter(new FileWriter(fileName));
//        } else {
//            bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        }
//
//        String cmdline;
//        try {
//            cmdline = in.nextLine();
//        } catch (Exception e) {
//            cmdline = null;
//        }
//
//        writeCommand(bw, parseCommand(cmdline));
//        bw.close();
//    }

