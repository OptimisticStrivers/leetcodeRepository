package edu.cmu.optimisticStrivers.bfs;

import java.util.*;

/**
 * @ClassName: DYQ_127_wordLadder2_hard
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/24 10:40 PM
 * @Version 1.0
 */
public class DYQ_127_wordLadder2_hard {

//    https://leetcode.cn/problems/word-ladder-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-3/
//    https://leetcode.cn/problems/word-ladder-ii/solution/by-mao-mao-ab-f5ho/


    List<List<String>> ans;
    Map<String, List<String>> edgeTo;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        edgeTo = new HashMap<>();
        if (!bfs(beginWord, endWord, wordList)) return ans;
        LinkedList<String> list = new LinkedList<>();
        list.add(endWord);
        dfs(beginWord, endWord, list);
        return ans;
    }

    public void dfs(String begin, String cur, LinkedList<String> list) {
        if (cur.equals(begin)) {
            ans.add(new ArrayList<>(list));
            return;
        }
        List<String> froms = edgeTo.get(cur);
        for (String from : froms) {
            list.addFirst(from);
            dfs(begin, from, list);
            list.removeFirst();
        }
    }

    public boolean bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>();
        for (String word : wordList) {
            dic.add(word);
        }
        if (!dic.contains(endWord)) return false;
        boolean find = false;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> marked = new HashSet<>();
        marked.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> levelMarked = new HashSet<>();
            for (int k = 0; k < size; k++) {
                String from = queue.poll();
//                List<String> next = new ArrayList<>();
                ArrayList<String> neighbors = getNeighbors(from, dic);
                for (String to : neighbors) {
                    if (!marked.contains(to)) {
                        // 同下一层 还是要更新edge的 无论是否会进queue两次
                        // to froms 因为我们要找到所有路径
                        List<String> froms = edgeTo.getOrDefault(to, new ArrayList<>());
                        froms.add(from);
                        edgeTo.put(to, froms);
                        //同一下层 进过queue的 就不再进了
                        if (!levelMarked.contains(to)) { //！！这个levelmark的作用其实就是 为了一会儿加到marked里面
                            //用edgeTo没办法区分是不是新的着一层
                            levelMarked.add(to);
                            queue.offer(to);
                        }
                        if (to.equals(endWord)) find = true;
                    }
                }
            }
            marked.addAll(levelMarked);
            levelMarked.clear();
            if (find) break;
        }
        return find;
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }


//    public boolean bfs(String beginWord, String endWord, List<String> wordList) {
//        Set<String> dic = new HashSet<>();
//        for (String word : wordList) {
//            dic.add(word);
//        }
//        if (!dic.contains(endWord)) return false;
//        boolean find = false;
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        Set<String> marked = new HashSet<>();
//        marked.add(beginWord);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            Set<String> levelMarked = new HashSet<>();
//            for (int k = 0; k < size; k++) {
//                String from = queue.poll();
////                List<String> next = new ArrayList<>();
//                char[] arr = from.toCharArray();
//                for (int i = 0; i < arr.length; i++) {
//                    char old = arr[i];
//                    for (char j = 'a'; j <= 'z'; j++) {
//                        if (j != old) {
//                            arr[i] = j;
//                            String to = String.valueOf(arr);
//                            //上层和上上层 出现过的 都不会再出现了
//                            if (dic.contains(to) && !marked.contains(to)) {
//                                // 同下一层 还是要更新edge的 无论是否会进queue两次
//                                // to froms 因为我们要找到所有路径
//                                List<String> froms = edgeTo.getOrDefault(to, new ArrayList<>());
//                                froms.add(from);
//                                edgeTo.put(to, froms);
//                                //同一下层 进过queue的 就不再进了
//                                if (!levelMarked.contains(to)) { //！！这个levelmark的作用其实就是 为了一会儿加到marked里面
//                                    //用edgeTo没办法区分是不是新的着一层
//                                    levelMarked.add(to);
//                                    queue.offer(to);
//                                }
//                                if (to.equals(endWord)) find = true;
//                            }
//                        }
//                    }
//                    arr[i] = old;
//                }
//            }
//            marked.addAll(levelMarked);
//            levelMarked.clear();
//            if (find) break;
//        }
//        return find;
//    }


}
