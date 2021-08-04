package thread;

import java.util.concurrent.*;

public class PoolTest {
    public static void main(String[] args) {
        ExecutorService poolExecutor = Executors.newSingleThreadExecutor();
        poolExecutor.execute(()-> System.out.println("s"));
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(12);


    }
}
