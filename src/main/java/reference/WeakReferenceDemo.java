package reference;

import java.lang.ref.WeakReference;

/**
 * Date: 2021/5/21 15:07
 * 弱引用： 不管内存够不够用，只要进行GC，都会被垃圾回收
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("===============");
        System.out.println(o1);                 // null
        System.out.println(weakReference.get()); //null
    }
}
