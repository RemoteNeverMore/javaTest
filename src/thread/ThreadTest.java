package thread;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-07-26 13:43
 **/
public class ThreadTest {


    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                if(i == 50){
                    // 当前线程让出时间片，成就绪状态，也可能重新获取到cpu使用权限
                    Thread.yield();
                }
                System.out.println("thread1 -->"+i);
            }
        });

        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("thread2 -->"+i);
            }
        });
        thread1.start();
//        try {
//            TimeUnit.MILLISECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread2.start();
    }

}
