package proxy.jdk;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        MyFriend friend = new MyFriend();
        // 创建代理对象，这里有三个参数，第一个是类的ClassLoader，第二个是该类的接口集合，第三个就是InvocationHandler
        Object o = Proxy.newProxyInstance(friend.getClass().getClassLoader(),friend.getClass().getInterfaces(),new InvocationHandlerImpl(friend));
        Person person= (Person) o;
        System.out.println(person.getClass().getName());
        person.buyCar();
    }

}
