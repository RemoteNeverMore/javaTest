package threadPoolTest;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-21 16:05
 **/
public class PoolTest {
    public static void main(String[] args) {
        /*
         int corePoolSize 核心线程数
         int maximumPoolSize 最大线程数
         long keepAliveTime 非核心线程超过时间则回收
         TimeUnit unit 时间单位
         BlockingQueue<Runnable> workQueue 存放线程的队列
         ThreadFactory threadFactory 创建线程的工程
         RejectedExecutionHandler handler 拒绝策略
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                4, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new MyThreadFactory("test"));
        AtomicInteger vat = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"开始执行");
            },"name ----- > " + i);
            threadPoolExecutor.execute(thread);
        }
    }

    private static void getPoolProperties(ThreadPoolExecutor threadPoolExecutor) {
        System.out.println(Thread.currentThread().getName());
    }


    static class MyThreadFactory implements ThreadFactory{

        /**
         * 此次线程池的任务名称
         */
        private String taskName = "executor";

        /**
         * 线程计数
         */
        private AtomicInteger count = new AtomicInteger(0);


        MyThreadFactory(String taskName){
            this.taskName = taskName;
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            String threadName =  "customExecutor_".toUpperCase() + taskName + count.addAndGet(1);
            thread.setName(threadName);
            return thread;
        }
    }

}
