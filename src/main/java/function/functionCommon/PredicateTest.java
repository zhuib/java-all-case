package function.functionCommon;

import java.util.function.Predicate;

public class PredicateTest {
    public static boolean checkString(String s,Predicate<String> pre){
        return pre.test(s);
    }

    public static void main(String[] args) {
        String s = "abcd";
        boolean b = checkString(s, (t) ->
             t.length() > 5);
        System.out.println(b);
    }
}
