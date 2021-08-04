package singleton;

public class HungrySingleton {
    private static  final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton newInstance(){
        return hungrySingleton;
    }
}
