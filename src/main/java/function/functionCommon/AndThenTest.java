package function.functionCommon;

import java.util.function.Consumer;

public class AndThenTest {
    public static void method(String s, Consumer<String> con1,Consumer<String> con2){
        /*con1.accept(s);
        con2.accept(s);*/
        con1.andThen(con2).accept(s);
    }

    public static void main(String[] args) {
        method("Hello",
         (s)->{
             System.out.println(s.toLowerCase());
        },(s)->{
             System.out.println(s.toUpperCase());
        });
    }
}
