package volalitate;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    volatile boolean  flag = true;
     public void load(){
         int i = 0;
         while (flag){
             i++;
         }
         System.out.println("jump loop");
    }

    public void refresh() {
        flag = false;
        System.out.println("刷新 flag 为 false");
    }
    public static void main(String[] args) throws InterruptedException {
         VolatileTest volatileTest = new VolatileTest();
        Thread thread = new Thread(volatileTest::load,"load_thread");
        Thread thread1 = new Thread(volatileTest::refresh,"load_thread");
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread1.start();
    }


}
