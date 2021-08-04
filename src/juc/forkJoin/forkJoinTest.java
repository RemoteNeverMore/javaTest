package juc.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-22 10:34
 **/
public class forkJoinTest {

    static class MyForkJoin extends RecursiveTask<Integer>{

        private int start;
        private int end;
        private int divideNum = 80;

        public MyForkJoin(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int totalValue = 0;
            if(end - start <= divideNum){
                System.out.println("开始计算的部分：start = " + start + ";end = " + end);
                for (int i = start; i <= end; i++) {
                    totalValue += i;
                }
            }else{
                MyForkJoin task1 = new MyForkJoin(start,(start+end)/2);
                MyForkJoin task2 = new MyForkJoin((start+end)/2 +1,end);
                task1.fork();
                task2.fork();
                totalValue = task1.join()+task2.join();
            }
            return totalValue;
        }
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new MyForkJoin(1, 1001));
        try {
            Integer sum = future.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
