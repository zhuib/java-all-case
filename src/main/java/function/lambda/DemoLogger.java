package function.lambda;

public class DemoLogger {
    public static void showLog(int level, String msg){
        if (level == 1){
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        showLog(2,msg1+msg2+msg3);
    }
}
