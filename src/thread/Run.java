package thread;

 class MyThread extends Thread {
    public void run(){
        super.run();
        for(int i=0; i<50000; i++){
            System.out.println("i="+(i+1));
        }
    }
}

 public class Run {
    public static void main(String args[]){
        Thread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
            System.out.println("stop 1->" + thread.interrupted());
            System.out.println("stop 2->" + thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}