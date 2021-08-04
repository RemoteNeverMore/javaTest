package singleton;

public class LazySingleton_V1 {


    private LazySingleton_V1(){

    }
     static class innerClass{
          static final LazySingleton_V1  lazySingleton = new LazySingleton_V1();
             public static LazySingleton_V1 newInstance() {
                return  innerClass.lazySingleton;

            }
     }



}
