package edu.cmu.optimisticStrivers.unionFind;

import java.util.*;

/**
 * @ClassName: DYQ_721_mergeEmailAcounts_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/3/21 10:49 上午
 * @Version 1.0
 */
public class DYQ_721_mergeEmailAccounts_medium {

    //并查集详解
//    https://destiny1020.blog.csdn.net/article/details/7655764?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_paycolumn_v3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_paycolumn_v3&utm_relevant_index=2

    //该题详解
//    https://leetcode-cn.com/problems/accounts-merge/solution/zhang-hu-he-bing-by-leetcode-solution-3dyq/


    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        //邮箱->index
        Map<String,Integer> map1 = new HashMap<>();
        //邮箱->姓名
        Map<String,String> map2 = new HashMap<>();

        int emailCount = 0;

        for(List<String> list : accounts){
            String curName = list.get(0);
            int size = list.size();
            for(int i = 1; i<size; i++){
                String email = list.get(i);
                //保证email唯一性
                if(!map1.containsKey(email)){
                    map1.put(email,emailCount++);
                    map2.put(email,curName);
                }
            }
        }

        //初始化并查集，一开始都是自己和自己连接
        UnionFind unionFind = new UnionFind(emailCount);

        //把进行 union and find， 一个姓名下的email当然都合并
        for(List<String> list : accounts){
            String firstEmail = list.get(1);
            int indexF = map1.get(firstEmail);
            for(int i = 2; i<list.size(); i++ ){
                String nextEmail = list.get(i);
                int indexN = map1.get(nextEmail);
                unionFind.union(indexF,indexN);
            }
        }


        //建立一个Index对应邮箱地址的Map，一波一波
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        //通过emailToIndex遍历邮箱地址
        for (String email : map1.keySet()) {
            //根据索引在并查集中得到当前邮箱地址的根节点
            int index = unionFind.find(map1.get(email));
            //这个人如果已经有了res集了，就不用创建了
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            //在当前的List中加入现邮箱地址，因为他们有同一个根
            account.add(email);
            //更新indexToEmails的邮箱列表
            indexToEmails.put(index, account);
        }

        //把 indexToEmails里的 index换成名字 完工

        List<List<String>> res = new ArrayList<>();

        //通过indexToEmail的值（values）进行遍历
        for (List<String> emails : indexToEmails.values()) {
            //将emails按照题目要求进行排序
            Collections.sort(emails);
            //得到当前邮箱组的根，然后根据根得到用户名字
            String name = map2.get(emails.get(0));
            //创建一个account表
            List<String> account = new ArrayList<String>();
            //首先添加用户名字，然后用addAll将emails表整个添加到account中
            account.add(name);
            account.addAll(emails);
            //最后在答案表中添加整理好后的用户以及邮箱表
            res.add(account);
        }
        return res;



    }

}
class UnionFind{
    int[] parent;
    //初始化 index
    public UnionFind(int n){
        parent = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
    }

    public void union(int x, int y){
        parent[find(x)] = find(y);
    }
    public int find(int index){
        //递归找根,或者循环
        while(parent[index]!=index){
            index = parent[index];
        }
        return index;

    }

}