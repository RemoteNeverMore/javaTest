package singleton;

public class LazySingleton {

    private static   LazySingleton lazySingleton;

    private LazySingleton(){

    }
      //synchronized 浪费资源
//    public static synchronized  LazySingleton newInstance(){
//        if(null == lazySingleton){
//            lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }
        //双重检测锁模式
        public static   LazySingleton newInstance(){
            if(null == lazySingleton){
                synchronized(LazySingleton.class){
                    if(null == lazySingleton){
                        lazySingleton = new LazySingleton();
                    }
                }
            }
            return lazySingleton;
        }

}
