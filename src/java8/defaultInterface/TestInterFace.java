package java8.defaultInterface;

/**
 * @description:
 * @author: wangchao
 * @create: 2021-06-23 15:35
 **/
public interface TestInterFace {

    default void add(int a ){
        System.out.println( a + 100);
    }

    void plus();
}
