package futureTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-30 15:39
 **/
public class CompletionServiceTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        noBlocking();

    }
   //谨慎使用，因为队列中得task增加会导致oom
    public static void noBlocking() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService(executorService) ;

        System.out.println("叫几个朋友一起约一下，等下开车接你们哈");
         completionService.submit(() -> {
            System.out.println("老王收拾完得15分钟");
            TimeUnit.SECONDS.sleep(15);
            System.out.println("15分钟后，准备去接");
            return " 隔壁老王";
        });

        completionService.submit(() -> {
            System.out.println("老李收拾完得10分钟");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("10分钟后，准备去接");
            return " 老实人老李";
        });

        completionService.submit(() -> {
            System.out.println("二喵化妆5分钟");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("5分钟后，准备去接");
            return " 喵喵";
        });

        TimeUnit.SECONDS.sleep(1);
        System.out.println("都通知了，抽根烟等");

        for (int i = 0; i < 3; i++) {
            //
            System.out.println(completionService.take().get());
        }


    }


   //get 方法会阻塞，导致本来使5秒的已经返回结果，却需要等待 15 后在获取结果
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
}
