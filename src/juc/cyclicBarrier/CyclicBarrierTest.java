package juc.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-21 15:15
 **/
public class CyclicBarrierTest {

    private static CyclicBarrier cb = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            //每次await后都会执行这个方法，每个阶段的回调
            System.out.println("happy together");
        }
    });

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(()->{
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName+"到位");
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("first  step " + threadName);
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("second  step " + threadName);
            },"员工--"+ i);
            thread.start();
        }

    }
}
