package edu.cmu.optimisticStrivers.OA.goldsman;

import java.util.Arrays;

/**
 * @ClassName: Q3
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/16 11:00 PM
 * @Version 1.0
 */
public class Q3 {


    public static int perfectTeam(String skills) {

        char[] skill = skills.toCharArray();
        int[] groupNums = new int[5];
        for (int i = 0; i < skill.length; i++) {
            if (skill[i] == 'p') {
                System.out.println("123");
                groupNums[0]++;
            } else if (skill[i] == 'c') {
                groupNums[1]++;
            } else if (skill[i] == 'm') {
                groupNums[2]++;
            } else if (skill[i] == 'b') {
                groupNums[3]++;
            } else if (skill[i] == 'z') {
                groupNums[4]++;
            }
        }
        for (int groupNum : groupNums) {
            System.out.println(groupNum);
        }
        System.out.println();
        Arrays.sort(groupNums);
        for (int groupNum : groupNums) {
            System.out.println(groupNum);
        }
        for (int i = 0; i < groupNums.length; i++) {
            if(groupNums[i]==0) return 0;
            if (groupNums[i] > 0) return groupNums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(perfectTeam("pcmpp"));
        System.out.println(perfectTeam("pcmbz"));

    }
}
