package edu.cmu.optimisticStrivers.bootcamp;

import java.util.Arrays;

/**
 * @ClassName: E1P1_StringSimilarity
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/4 1:05 PM
 * @Version 1.0
 */
public class E1P1_StringSimilarity {

    static int[][] trie = new int[(int) Math.pow(10, 6)][26];
    static int currentNode = 0;

    static int[] prefixSum(String[] inputs) {
        int numOfInput = inputs.length;
        int[] res = new int[numOfInput];

        for (int i = 0; i < res.length; i++) {
            String input = inputs[i];
            trie = new int[(int) Math.pow(10, 6)][26];
            currentNode = 0;
            addToTrie(input);
            int totalCount = 0;
            for (int j = 0; j < input.length(); j++) {
                int count = search(input.substring(j));
                totalCount += count;
            }
            res[i] = totalCount;
        }
        return res;
    }

    private static void addToTrie(String input) {
        int node = 0;
        for (char c : input.toCharArray()) {
            if (trie[node][c - 'a'] == 0) {
                trie[node][c - 'a'] = ++currentNode;
            }
            node = trie[node][c - 'a'];
        }
    }

    private static int search(String word) {
        int node = 0;
        int count = 0;
        for (char c : word.toCharArray()) {
            if (trie[node][c - 'a'] == 0) {
                return count;
            }
            node = trie[node][c - 'a'];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        String[] a = {"ababaa", "aa"};
//        int[] res = prefixSum1(a);
//        for (int re : res) {
//            System.out.print(re + " ");
//        }

//        int[] res = z_algo("aaabaaaba");

        int[] res = z_algo("ababaa");
        System.out.println("z: " + Arrays.stream(res).sum());
    }


    //使用前缀树超时了
    //kmp 是定位 快速定位主串 在 从串位置的  这里感觉也不适用
    //那就单纯字符串操作试试吧  5/9 还是有的会超时

    static int[] prefixSum1(String[] inputs) {
        int length = inputs.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            String word = inputs[i];
            int totalCount = 0;
            for (int j = 0; j < word.length(); j++) {
                String suffixWord = word.substring(j);
                int count = 0;
                for (int k = 0; k < suffixWord.length(); k++) {
                    if (suffixWord.charAt(k) == word.charAt(k)) {
                        count++;
                    } else {
                        break;
                    }
                }
                totalCount += count;
            }
            res[i] = totalCount;
        }
        return res;
    }


    //z algorithm
    //扩展dmp 还是 扩展manacher
    //https://www.bilibili.com/video/BV1Y54y1o7Ca?spm_id_from=333.337.search-card.all.click

    public static int[] z_algo(String target) {
        int len = target.length();
        int[] z_algorithm = new int[len + 1]; //start with 1 index
        z_algorithm[1] = len;

        //z box始终记录的是最远的那个right的 box
        int left = 0;
        int right = 0;
        for (int i = 2; i <= len; i++) {
            if (i <= right) { //在盒子里面
                //i到r 一共 right-i+1个数
                //index i-left是 移到最前方 + 1 是因为我们是从1开始的index
                z_algorithm[i] = Math.min(z_algorithm[i - left + 1], right - i + 1);
            }
//
//            if (i == 5) {
//                System.out.println("* " + target.charAt(+z_algorithm[i]));
//                System.out.println("* " + target.charAt(i + z_algorithm[i] - 1));
//            }
            while (z_algorithm[i] + i - 1 < len && target.charAt(z_algorithm[i]) == target.charAt(i + z_algorithm[i] - 1)) { //i不在盒子里 或者 z值超出去了  暴力匹配
                z_algorithm[i]++;
            }
//            System.out.println(z_algorithm[i]);
            //扩大盒子 -1是因为有i本身
            if (i + z_algorithm[i] - 1 > right) {
                left = i; //left永远在right前面
                right = i + z_algorithm[i] - 1;
                System.out.println(z_algorithm[2]);
                System.out.println(right);
//              因为i是一直往后的 所以我们不要求 zbox 大，而是要求z_box右端远
            }
            System.out.println("i=" + i + " z=" + z_algorithm[i] + " [" + left + "," + right + "]");
        }
//        int[] res = new int[len];
//        for (int i = 0; i < res.length; i++) {
//            res[0] = z_algorithm[i + 1];
//        }
        return z_algorithm;
    }

//    public static long zFunc(String st) {
//        int n = st.length();
//        char[] s = st.toCharArray();
//        long total = 0;
//        long[] z = new long[n];
//        int L = 0, R = 0;
//        for (int i = 0; i < n; i++) {
//            if (i > R) {
//                L = R = i;
//                while (R < n && s[R - L] == s[R]) R++;
//                z[i] = R - L;
//                R--;
//            } else {
//                int k = i - L;
//                if (z[k] < R - i + 1) z[i] = z[k];
//                else {
//                    L = i;
//                    while (R < n && s[R - L] == s[R]) R++;
//                    z[i] = R - L;
//                    R--;
//                }
//            }
//            total += z[i];
//        }
//        return total;
//    }
}
