package proxy.jdk;

public class MyFriend implements Person {


    @Override
    public void buyCar() {
        System.out.println("我的朋友要买车了");
    }

    @Override
    public void makeMoney() {
        System.out.println("makeMoney");
    }
}
