package reference;

/**
 * Date: 2021/5/21 14:44
 * 不管内存够不够用都不会被GC，会导致OOM
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();  // 这样定义的默认就是强引用
        Object obj2 = obj1;  // obj2 引用赋值
        obj1 = null;  // 置空
        System.gc();
        System.out.println(obj2);  // java.lang.Object@7106e68e
    }
}
