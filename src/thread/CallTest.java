package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-08-16 17:41
 **/
public class CallTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask(new Callable(){
            public String call() throws Exception {
                int a = 1;
//                if( a == 1){
//                    throw new Exception("sss");
//                }
                return "ssss";
            }
        });
        Thread t = new Thread(task);
        t.start();
        // get 方法会阻塞
        System.out.println(task.get());
    }

}
