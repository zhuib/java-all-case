package funcUse;

public class ObjectMethodReference {
    public static void printString(Printable p){
        p.print("Hello");
    }

    public static void main(String[] args) {
        Printable p = new PrintableImpl();
        printString(p);

   /*     printString(new Printable() {
            @Override
            public void print(String s) {
                new MethodRefObject().printUpperCaseString(s);
            }
        });*/
//        printString((s)->{
//            MethodRefObject obj = new MethodRefObject();
//            obj.printUpperCaseString(s);
//        });

         /*使用方法引用优化Lambda
        对象是已经存在的MethodRerobject
        成员方法也是已经存在的printuppercasestring
        所以我们可以使用对象引用成员方法*/
         // 创建MethodRefObject 对象
//        MethodRefObject obj = new MethodRefObject();
//        printString(obj::printUpperCaseString);
    }
}
