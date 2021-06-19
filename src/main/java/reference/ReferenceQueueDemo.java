package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Date: 2021/5/21 15:42
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("===============================");

        o1 = null;
        System.gc();
        Thread.sleep(500);  // 保证一定被GC

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());   // GC前会将引用放入队列

    }
}
