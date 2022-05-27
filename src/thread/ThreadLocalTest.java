package thread;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-17 18:12
 **/
public class ThreadLocalTest {
    private static  ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
//
//        Thread thread1 = new Thread(() -> {
//            threadLocal.set("woshishui");
//            System.out.println("thread1->" + threadLocal.get());
//        }, "thread1");
//
//        Thread thread2 = new Thread(() -> {
//            System.out.println("thread2->" + threadLocal.get());
//        }, "thread2");
//        thread1.start();
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread2.start();


//
//        float a = 1.0f - 0.8f;
//        float b = 0.3f - 0.1f;
//        System.out.println(a ==b);
//        System.out.println(a);
//        System.out.println(b);
//
//        Float x = Float.valueOf(a);
//        Float y = Float.valueOf(b);
//        System.out.println(x.equals(y));
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(()-> testLeak());
//            thread.start();
//        }
//        TimeUnit.SECONDS.sleep(190);
        Object o = new Object();
        WeakReference weakReference = new WeakReference(o);
        System.out.println(weakReference.get());
        o = null;
        System.gc();
        System.out.println(weakReference.get());
    }

    private static  void testLeak(){
        threadLocal.set(Thread.currentThread().getName());
    }

}
