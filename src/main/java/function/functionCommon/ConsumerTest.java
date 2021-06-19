package function.functionCommon;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void method(String name, Consumer<String> con){
        con.accept(name);
    }

    public static void main(String[] args) {
        method("张三",(String name)->{
            System.out.println(name);
            String rename = new StringBuilder(name).reverse().toString();
            System.out.println(rename);
        });

        method("sadf",new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
