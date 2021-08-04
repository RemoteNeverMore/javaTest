package jvmTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Test {
    private byte[] by = new byte[10*1024];

    public static void main(String[] args) {
//        List<Test> list = new ArrayList<>();
//        while(true){
//            list.add(new Test());
//            try {
//                TimeUnit.MILLISECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        initSet();




//        String s = "s/test?connect=replicaSet&slaveOk=true&replicaSet=rs0&readPreference=primary";
//        String target = s.substring(s.lastIndexOf('/')+1,s.lastIndexOf("?")+);
//        System.out.println(target);

    }

    private static void initSet() {
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input;
//        try {
//            while ((input = br.readLine()) != null) {
//                if(input.equals("start")){
//                    Set<String> set = new HashSet<>();
//                    for (int i = 100000; i < 999999 ; i++) {
//                        set.add(String.valueOf(i));
//                    }
//                    System.out.println(set.size());
//
//                }else{
//                    return;
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        while(true){
           new Thread(()->{
               String tName = Thread.currentThread().getName();
               System.out.println("启动线程-----------"+tName);
           }).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
