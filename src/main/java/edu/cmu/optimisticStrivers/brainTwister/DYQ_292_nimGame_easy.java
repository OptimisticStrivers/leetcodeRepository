package edu.cmu.optimisticStrivers.brainTwister;

/**
 * @ClassName: DYQ_292_nimGame_easy
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/7 1:12 PM
 * @Version 1.0
 */
public class DYQ_292_nimGame_easy {


    // NIM 的意思 其实就是 取数游戏/余子棋

    //这个好像是  文杰问我的  字节三面的那个数数问题
    //好像是邱泽元以前和我说的那个 酒吧喝酒的问题


    //有一堆石头，你和你的朋友一起玩，并且是你先手，每次可以拿1-3个石头，谁拿到最后一个石头，谁赢
    //判断你是不是一定可以赢
    //输入就是石头的个数


    //巴什博奕，n%(m+1)!=0
    //先手的总会赢的

    //只要轮他的时候 剩余不是4的倍数就行 我就可以拿1，2，3让他获得的是4的倍数即可
    //比如10 我拿2 他剩下8 他一定会输 因为我还是可以控制让他下一轮是 4
    //所以这个n%(3+1) != 0 要必赢的前提也是 先手
    //先手就能先拿那个余数，然后把n%(3+1) == 0 这个4的倍数的先手必输条件留给别2
    public boolean canWinNim(int n) {
        return n % (3 + 1) != 0;
    }


//
//    db.restaurants.insertMany([{
//        name:"Morris Park Bake Shop",
//        cuisine:"Bakery",
//        addresses:[
//        {
//            number:1007,
//                street:"Morris Park Ave",
//                zip:10462,
//                borough:"Bronx",
//                grades:[
//            {
//                inspectionDate:1393804800000,
//                        grade:"A" },
//            3
//] },
//        {
//] }]);
//        {
//] }
//        name:"Wendys",
//                cuisine:"Hamburgers",
//                locations:[
//        {
//] },
//        {
//] }
//        {
//            inspectionDate:1358985600000,
//                    grade:"B" }
//        number:1602,
//                street:"Shore Parkway",
//                zip:11214,
//                borough:"Brooklyn",
//                grades:[
//        {
//            inspectionDate:1421193600000,
//                    grade:"A" },
//        {
//            inspectionDate:1409184000000,
//                    grade:"A" }
//        number:1661,
//                street:"Hylan Blvd",
//                zip:10305,
//                borough:"Staten Island",
//                grades:[
//        {
//            inspectionDate:1417651200000,
//                    grade:"A" },
//        {
//            inspectionDate:1334793600000,
//                    grade:"B" }


}
