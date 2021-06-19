package function;

public class Demo {
    public static void show(MyFunctionInterface myInterface){
        myInterface.method();
    }

    public static void main(String[] args) {
//        参数是接口可以传递其实现类的接口
        show(new MyFunctionInterfaceIImpl());

        show(new MyFunctionInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类表达式");
            }
        });

        show(()->{
            System.out.println("使用Lambda表达式");
        });

        show(()->
            System.out.println("使用Lambda表达式,简化"));
    }
}
