package edu.cmu.optimisticStrivers;

/**
 * @ClassName: Test1
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/8/19 11:52 PM
 * @Version 1.0
 */
public class Test1 {


    public static void main(String[] args) {

//        Map<Integer, List<String>> map = new HashMap<>();
//        List<String> a = new ArrayList<>();
//        a.add("a");
//        a.add("aa");
//        List<String> b = new ArrayList<>();
//        b.add("b");
//        b.add("bb");
//        List<String> c = new ArrayList<>();
//        b.add("c");
//        b.add("cc");
//        map.put(1,a);
//        map.put(2,b);
//        map.put(3,c);
//        Stream<Map.Entry<Integer, List<String>>> mapStream = map.entrySet().stream();
//        List<Integer> target = new ArrayList<>();
//        target.add(1);
//        target.add(2);
//        List<String> result = new ArrayList<>();

//        List<Map.Entry<Integer, List<String>>> collect = mapStream.filter(item -> {
//            return target.contains(item.getKey());
//        }).collect(Collectors.toList());
//
//        mapStream.filter(item -> target.contains(item.getKey())).forEach(item-> result.addAll(item.getValue()));
//
//        System.out.println(result.size());
//        for (String s : result) {
//            System.out.print(s + " ");
//        }

//        Map<String, Integer> map = new HashMap<>();
//        map.put("a",1);
//        map.put("b",2);
//        map.put("c",3);
//        map.put("d",4);
//        map.put("e",5);
//
//        Map<String, Integer> collect = map.entrySet().stream().collect(Collectors.toMap(
//                memberid -> memberid.getKey(),
//                memberid -> memberid.getValue()
//        ));
//        System.out.println(collect);


//        List<String> joinedList = mapStream.toJavaList(DecrepitHouseInfo.class).stream().filter(item -> {
//            //filter 过滤目标，返回值true：保留  返回值false：不保留
//            return "C".equals(item.getType()) && "泥木结构".equals(item.getType2());
//        }).map(item ->{
//            //map 映射 可改变数据结构，添加、删除、组合数据均可
//            return item.getCity()+item.getStreet();
//        }).collect(Collectors.toList());
//        System.out.println(JSON.toJSON(addressList));




    }
}
