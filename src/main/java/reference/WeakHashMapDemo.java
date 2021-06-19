package reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Date: 2021/5/21 15:26
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("=======================");
        myWeakHashMap();
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);   // 强引用
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;  // 引用Integer 在map中是以Node结点存储的，这里key置空与map无关
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void myWeakHashMap() {
        // 弱引用 GC 会被回收，只要key 为null ，所指向的value就会被回收
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);   // 强引用
        String value = "WeakHashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}
