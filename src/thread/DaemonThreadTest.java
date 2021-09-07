package thread;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-09-07 11:17
 **/
public class DaemonThreadTest {


    public static void main(String[] args) {
        Thread t2 = new Thread(()->{
            while(Boolean.TRUE){
                System.out.println("本线程是--->>守护线程");
            }
        });
        t2.setDaemon(true);
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
