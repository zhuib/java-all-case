package stream;

import java.util.stream.Stream;

public class Stream_filter {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("zhangsan", "zhaomin", "zhangwuji", "zhouzhirou");
        Stream<String> stream1 = stream.filter((name) -> {
            return name.startsWith("zhang");
        });
        stream1.forEach(name-> System.out.println(name));
    }
}
