package stream;

import java.util.stream.Stream;

public class Stream_forEach {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("zhangsan", "lisi", "wangwu", "zhaoliu");
        stream.forEach((name)->{
            System.out.println(name);
        });
    }
}
