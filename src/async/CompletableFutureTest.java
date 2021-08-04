package async;

import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-30 14:56
 **/
public class CompletableFutureTest {


    public static void main(String[] args) throws Exception{


//        completableAsync();
        handleException();
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
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("five seconds later");
            return "complete";
        });

        future.whenComplete((result,exception)->{
            if(exception != null){
                exception.printStackTrace();
            }
            System.out.println(result);
        });

        System.out.println("wait ------------completable  run");
        Thread thread = Thread.currentThread();
        future.join();
    }


}
