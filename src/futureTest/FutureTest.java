package futureTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-30 14:41
 **/
public class FutureTest {

    //Future 的 get 方法会导致线程阻塞，里边提供了两个重载的方法，一个是无限等待的方法，一个是带有超时时间的get
    public static void main(String[] args) throws Exception{
//        asyncSubmit();
//        asyncCallable();
          waitTest();
    }

    private static void waitTest() throws Exception{
        ExecutorService service = Executors.newCachedThreadPool();

        List<Future<String>> list = new ArrayList<>();
        Future<String> submit_15 = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(15);
                System.out.println("执行时长为1s的执行完成。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "sleep fifteen seconds";
        });
        list.add(submit_15);

        Future<String> submit_10 = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("执行时长为10s的执行完成。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "sleep ten seconds";
        });
        list.add(submit_10);

        Future<String> submit_5 = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("执行时长为5s的执行完成。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "sleep five seconds";
        });
        list.add(submit_5);

        for (Future<String> future:list) {
            System.out.println(future.get());
        }
    }

    private static void asyncCallable() {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(
                2,2,3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10)
        );
        Future<String> submit = tp.submit(() -> {
            System.out.println("future 0");
           return "callable future";
        });
        String s = null;
        try {
            s = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    private static void asyncSubmit() {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(
                2,2,3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10)
        );
        AtomicReference<String> s = new AtomicReference<>("S");
        Future<AtomicReference> submit = tp.submit(() -> {
            System.out.println("future 0");
            s.set("s");
        },s);
        AtomicReference atomicReference = null;
        try {
             atomicReference = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        atomicReference.get();
        System.out.println(atomicReference.get());
    }
}
