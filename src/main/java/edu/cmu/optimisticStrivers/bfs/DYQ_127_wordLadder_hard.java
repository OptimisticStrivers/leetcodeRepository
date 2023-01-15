package edu.cmu.optimisticStrivers.bfs;

import java.util.*;

public class DYQ_127_wordLadder_hard {

//    beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//    Output: 5
//    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
//
//
//    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//    Output: 0
//    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


    //单向bfs过不了 搜索空间爆炸
    //双向bfs  https://leetcode.cn/problems/word-ladder/solution/gong-shui-san-xie-ru-he-shi-yong-shuang-magjd/
    String s, e;
    Set<String> set = new HashSet<>();

    public int ladderLength_final(String _s, String _e, List<String> ws) {
        s = _s;
        e = _e;
        // 将所有 word 存入 set，如果目标单词不在 set 中，说明无解
        for (String w : ws) set.add(w);
        if (!set.contains(e)) return 0;
        int ans = bfs();
        return ans == -1 ? 0 : ans + 1;
    }

    int bfs() {
        // d1 代表从起点 beginWord 开始搜索（正向）
        // d2 代表从结尾 endWord 开始搜索（反向）
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque();

        /*
         * m1 和 m2 分别记录两个方向出现的单词是经过多少次转换而来
         * e.g.
         * m1 = {"abc":1} 代表 abc 由 beginWord 替换 1 次字符而来
         * m2 = {"xyz":3} 代表 xyz 由 endWord 替换 3 次字符而来
         */
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.add(s);
        m1.put(s, 0);
        d2.add(e);
        m2.put(e, 0);

        /*
         * 只有两个队列都不空，才有必要继续往下搜索
         * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
         * e.g.
         * 例如，如果 d1 为空了，说明从 beginWord 搜索到底都搜索不到 endWord，反向搜索也没必要进行了
         */
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            // 为了让两个方向的搜索尽可能平均，优先拓展队列内元素少的方向
            if (d1.size() <= d2.size()) {
                t = update(d1, m1, m2); //从正方向 走一层bfs
            } else {
                t = update(d2, m2, m1);
            }
            if (t != -1) return t;
        }
        return -1;
    }

    // update 代表从 deque 中取出一个单词进行扩展，
    // cur 为当前方向的距离字典；other 为另外一个方向的距离字典
    int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        int m = deque.size();
        while (m-- > 0) {
            // 获取当前需要扩展的原字符串
            String poll = deque.pollFirst();
            int n = poll.length();

            // 枚举替换原字符串的哪个字符 i
            for (int i = 0; i < n; i++) {
                // 枚举将 i 替换成哪个小写字母
                for (int j = 0; j < 26; j++) {
                    // 替换后的字符串
                    String sub = poll.substring(0, i) + String.valueOf((char) ('a' + j)) + poll.substring(i + 1);
                    if (set.contains(sub)) {
                        // 如果该字符串在「当前方向」被记录过（拓展过），跳过即可
//                        if (cur.containsKey(sub) && cur.get(sub) <= cur.get(poll) + 1) continue;
                        if (cur.containsKey(sub)) continue;

                        // 如果该字符串在「另一方向」出现过，说明找到了联通两个方向的最短路
                        if (other.containsKey(sub)) {
                            return cur.get(poll) + 1 + other.get(sub);
                        } else {
                            // 否则加入 deque 队列
                            deque.addLast(sub);
                            cur.put(sub, cur.get(poll) + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }


    //bfs
    //简单直观的单向广度优先搜索。 要速度更快的话可以双向广度优先搜索
    //用bfs的原因是不是因为  直接找到一个结果就可以停止了  所以比dfs快?

//    无向图中两个顶点之间的最短路径的长度，可以通过广度优先遍历得到；
//    为什么 BFS 得到的路径最短？可以把起点和终点所在的路径拉直来看，两点之间线段最短；
//    已知目标顶点的情况下，可以分别从起点和目标顶点（终点）执行广度优先遍历，直到遍历的部分有交集，这是双向广度优先遍历的思想。

    public int ladderLength_oneway_bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>(); //visited
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);//虽然beginword 不在 wordList里面 但是这里如果不加入的话 下面直接因为
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++count;
//            for (int i = 0; i < queue.size(); i++) {   //注意 这样不可以的 queue的大小是会变的
            for (int i = 0; i < size; ++i) {
                String cur = queue.poll();
                for (String word : wordList) {
//                    if (!visited.add(word)) {  //当然不能放在 canConvert和检查的前面
//                        continue;
//                    }
                    if (visited.contains(word)) {
                        continue;
                    }
                    if (!canConvert(cur, word)) continue;
                    if (word.equals(endWord)) return count + 1;
                    visited.add(word);
                    queue.offer(word);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }


    //双向bfs 两头一起走 相遇就行
    public int ladderLength_twoWay_bfs(String beginWord, String endWord, List<String> wordList) {
        //如果是双向的bfs 需要先确定下 endWord 在不在 wordList里面
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }


        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        int count1 = 0;
        int count2 = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            //两方 各走一层 那么一次就能走两层
            int len1 = queue1.size();
            count1++;
            for (int i = 0; i < len1; i++) {
                String cur = queue1.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String word = wordList.get(j);
                    if (visited1.contains(word)) {
                        continue;
                    }
                    if (!canConvert(cur, word)) {
                        continue;
                    }
                    if (visited2.contains(word)) { //相遇
                        return count1 + count2 + 1;
//                        return count1 + count2;
                    }
                    queue1.add(word);
                    visited1.add(word);
                }
            }
            count2++;
            int len2 = queue2.size();
            for (int i = 0; i < len2; i++) {
                String cur = queue2.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String word = wordList.get(j);
                    if (visited2.contains(word)) {
                        continue;
                    }
                    if (!canConvert(cur, word)) {
                        continue;
                    }
                    if (visited1.contains(word)) { //相遇
                        return count1 + count2 + 1;
//                        return count1 + count2;
                    }
                    queue2.add(word);
                    visited2.add(word);
                }
            }
        }
        return 0;
    }


    //dfs 我写的 会超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //构建字典
        Map<String, List<String>> map = buildMap(wordList);
        int length = wordList.get(0).length(); //所有单词的长度都一样

        Map<String, Boolean> visited = new HashMap<>();
        for (String key : map.keySet()) {
            visited.put(key, false);
        }
        dfs(beginWord, endWord, wordList, map, length, 0, visited);


        return minPath == Integer.MAX_VALUE ? 0 : minPath + 1;
    }


    public int minPath = Integer.MAX_VALUE;

    //全局记录 最短路径 不断更新
    //拒绝环路 所以还需要 回溯一下 map的key 在同一个path 不要重复访问即可
    public void dfs(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> map, int length, int curPathLength, Map<String, Boolean> visited) {
        System.out.println("111");
        if (curPathLength > minPath) {
            return;
        }
        if (beginWord.equals(endWord)) {
            minPath = curPathLength;
        }

        System.out.println("1111");

        for (int i = 0; i < length; i++) {
            String formerString = beginWord.substring(0, i);
            String latterString = beginWord.substring(i + 1, length);
            String key = formerString + "*" + latterString;
            if (visited.get(key) == null || visited.get(key)) { //等于null 说明当前这种key 压根字典里面没有
                continue;
            }
            if (map.get(key) != null) {
                for (int j = 0; j < map.get(key).size(); j++) {
                    visited.put(key, true);
                    dfs(map.get(key).get(j), endWord, wordList, map, length, curPathLength + 1, visited);
                    visited.put(key, false);
                }
            }
        }
    }

    private Map<String, List<String>> buildMap(List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        int length = wordList.get(0).length(); //所有单词的长度都一样
        for (int i = 0; i < wordList.size(); i++) {
            //每个单词能产出length种key 然后去重即可
            String currentWord = wordList.get(i);
            for (int j = 0; j < length; j++) {
                String formerString = currentWord.substring(0, j);
                String latterString = currentWord.substring(j + 1, length);
                String key = formerString + "*" + latterString;
                map.computeIfAbsent(key, k -> new ArrayList<>());
                map.get(key).add(currentWord);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("key " + entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i) + " ");
            }
            System.out.println();
        }
        return map;
    }


    public static void main(String[] args) {
//        String a = "apple";
//        System.out.println(a.substring(5, 5));
//        System.out.println(a.substring(0, 0));

        DYQ_127_wordLadder_hard dyq_127_wordLadder_hard = new DYQ_127_wordLadder_hard();
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        System.out.println(dyq_127_wordLadder_hard.ladderLength("hit", "cog", list));
        System.out.println(dyq_127_wordLadder_hard.ladderLength_oneway_bfs("hit", "cog", list));
        System.out.println(dyq_127_wordLadder_hard.ladderLength_twoWay_bfs("hit", "cog", list));


//        List<String> list1 = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
//        System.out.println(dyq_127_wordLadder_hard.ladderLength("hit", "cog", list1));

    }


}
