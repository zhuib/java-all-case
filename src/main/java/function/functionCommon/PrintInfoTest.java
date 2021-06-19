package function.functionCommon;

import java.util.function.Consumer;

public class PrintInfoTest {
    public static void printInfo(String[] arr, Consumer<String> one,Consumer<String>two){
        for (String s : arr) {
            one.andThen(two).accept(s);
        }
    }

    public static void main(String[] args) {
        String[] arr = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        printInfo(arr,
                (t)->{
                    String name = t.split(",")[0];
                    System.out.print("姓名："+name+"  ");
                },
                (s)->{
                    String denger = s.split(",")[1];
                    System.out.println("性别："+denger);
                });
    }
}
