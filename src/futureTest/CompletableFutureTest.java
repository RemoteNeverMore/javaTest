package futureTest;

import java.util.concurrent.*;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-30 14:56
 **/
public class CompletableFutureTest {


    public static void main(String[] args) throws Exception{

        completableAsync();
//        supplyAsync();
//        runAsync();
//        otherStaticMethod();
//        handleException();
    }

    private static void handleException() {

        CompletableFuture<String> five_seconds_later = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----------start");
            try {
                TimeUnit.SECONDS.sleep(5);
                throw new NullPointerException();
            } catch (InterruptedException e) {
                throw new NullPointerException();
            }
        }).handleAsync((result, ex) -> {
            System.out.println(Thread.currentThread().getName() + "----2");
            if (ex != null) {
                return ex.getCause();
            }
            return result;
        }).thenApplyAsync(result -> {
            System.out.println(Thread.currentThread().getName() + "----3");
            System.out.println(result);
            return "Sssssssssssss";
        });
        five_seconds_later.join();

    }

    private static void completableAsync() {
        CompletableFuture<String> future  = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "----------start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("five seconds later");
            return "complete";
        });

        future.whenCompleteAsync((result,exception)->{
            if(exception != null){
                exception.printStackTrace();
            }
            System.out.println(result);
        });
        System.out.println("wait ------------completable  run");
        future.join();
    }

    private static void supplyAsync(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("executorService 是否为守护线程 :" + Thread.currentThread().isDaemon());
                return null;
            }
        });
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is lambda supplyAsync");
            System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //注释调get sleep2  会导致程序阻断
            System.out.println("this lambda is executed by forkJoinPool");
            return "result1";
        });
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is task with executor");
            System.out.println("supplyAsync 使用executorService 时是否为守护线程 : " + Thread.currentThread().isDaemon());
            return "result2";
        }, executorService);
//        System.out.println(completableFuture.get());
//        System.out.println(future.get());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        executorService.shutdown();
    }

    private static void runAsync(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("executorService 是否为守护线程 :" + Thread.currentThread().isDaemon());
                return null;
            }
        });
        CompletableFuture.runAsync(() -> {
            System.out.println("this is lambda supplyAsync");
            System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this lambda is executed by forkJoinPool");
        });
        CompletableFuture.runAsync(() -> {
            System.out.println("this is task with executor");
            System.out.println("supplyAsync 使用executorService 时是否为守护线程 : " + Thread.currentThread().isDaemon());
        }, executorService);
//        System.out.println(completableFuture.get());
//        System.out.println(future.get());
        executorService.shutdown();
    }


    public static void otherStaticMethod() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> futureOne = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("futureOne InterruptedException");
            }
            return "futureOneResult";
        });
        final CompletableFuture<String> futureTwo = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("futureTwo InterruptedException");
            }
            return "futureTwoResult";
        });
//        CompletableFuture future = CompletableFuture.allOf(futureOne, futureTwo);
//        System.out.println(future.get());
        CompletableFuture completableFuture = CompletableFuture.anyOf(futureOne, futureTwo);
        System.out.println(completableFuture.get());
    }


}
