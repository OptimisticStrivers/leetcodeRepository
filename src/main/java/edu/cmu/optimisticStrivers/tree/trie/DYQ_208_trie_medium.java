package edu.cmu.optimisticStrivers.tree.trie;

public class DYQ_208_trie_medium {


    //数据结构
    //https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488490&idx=1&sn=db2998cb0e5f08684ee1b6009b974089&chksm=fd9cb8f5caeb31e3f7f67dba981d8d01a24e26c93ead5491edb521c988adc0798d8acb6f9e9d&token=1232059512&lang=zh_CN#rd
    //trie 前缀树 也叫 字典树
    //可以用于 212 单词搜索 hard


    //使用数组存储
    //注意 一维是节点编号 二维是字母
//    https://desertwatermelon.blog.csdn.net/article/details/81990417?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-81990417-blog-107765963.pc_relevant_multi_platform_whitelistv1_exp2&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-81990417-blog-107765963.pc_relevant_multi_platform_whitelistv1_exp2&utm_relevant_index=1
    public static final int MAX_NODE_NUM = 1000;
    public int[][] trie = new int[MAX_NODE_NUM][26]; //字母是26 数字什么的按需决定
    public boolean[] end = new boolean[MAX_NODE_NUM]; //到词节点 为 一个单词结束  置为true
    public int nodeIndex = 0;  //用于新建node


    public void insert(String word) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            int charLoc = word.charAt(i) - 'a';
            if (trie[index][charLoc] == 0) {    //如果从index号节点 到 charLoc字母 没有 边   那就新建节点
                trie[index][charLoc] = ++nodeIndex;  //新建一个 node
            }
            index = trie[index][charLoc];  //下一个节点的 index 为 上一个节点 通过 charLoc 链接 所得
        }
        end[index] = true;
    }


    public boolean search(String word) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            int charLoc = word.charAt(i) - 'a';
            if (trie[index][charLoc] == 0) {
                return false;
            }
            index = trie[index][charLoc];
        }
        return end[index];
    }

    public boolean startsWith(String prefix) {
        int index = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int charLoc = prefix.charAt(i) - 'a';
            if (trie[index][charLoc] == 0) {
                return false;
            }
            index = trie[index][charLoc];
        }
        return true;
    }


    public static void main(String[] args) {
        DYQ_208_trie_medium dyq_208_trie_medium = new DYQ_208_trie_medium();
        dyq_208_trie_medium.insert("apple");
        System.out.println(dyq_208_trie_medium.search("apple"));
        System.out.println(dyq_208_trie_medium.search("app"));
    }




    //TreeNode形式 存 trie
    //优劣对比 工程应用
    //https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488490&idx=1&sn=db2998cb0e5f08684ee1b6009b974089&chksm=fd9cb8f5caeb31e3f7f67dba981d8d01a24e26c93ead5491edb521c988adc0798d8acb6f9e9d&token=1232059512&lang=zh_CN#rd
    //至于一些诸如「联想输入」、「模糊匹配」、「全文检索」的典型场景在工程主要是通过 ES (ElasticSearch) 解决的  而 ES 的实现则主要是依靠「倒排索引」。
    //倒排索引  https://blog.csdn.net/qq_43403025/article/details/114779166


    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root = new TrieNode();


    public void insert1(String s) {
        TrieNode temp = root;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            if(temp.tns[c]==null){
                temp.tns[c] = new TrieNode();
            }
            temp = temp.tns[c];
        }
        temp.end = true;
    }

    public boolean search1(String s) {
        TrieNode temp = root;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            if(temp.tns[c]==null){
                return false;
            }
            temp = temp.tns[c];
        }
        return temp.end;
    }

    public boolean startsWith1(String s) {
        TrieNode temp = root;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            if(temp.tns[c]==null){
                return false;
            }
            temp = temp.tns[c];
        }
        return true;
    }
}
