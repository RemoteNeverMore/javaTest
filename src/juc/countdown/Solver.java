package juc.countdown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Solver {

        CyclicBarrier barrier;

        class Worker implements Runnable {

            private String name;

            public Worker(String name) {
                this.name = name;
            }

            public void run() {
                try {
                    int await = barrier.await();
                    System.out.println("" + name + "第" + await + "个到达门口");
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
            }
        }

        public void eatKFC(int numbers) throws InterruptedException {

            Runnable barrierAction = new Runnable() {
                public void run() {
                    System.out.println("都到齐了，看看谁先到的");
                }
            };
            barrier = new CyclicBarrier(numbers, barrierAction);
            new Thread(new Worker("你二叔")).start();
            new Thread(new Worker("你大舅")).start();
            new Thread(new Worker("你七大爷")).start();
            new Thread(new Worker("你五叔")).start();
        }

        public static void main(String[] args) {
//            Solver solver = new Solver();
//            try {
//                solver.eatKFC(4);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            testCD();
        }



        static void testCD(){
//            CountDownLatch cl = new CountDownLatch(1);
//            for (int i = 0; i < 5; i++) {
//                Thread thread = new Thread(()-> {
//                        System.out.println(Thread.currentThread().getName() + "     ready");
//                        try {
//                            cl.await();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println(Thread.currentThread().getName() + "     complete");
//                    }
//                ,"name--"+i);
//                thread.start();
//            }
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            cl.countDown();

            CountDownLatch cl = new CountDownLatch(1);
            for (int i = 0; i < 5; i++) {
                new Thread(() -> {
                    try {
                        //准备完毕……运动员都阻塞在这，等待号令
                        cl.await();
                        String parter = "【" + Thread.currentThread().getName() + "】";
                        System.out.println(parter + "开始执行……");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cl.countDown();// 发令枪：执行发令


        }

}
