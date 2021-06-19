package stream;

import java.util.stream.Stream;

public class Stream_map {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
        Stream<String> stream1 = Stream.of("a", "b", "c", "d", "f");

        Stream<String> concat = Stream.concat(stream, stream1);
        concat.forEach(s -> System.out.println(s));
        /*Stream<Integer> stream1 = stream.map((s) -> {
            return Integer.parseInt(s);
        });
//        stream1.forEach(i -> System.out.println(i));
        Stream<Integer> skip = stream1.skip(3);
        skip.forEach(integer -> System.out.println(integer));*/
//        Stream<Integer> limit = stream1.limit(3);
//        limit.forEach(integer -> System.out.println(integer));
//        System.out.println(limit);
//        long count = limit.count();
//        System.out.println(count);
    }
}
