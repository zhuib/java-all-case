package stream;

import java.util.*;
import java.util.stream.Stream;

public class GetStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        Map<String,String> map = new HashMap<>();
        map.put("1","123");
        map.put("2","123");
        map.put("3","123");
        map.put("4","123");
//        获取键，存储到一个set集合中
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }
        Stream<String> stream2 = keySet.stream();

//        获取值，存储到一个Collection集合中
        Collection<String> values = map.values();
        for (String s : values) {
            System.out.println(s);
        }
        Stream<String> stream3 = values.stream();

//        获取键值对（键与值的映射关系 entrySet）
        Set<Map.Entry<String,String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
        entries.forEach((k) -> System.out.println(k));

        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
            System.out.println(key +"----"+value);
        }
        Stream<Map.Entry<String, String>> stream4 = entries.stream();

//        把数组转换为Stream流
        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5);
//        可变参数可以传递数组
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream6 = Stream.of(arr);
        String[] arr2 = {"a","bb","ccc"};
        Stream<String> stream7 = Stream.of(arr2);
    }
}
