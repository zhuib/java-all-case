package function.functionCommon;

import java.util.function.Function;

public class FunctionTest {
    public static void method(String s,Function<String,Integer> func){
        Integer in = func.apply(s);
        System.out.println(in+20);
    }

    public static void main(String[] args) {
        String s = "123";
        method(s,(t)->{
           return Integer.parseInt(t);
        });
    }

}
