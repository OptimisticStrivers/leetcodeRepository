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


    //bfs建图 dfs找路径
    //必须自下而上 dfs 避免非必要路径
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
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) return false;
        boolean find = false; //只要找到了，就把那一层的bfs跑完即可
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> marked = new HashSet<>(); //标记的是 是否遍历过
        marked.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> levelMarked = new HashSet<>();
            for (int k = 0; k < size; k++) {
                String from = queue.poll();
//                List<String> next = new ArrayList<>();
                ArrayList<String> neighbors = getNeighbors(from, dic);
                for (String to : neighbors) {
                    if (!marked.contains(to)) {  //marked是标记的上面层的 新的一层在下面会通过levelmarked统一加入到marked里面
                        List<String> froms = edgeTo.getOrDefault(to, new ArrayList<>());
                        froms.add(from);
                        edgeTo.put(to, froms);
                        if (!levelMarked.contains(to)) { //去掉同层的to
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
                if (chs[i] == ch) //必须换一个字母
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


}
