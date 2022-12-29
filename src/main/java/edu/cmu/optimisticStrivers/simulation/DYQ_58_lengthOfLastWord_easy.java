package edu.cmu.optimisticStrivers.simulation;

/**
 * @ClassName: DYQ_58_lengthOfLastWord_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/12/28 11:40 AM
 * @Version 1.0
 */
public class DYQ_58_lengthOfLastWord_easy {

    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else { //当前是空格
                if (length != 0) {
                    return length;
                }
            }
        }
        return length;
    }

//    输入：s = "   fly me   to   the moon  "
//    输出：4
//    解释：最后一个单词是“moon”，长度为4。


}
