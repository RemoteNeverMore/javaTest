package juc.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-21 10:44
 **/
public class SemaphoreTest {
    //容量10
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new MyThreadTest(),"车" + i);
            thread.start();
        }

    }

    static class MyThreadTest implements Runnable{

        @Override
        public void run() {
            int count = semaphore.availablePermits();
            System.out.println("===="+Thread.currentThread().getName()+"来到停车场");
            if(count == 0){
                System.out.println(Thread.currentThread().getName() + "please wait moment");
            }
            System.out.println(Thread.currentThread().getName()+"成功进入停车场");
            try {
                semaphore.acquire();
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println(Thread.currentThread().getName()+"驶出停车场");
            System.out.println("剩余："+SemaphoreTest.semaphore.availablePermits());
        }
    }

}
