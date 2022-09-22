package edu.cmu.optimisticStrivers.greedy;

/**
 * @ClassName: DYQ_134_gasStation_medium
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/31 6:41 PM
 * @Version 1.0
 */
public class DYQ_134_gasStation_medium {

//    Given two integer arrays gas and cost,
//    return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
//    otherwise return -1. If there exists a solution, it is guaranteed to be unique

    //这种纯模拟 所以gas station的 会超时，比如有非常多的gas station
    //o n^2
    //但是评论有一个骚操作， 倒序可过
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //simulate from all gas station
        for (int startIndex = 0; startIndex < gas.length; startIndex++) {
            int currentGas = gas[startIndex];
            int skipTimes = gas.length;
            int currentIndex = startIndex;
            while (currentGas - cost[currentIndex] >= 0) { //一直能跳的条件是 当前的gas-cost >= 0
                currentGas = currentGas - cost[currentIndex]; //先消耗油
                currentIndex = (currentIndex + 1) % gas.length; //再跳过去

                currentGas += gas[currentIndex];//再加油
                if (currentIndex == startIndex) { //防止 可以走通但无限循环
                    return startIndex;
                }
            }
        }
        return -1;
    }


    //所以暴力on^2 是行不通的
    //我们要想贪心 这个贪心的关键就是
    // 如果从一个地方A出发 攒的钱不够付过路费，在E被砍死，那么只要在中间的任何一点出发都会在E被砍死的
    // 因为我们一开始已经判断了 一圈的钱大于过路费 就说明总有一个地方出发能走 不被砍死
    //这个砍人的例子太屌了
    // O(n)
    public int canCompleteCircuit1(int[] gas, int[] cost) {

        int totalMoney = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalMoney += gas[i];
            totalCost += cost[i];
        }
        if (totalMoney < totalCost) { //一定会被砍死
            return -1;
        }
        //有一个地方出发 一定不会被砍死
        int allMoney = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            allMoney += gas[i];
            allMoney -= cost[i];
            if (allMoney < 0) { //说明从start开始 到 i都不能出发
                //start 到 i-1 都没有死
                //任意一点出发都会 减少 累计正数  一定会死
                //所以从i+1开始就行

                //从i+1出发
                allMoney = 0;
                start = i + 1;
            }
        }
        return start;
    }


//    有一个环形路上有n个站点； 每个站点都有一个好人或一个坏人； 好人会给你钱，坏人会收你一定的过路费，如果你带的钱不够付过路费，坏人会跳起来把你砍死； 问：从哪个站点出发，能绕一圈活着回到出发点?
//
//    首先考虑一种情况：如果全部好人给你 的钱加起来 小于 坏人收的过路费之和，那么总有一次你的钱不够付过路费，你的结局注定会被砍死。
//
//    假如你随机选一点 start 出发，那么你肯定会选一个有好人的站点开始，因为开始的时候你没有钱，遇到坏人只能被砍死；
//
//    现在你在start出发，走到了某个站点end，被end站点的坏人砍死了，说明你在 [start, end) 存的钱不够付 end点坏人的过路费，因为start站点是个好人，所以在 (start, end) 里任何一点出发，你存的钱会比现在还少，还是会被end站点的坏人砍死；
//
//    于是你重新读档，聪明的选择从 end+1点出发，继续你悲壮的征程； 终于有一天，你发现自己走到了尽头（下标是n-1)的站点而没有被砍死； 此时你犹豫了一下，那我继续往前走，身上的钱够不够你继续走到出发点Start?
//
//    当然可以，因为开始已经判断过，好人给你的钱数是大于等于坏人要的过路费的，你现在攒的钱完全可以应付 [0, start) 这一段坏人向你收的过路费。 这时候你的嘴角微微上扬，眼眶微微湿润，因为你已经知道这个世界的终极奥秘：Start就是这个问题的答案。
//


    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        DYQ_134_gasStation_medium dyq_134_gasStation_medium = new DYQ_134_gasStation_medium();
        System.out.println(dyq_134_gasStation_medium.canCompleteCircuit(gas, cost));
    }






}
