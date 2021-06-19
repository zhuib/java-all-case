package funcUse;

public class funcUse {
    public static void print(Printable p){
        p.print("HelloWorld");

    }

    public static void main(String[] args) {
        print((s)->{
            System.out.println(s);
        });

        print(System.out::println);
    }
}
