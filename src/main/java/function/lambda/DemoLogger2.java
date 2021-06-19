package function.lambda;

public class DemoLogger2 {
    public static void showLog(int level, MessageBuild build){
        if (level == 1){
            System.out.println(build.buildMessage());
        }
    }

    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        showLog(2,()->{
            System.out.println("执行方法");
            return msg1 + msg2 + msg3;
        });
    }
}
