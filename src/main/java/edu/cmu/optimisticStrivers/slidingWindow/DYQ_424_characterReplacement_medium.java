package edu.cmu.optimisticStrivers.slidingWindow;

/**
 * @ClassName: DYQ_424_characterReplacement_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/15 9:11 上午
 * @Version 1.0
 */
public class DYQ_424_characterReplacement_medium {

    //传统的滑动窗口
    public static int characterReplacement_a(String s, int k) {
        int left = 0, right = 0, maxAppear = 0;
        int len = s.length();
        int[] map = new int[26];
        while (right < len) {
            int curIndex = s.charAt(right) - 'A'; //全是大写
            map[curIndex]++;
            maxAppear = Math.max(maxAppear, map[curIndex]);
            while(right - left + 1 > maxAppear + k){ //一旦maxAppear+K 变得更大，即maxAppear变得更大了，窗口其实就保持住了，只能比maxAppear+K大，不能小
                System.out.println("hahah");
                map[s.charAt(left) - 'A']--;
                left++; //左移
            }
            right++;
        }
        return len - left; //right-left
    }

    public static void main(String[] args) {
        characterReplacement_a("AAABBC",2);
        System.out.println("!!!");
        characterReplacement_b("AAABBC",2);
    }


//    https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/zi-jie-ti-ku-424-zhong-deng-ti-huan-hou-mqj29/
    //牛逼的滑动窗口
    public static int characterReplacement_b(String s, int k) {
        int left = 0, right = 0, maxAppear = 0;
        int len = s.length();
        int[] map = new int[26];
        while (right < len) {
            int curIndex = s.charAt(right) - 'A'; //全是大写
            map[curIndex]++;
            maxAppear = Math.max(maxAppear, map[curIndex]);
            if (right - left + 1 > maxAppear + k) { //滑动窗口永远不变，只会扩大（right++） 或者平移（left和right都++）
                System.out.println("hahah");
                map[s.charAt(left) - 'A']--;
                left++; //左移
            }
            right++; //即使发生了左移，我们还是可以保证滑动窗口不减小
        }
        return len - left; //right-left
    }
}
