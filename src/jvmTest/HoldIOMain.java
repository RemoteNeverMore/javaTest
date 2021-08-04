package jvmTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoldIOMain{
    public static class HoldIOTask implements Runnable{
        byte[] bytes = new byte[1028*100];
        List<byte[]> list=new ArrayList<>();
        @Override
        public void run(){
            while(true){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(bytes);

            }
        }
    }
    public static class LazyTask implements Runnable{
        public void run(){
            try{
                while(true){
                    Thread.sleep(500);
                }
            }catch(Exception e){}
        }

    }
    public static void main(String[] args){    //四线程操作
        new Thread(new HoldIOTask()).start();
//        new Thread(new LazyTask()).start();
//        new Thread(new LazyTask()).start();
//        new Thread(new LazyTask()).start();
    }
}
