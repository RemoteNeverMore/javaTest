package futureTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-30 14:41
 **/
public class FutureTest {

    private final static Map<String, Future<Integer>> SCORE_CACHE = new ConcurrentHashMap<>();
    //Future 的 get 方法会导致线程阻塞，里边提供了两个重载的方法，一个是无限等待的方法，一个是带有超时时间的get
    public static void main(String[] args) throws Exception{
//        asyncSubmit();
//        asyncCallable();

//        SCORE_CACHE.put("sss",null);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ScoreQueryService scoreQueryService = new ScoreQueryService();
        for (int i = 0; i < 3; i++) {
            executorService.execute(()->{
                try {
                    Integer cw = scoreQueryService.query("cw");
                    System.out.println("cw = " + cw);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        //System.out.println(1 << 8);
        //waitTest();
    }




    private static void waitTest() throws Exception{
        ExecutorService service = Executors.newCachedThreadPool();

        Future<?> future = service.submit(()->{
            System.out.println("xxxxx");
            int a = 1/0;
            return "xxxxx";
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        List<Future<String>> list = new ArrayList<>();
//        Future<String> submit_15 = service.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(15);
//                System.out.println("执行时长为1s的执行完成。");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "sleep fifteen seconds";
//        });
//        list.add(submit_15);
//
//        Future<String> submit_10 = service.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1000000);
//                System.out.println("执行时长为10s的执行完成。");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "sleep ten seconds";
//        });
//        list.add(submit_10);
//
//        Future<String> submit_5 = service.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println("执行时长为5s的执行完成。");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "sleep five seconds";
//        });
//        list.add(submit_5);
//
//        for (Future<String> future:list) {
//            System.out.println(future.get());
//        }
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
